package org.joven.websocket.client.configclient;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@Slf4j
public class WebSocketSendClient {
    /**
     * @param url     WebSocket服务端URI
     * @param message websocket服务端发送数据
     */
    public void sendMessage(URI url, String message) {
        log.debug("发往服务器:{}  的信息:{}", url, message);
        CustomerWebSocketClient myClient = new CustomerWebSocketClient(url);
        myClient.send(message);
    }
}
