package xyz.akaksr.scs.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.akaksr.scs.mapper.CommonMapper;
import xyz.akaksr.scs.vo.LoginVo;

@Service
public class LoginService {

    @Autowired
    public CommonMapper mapper;

    public LoginVo login(Map<String, String> hashMap) {
        return mapper.login(hashMap);
    }

    public int register(Map<String, String> hashMap) {
        return mapper.register(hashMap);
    }
}
