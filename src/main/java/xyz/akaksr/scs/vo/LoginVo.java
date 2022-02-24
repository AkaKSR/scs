package xyz.akaksr.scs.vo;

import lombok.Data;

@Data
public class LoginVo {
    public int user_idx;
    public String group_idx;
    public String user_id;
    public String user_pwd;
    public String user_nm;
    public String created_dt;
    public int confirm;
}
