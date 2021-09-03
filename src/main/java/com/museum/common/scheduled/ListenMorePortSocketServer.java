package com.museum.common.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

    /**
     * @author zhongzhilong
     * @date 2021/5/31
     * @description 服务端同时监听多个端口
     */
 @Component
  public class ListenMorePortSocketServer {
        /**
         * 同时监听9088,9089端口
         */
        private final List<Integer> portList = Arrays.asList(8088, 8090);

        /**
         * 具体的业务逻辑
         */
        public void run() {
            for (Integer port : portList) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ServerSocket serverSocket = new ServerSocket(port);
                            System.out.println("服务端开始监听端口：" + port);
                            // 持续监听端口
                            while (true) {
                                // 阻塞直接监听到端口请求
                                Socket socket = serverSocket.accept();
                                socket.setKeepAlive(true);
                                int localPort = socket.getLocalPort();
                                System.out.println("当前请求服务器的端口号为：" + localPort);
                                while (!socket.isClosed()) {
                                    InputStream is = socket.getInputStream();
                                    byte[] bytes = new byte[1024];
                                    is.read(bytes);
                                    String msg = new String(bytes, "utf-8");
                                    System.out.println("我是服务端,端口号为：" + localPort + "的客户端说：" + msg);
                                }
                                // socket.shutdownInput();
                                // is.close();
                                // socket.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        }
        @Scheduled(cron = "0 0 0 1 * ?")
        public  void ew(){
            ListenMorePortSocketServer listenMorePortSocketServer = new ListenMorePortSocketServer();
            listenMorePortSocketServer.run();
        }
    }

