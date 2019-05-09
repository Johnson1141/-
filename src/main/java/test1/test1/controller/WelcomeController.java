package test1.test1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    @GetMapping("welcome")
    public ModelAndView welcome(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.addObject("User",request.getSession().getAttribute("LoginUser"));
        mv.setViewName("welcome");
        return mv;
    }
}
