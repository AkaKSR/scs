package xyz.akaksr.scs.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {
    private Logger logger = LoggerFactory.getLogger(PanelController.class);

    @RequestMapping("/serverList")
    public String getServerList(HttpServletRequest request, Model model) {
        logger.info("getServerList 호출");
        return "panel/serverList";
    }
}
