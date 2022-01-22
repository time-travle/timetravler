package org.joven.base.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;


public class BaseUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(BaseUtil.class);

    /**
     * 设置一个空闲的端口
     */
    public static int setAvailablePort(String[] args) {
        String serverPort = "";
        int port = 0;
        if (args != null) {
            boolean isServerPort = false;
            for (String arg : args) {
                if (StringUtils.hasText(arg) && arg.startsWith("--server.port")) {
                    isServerPort = true;
                    serverPort = arg;
                    break;
                }
            }
            // 没有指定端口 ， 则随机生成一个可用的端口
            if (!isServerPort) {
                port = getAvailablePort();
                LOGGER.info("current  server.port={}", port);
                System.setProperty("server.port", String.valueOf(port));
            } else {
                LOGGER.info("current  server.port={}" + serverPort.split("=")[1]);
                // System.setProperty("server.port", serverPort.split("=")[1]);
                port = Integer.parseInt(serverPort.split("=")[1]);
            }
        }
        return port;
    }

    /**
     * 获取一个可用的空闲端口
     *
     * @return int 端口
     */
    public static int getAvailablePort() {
        ServerSocket serverSocket = null; //读取空闲的可用端口
        try {
            serverSocket = new ServerSocket(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverSocket != null ? serverSocket.getLocalPort() : 0;
    }
}
