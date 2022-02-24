package xyz.akaksr.scs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.akaksr.scs.panel.PanelType;
import xyz.akaksr.scs.service.ServerService;
import xyz.akaksr.scs.type.Type;
import xyz.akaksr.scs.vo.LoginVo;
import xyz.akaksr.scs.vo.ServerVo;

@Controller
public class MainController {
    private Logger logger = LoggerFactory.getLogger(MainController.class);
    private HttpSession session;

    @Autowired
    ServerService serverService;

    @RequestMapping("/")
    public String login(HttpServletRequest request, Model model) {
        logger.info("메인페이지 로드");
        return "views/login";
    }

    @RequestMapping("/main")
    public String main(HttpServletRequest request, Model model,
            @RequestParam(value = "fragment", required = true, defaultValue = "") String fragment,
            @RequestParam(value = "content", required = true, defaultValue = "") String content) {
        session = request.getSession();

        try {
            String type = Type.LOGIN.toString();
            LoginVo vo = (LoginVo) session.getAttribute(type);
            String panel = PanelType.getPanelData(content);

            logger.info("vo = " + vo);
            logger.info("user_idx = " + vo.user_idx);
            logger.info("group_idx = " + vo.group_idx);
            logger.info("fragment = " + fragment);
            logger.info("content = " + content);

            switch (content) {
                case "serverList":
                    List<ServerVo> serverList = serverService.getServerList();
                    model.addAttribute("serverList", serverList);
                    break;
            }

            model.addAttribute("id", vo.getUser_id());
            model.addAttribute("panelTitle", panel);
            model.addAttribute("fragment", fragment + "/" + content);
            model.addAttribute("content", content);

            if (vo.getGroup_idx().equals("0000")) {
                // 관리자 로그인
                return "admin/adminMain";
            } else {
                // 일반 사용자 로그인
                return "views/main";
            }
        } catch (NullPointerException e) {
            // e.printStackTrace();
            logger.info("로그인 정보 없음. = " + e);

            return "redirect:/";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        session = request.getSession();

        session.invalidate();

        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register(Model model, HttpServletRequest request) {
        logger.info("가입페이지 로드");
        return "views/register";
    }

    @RequestMapping("/oauth")
    public String oauth() {
        return "views/oauth";
    }

    @RequestMapping("/loadsrc")
    public String loadSrc(HttpServletRequest request) {
        String modalNm = request.getParameter("page");

        return "modal/" + modalNm;
    }
}
