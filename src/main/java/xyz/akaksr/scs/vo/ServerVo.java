package xyz.akaksr.scs.vo;

import lombok.Data;

@Data
public class ServerVo {
    private int server_idx;
    private String group_idx;
    private int user_idx;
    private String server_nm;
    private String server_ip;
    private String server_desc;
    private String timestamp;
    private int status_cd;
}
