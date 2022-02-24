package xyz.akaksr.scs.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.akaksr.scs.service.LoginService;
import xyz.akaksr.scs.service.ServerService;
import xyz.akaksr.scs.type.Type;
import xyz.akaksr.scs.util.map.ConvertHashMap;
import xyz.akaksr.scs.vo.LoginVo;
import xyz.akaksr.ssh.controller.SSHController;
import xyz.akaksr.ssh.vo.SSHVo;

@RestController
@RequestMapping("/api")
public class ApiController {
    private Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    ServerService serverService;

    @PostMapping("/login")
    public Object login(HttpServletRequest request, Model model, HttpSession session) {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String type = Type.LOGIN.toString();

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("pwd", pwd);

        LoginVo result = loginService.login(hashMap);
        logger.info("로그인 정보 = " + result);

        session = request.getSession();
        session.setAttribute(type, result);

        return result;
    }

    @PostMapping("/register")
    public Object register(HttpServletRequest request) {
        String USER_ID = request.getParameter("user_id");
        String USER_PWD = request.getParameter("user_pwd");
        String USER_NM = request.getParameter("user_nm");

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("USER_ID", USER_ID);
        hashMap.put("USER_PWD", USER_PWD);
        hashMap.put("USER_NM", USER_NM);

        int result = loginService.register(hashMap);
        logger.info("가입 메소드 동작 여부 = " + result);

        return result;
    }

    @PostMapping("/getlog")
    public Object getServerInfo(HttpServletRequest request) {
        String serverData = request.getParameter("server");
        ConvertHashMap convert = new ConvertHashMap(serverData);

        HashMap<String, String> hashMap = convert.getData();

        String username = request.getParameter("id");
        String password = request.getParameter("pass");

        SSHVo vo = new SSHVo(username, hashMap.get("server_ip"), 22, password);
        SSHController ssh = new SSHController();
        String result = "";

        try {
            Session session = ssh.connectSSH(vo);
            result = ssh.exec(session, "ls -al");
        } catch (JSchException e) {
            result = "서버 연결 오류 발생\n" + e.getMessage();
        }

        logger.info(result);

        return result;
    }
}
