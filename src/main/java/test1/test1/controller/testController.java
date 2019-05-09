package test1.test1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test1.test1.entity.EEntity;
import test1.test1.service.OService;
import test1.test1.service.SCService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class testController {
    @Autowired
    SCService cCourseService;
    //千万别忘了这个
    @Autowired
    OService oService;
//    @RequestMapping("test")
//    @ResponseBody
//    public boolean clist(HttpServletRequest request, EEntity eEntity){
//        //
////        return cCourseService.saveSC(eEntity);
//    }
    @RequestMapping("test1")
    @ResponseBody
    public void clist1(HttpServletRequest request, EEntity eEntity){
        //
        cCourseService.SDelC(eEntity.getXh(),eEntity.getKh());
    }



}
