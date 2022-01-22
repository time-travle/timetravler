package org.joven.base.utils;

import org.apache.commons.lang3.RandomUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 端口号工具
 */
public class ServerPortUtils {
    private static final int MAX_PORT = 65535;
    private static final int MIN_PORT = 8000;

    /**
     * 获取可用端口
     *
     * @return
     */
    public static int getAvailablePort() {
        int port = RandomUtils.nextInt(MIN_PORT, MAX_PORT);
        boolean using = isLocalPortUsing(port);
        if (using) {
            return getAvailablePort();
        } else {
            return port;
        }
    }

    /**
     * 测试本机端口是否被使用
     *
     * @param port 端口
     */
    public static boolean isLocalPortUsing(int port) {
        return isPortUsing("127.0.0.1", port);
    }

    /***
     * 测试主机Host的port端口是否被使用
     * @param host IP地址
     * @param port 端口
     */
    public static boolean isPortUsing(String host, int port) {
        boolean flag = false;
        try {
            InetAddress Address = InetAddress.getByName(host);
            new Socket(Address, port);  //建立一个Socket连接
            flag = true;
        } catch (IOException e) {
        }
        return flag;
    }
}
