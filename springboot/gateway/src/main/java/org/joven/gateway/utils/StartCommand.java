package  org.joven.gateway.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class StartCommand {
    public StartCommand(String[] args) {
        if (args == null) {
            return;
        }
        boolean cloudModel = false;
        String serverModel = "";
        boolean commandPort = false;
        for (String arg : args) {
            if (!StringUtils.hasText(arg)) {
                continue;
            }
            if (arg.startsWith("--server.port")) {
                commandPort = true;
                continue;
            }
            if (!arg.startsWith("--server.model")) {
                continue;
            }
            serverModel = arg.split("=")[1];
            if ("cloud".equals(serverModel)) {
                cloudModel = true;
            }
        }
        log.debug("是不是cloud启动模式:{} 是否命令设置端口:{}", cloudModel, commandPort);
        if (!cloudModel || commandPort) {
            // 不是 cloud模式启动时 或者启动命令里面带有端口 就不进行端口设置了
            return;
        }
        String port = String.valueOf(ServerPortUtils.getAvailablePort());
        log.debug("Current project port is {}", port);
        System.setProperty("server.port", port);
    }
}
