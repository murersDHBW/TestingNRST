package com.example.helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerLog {

    public ServerLog(String serverAdress, int serverPort) {
        ServerAdress = serverAdress;
        ServerPort = serverPort;
    }

    public String ServerAdress;

    public int ServerPort;

    private final DateTimeFormatter _dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public void WriteInfo(String msg) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[" + _dtf.format(now) + "] INFO:" + msg);
    }

}
