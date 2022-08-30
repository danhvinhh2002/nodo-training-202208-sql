package edu.hanoi.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

@Controller
public class HomeController {
    public final static Logger LOGGER = Logger.getLogger(HomeController.class);
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("message","Hello Class");
        LOGGER.info("Da truy cap den trang nay");
        return mv;
    }
//    @RequestMapping("/")
//    String ll(){
//        System.out.println("ggggggg");
//        return "index";
//    }
    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(value = "error",required = false) String error){
            ModelAndView mv = new ModelAndView();
            mv.setViewName("login");
            if(error != null){
                mv.addObject("error","Sai ten hoac mat khau!");
            }
        return mv;
    }
    @RequestMapping(value = "/nguoi-dung")
    public ModelAndView forUser(){
        ModelAndView mv = new ModelAndView("login");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.addObject("message","Hello User"+auth.getName());
        return mv;
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest req, HttpServletResponse resp){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout((HttpServletRequest) req,resp,auth);
        }
        return "redirect:/login";
    }
}
