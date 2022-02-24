package xyz.akaksr.scs.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.akaksr.scs.mapper.CommonMapper;
import xyz.akaksr.scs.vo.ServerVo;

@Service
public class ServerService {

    @Autowired
    public CommonMapper mapper;

    public List<ServerVo> getServerList() {
        return mapper.getServerList();
    }
}
