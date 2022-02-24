package xyz.akaksr.ssh.vo;

import lombok.Data;

@Data
public class SSHVo {
    private String username;
    private String host;
    private int port;
    private String password;

    public SSHVo(String username, String host, int port, String password) {
        this.username = username;
        this.host = host;
        this.port = port;
        this.password = password;
    }
}
