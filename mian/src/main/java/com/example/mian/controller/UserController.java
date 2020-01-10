package com.example.mian.controller;


import com.example.mian.entity.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    UserService userService;
    @RequestMapping("/user")
    public UserBean getUser(HttpServletRequest httpServletRequest) {
        logger.debug("日志：");
        String name= (String) httpServletRequest.getAttribute("username");
        return null;
    }
}
