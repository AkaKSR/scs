package xyz.akaksr.scs.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.akaksr.scs.mapper.CommonMapper;
import xyz.akaksr.scs.vo.CmdVo;
import xyz.akaksr.scs.vo.ServerVo;

@Service
public class ServerService {

    @Autowired
    public CommonMapper mapper;

    public List<ServerVo> getServerList(int user_idx) {
        return mapper.getServerList(user_idx);
    }

    public HashMap<String, Object> getServerData(String server_idx) {
        return mapper.getServerData(server_idx);
    }

    public List<CmdVo> getCmdList(String server_idx) {
        return mapper.getCmdList(server_idx);
    }
}
