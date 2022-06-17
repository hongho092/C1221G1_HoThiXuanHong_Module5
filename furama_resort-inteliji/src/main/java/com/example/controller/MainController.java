package com.example.controller;

import com.example.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/login")
public class MainController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login/login_page";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {

        model.addAttribute("title", "Logout");
        return "login/logoutSuccessfulPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            System.out.println(loginedUser.getUsername());
            System.out.println(loginedUser.getPassword());
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Xin chào " + principal.getName() + "<br> Bạn không quyền vào trang này. Xin lỗi!";
            model.addAttribute("message", message);
        }
        return "login/403Page";
    }

}


/*
WebUtils làm việc với controller để lấy thông tin của (user) và (role của user) thông qua principal(đối tượng đã đăng nhập) được truyền vào
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "userInfoPage";
    }
 */
