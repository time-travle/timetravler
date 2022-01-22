package org.joven.websocket.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 参考下面wiki：
 * https://blog.csdn.net/BHSZZY/article/details/106806056
 * https://blog.csdn.net/huangwen001/article/details/106062482
 * https://www.cnblogs.com/interdrp/p/7903736.html
 * https://www.cnblogs.com/bianzy/p/5822426.html
 *
 *
 * https://cloud.tencent.com/developer/article/1630798
 * https://www.zifangsky.cn/1355.html
 */
@Component
//前端连接的地址路径
@ServerEndpoint("/websocket/{sessionKey}")
@Slf4j
public class CustomerWebSocketServer {
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //它是线程安全的无序的集合
    private static CopyOnWriteArraySet<CustomerWebSocketServer> webSockets = new CopyOnWriteArraySet<>();
    //用来存放每个客户端对应的WebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static Map<String, Session> sessionPool = new HashMap<String, Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sessionKey") String key) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(key, session);
        //System.out.println("websocket消息 有新的连接，总数为:" + webSockets.size());
        log.debug("【websocket消息 onOpen】 有新的连接，总数为:{}", webSockets.size());
        sendAllMessage("欢迎您，客户端");
        addOnlineCount();
        log.info("当前websocket连接数：" + onlineCount);
    }


    public void onClose() {
        webSockets.remove(this);
        //System.out.println("【websocket消息】连接断开，总数为:" + webSockets.size());
        log.debug("【websocket消息onClose】连接断开，总数为:{}", webSockets.size());
        subOnlineCount();
        log.info("当前websocket连接数：" + onlineCount);
    }

    /**
     * 连接关闭调用的方法
     *
     * @param sessionKey url地址参数
     */
    @OnClose
    public void onClose(@PathParam("sessionKey") String sessionKey) {
        log.info("onClose 当前sessionKey连接数：" + sessionKey);
        if (StringUtils.isAnyEmpty(sessionKey)) {
            onClose();
            return;
        }
        if (webSockets.contains(sessionKey)) {
            webSockets.remove(sessionKey);
            subOnlineCount();
            log.info("当前websocket连接数：" + onlineCount);
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        if (null == session) {
            onMessage(message);
            return;
        }
        log.info("收到来自"+session.getId()+"的消息"+message);
    }

    public void onMessage(String message) {
        //System.out.println("【websocket消息】收到客户端消息:" + message);
        log.debug("【websocket消息onMessage】收到客户端消息:{}", message);
    }

    /**
     * 发生错误时调用
     *
     * @param session 可选的参数
     * @param error   错误消息
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.info(session.getId()+"连接发生错误"+error.getMessage());
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for (CustomerWebSocketServer webSocket : webSockets) {
            //System.out.println("【websocket消息】广播消息:" + message);
            log.debug("【websocket消息】广播消息:{}", message);
            webSocket.session.getAsyncRemote().sendText(message);
        }
    }

    // 此为单点消息 (发送文本)
    public void sendTextMessage(String key, String message) {
        Session session = sessionPool.get(key);
        if (session != null) {
            //同步发送 发送第二条时，必须等第一条发送完成
            //session.getBasicRemote().sendText(message);
            //异步发送
            session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        onlineCount--;
    }
}
