package xyz.akaksr.scs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import xyz.akaksr.scs.vo.LoginVo;
import xyz.akaksr.scs.vo.ServerVo;

@Repository
@Mapper
public interface CommonMapper {
    LoginVo login(Map<String, String> map);

    int register(Map<String, String> map);

    List<ServerVo> getServerList();
}
