package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import test1.test1.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginUserController {

    @Autowired
    private LoginService loginService;
//    private LoginUserRepository loginUserRepository;


    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
    @ResponseBody
    @RequestMapping("loginPage")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    @ResponseBody
    @PostMapping("login")
    public String login(HttpSession session, Integer userId, String password, Integer userType){
        //System.out.println(userId+password);
//        try{
//            Object Pword = loginService.getUserById(userId,userType);
//            System.out.println(Pword.toString());
//            System.out.println(password);
//
//            if(Pword==null){
//                System.out.println(Pword.toString());
//
//                return "no";
//            }else{
//                if(Pword.toString().equals(password)) {
//                    request.getSession().setAttribute("LoginUser",new SessionData(userId,userType));
//                    return "yes";
//                }
//                System.out.println(Pword.toString());
//                return "no";
//            }
//
//        }catch (Exception e) {
//            System.out.println(password);
//            return "no";
//        }
        Object Pword = loginService.getUserById(userId,userType);
        if(Pword==null){
            return "no";
        }else{
            if(Pword.toString().equals(password)) {
                //session.setAttribute("LoginUser",new SessionData(userId,userType));
                session.setAttribute("userId",userId);
                session.setAttribute("userType",userType);
                return "yes";
            }
            System.out.println(Pword.toString());
            return "no";
        }

    }

    @ResponseBody
    @RequestMapping("loginOut")
    public ModelAndView out(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        request.getSession().removeAttribute("LoginUser");
        return mv;
    }

    @ResponseBody
    @RequestMapping("home")
    public ModelAndView home(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index1");
        //mv.addObject("User",request.getSession().getAttribute("LoginUser"));
        return mv;
    }
}
