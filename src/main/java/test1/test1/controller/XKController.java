package test1.test1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import test1.test1.entity.EEntity;
import test1.test1.repository.ViewCourse;
import test1.test1.repository.ViewSC;
import test1.test1.service.OService;
import test1.test1.service.SCService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class XKController {

    @RequestMapping("/CourseSelection")
    @ResponseBody
    public ModelAndView showmenu(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("timetable");
        return mv;
    }

    @Autowired
    private SCService scService;

    @RequestMapping("/xk/user_course")
    @ResponseBody
    public List<ViewSC> user_course(HttpSession session){
//        SessionData xx=(SessionData)(request.getSession().getAttribute("LoginUser"));
        return scService.xk_user_Course((int)(session.getAttribute("userId")));

    }

    @Autowired
    private OService oService;

    @RequestMapping("/xk/all_course")
    @ResponseBody
    public Page<ViewCourse> clist1(HttpServletRequest request, int page, int size){
        return oService.allpage(page-1,size);
    }
    @RequestMapping("/xk/add_course")
    @ResponseBody
    public boolean add_course(HttpSession session, EEntity eEntity){
//        SessionData sd =(SessionData)( request.getSession().getAttribute("LoginUser"));

        eEntity.setXh((int)(session.getAttribute("userId")));
        //eEntity.setXh(sd.getUserId());
        eEntity.setXq("2012-2013冬季");
        if(scService.usaveSC(eEntity)) return true;
        else return false;
    }

    @RequestMapping("/xk/del_course")
    @ResponseBody
    public boolean del_course(HttpSession session, EEntity eEntity){
        eEntity.setXh((int)(session.getAttribute("userId")));
        eEntity.setXq("2012-2013冬季");
        if(scService.delSC(eEntity)) return true;
        else return false;
    }


    @RequestMapping("/xk/search_course")
    @ResponseBody
    public Page<Map<String,Object>> slist(HttpServletRequest request, Integer page, Integer size, ViewCourse viewCourse) {
        //System.out.println(viewCourse);
        //System.out.println(viewCourse.getKh());

        return oService.searchpage(page-1,size,viewCourse);
    }
//    @RequestMapping("/xk/search_course")
//    @ResponseBody
//    public void slist(HttpServletRequest request,int page,int size,ViewCourse viewCourse) {
//        //return oService.searchpage(page-1,size,viewCourse);
//        System.out.println("1");
//    }
}
