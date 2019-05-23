package test1.test1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import test1.test1.entity.*;
import test1.test1.service.CService;
import test1.test1.service.OService;
import test1.test1.service.SService;
import test1.test1.service.TService;

@RestController
public class AdminController {
    @Autowired
    SService sService;
    @Autowired
    TService tService;
    @Autowired
    OService oService;
    @Autowired
    CService cService;
//学生操作
    //所有
    @RequestMapping("/admin/allstu")
    public Page<SEntity> allstu(Integer page,Integer size){
        return sService.show_s(page-1,size);
    }
    //查找
    @RequestMapping("/admin/stuid")
    public SEntity findbyxh(Integer xh){
        return sService.findbyid(xh);
    }
    //加入
    @RequestMapping("/admin/addstu")
    public Integer allstu(SEntity sEntity){
        System.out.println(sEntity.toString());
        try{
            sService.AddStu(sEntity);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
    //删除
    @RequestMapping("/admin/deletestu")
    public Integer deleteStu(Integer xh){
        try {
            sService.DeleteStu(xh);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
//老师操作类似
    @RequestMapping("/admin/alltea")
    public Page<TEntity> alltea(Integer page, Integer size){
        return tService.show_t(page-1,size);
    }
    //查找
    @RequestMapping("/admin/teaid")
    public TEntity findbygh(Integer gh){
        return tService.findbygh(gh);
    }
    //加入
    @RequestMapping("/admin/addtea")
    public Integer addtea(TEntity tEntity){
        try{
            tService.addTea(tEntity);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
    //删除
    @RequestMapping("/admin/deletetea")
    public Integer deletetea(Integer gh){
        try {
            tService.DeleteTea(gh);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
//加课
    //所有课程
    @RequestMapping("/admin/allcourse")
    public Page<CEntity> allcourse(Integer page, Integer size){
        return cService.show_c(page-1,size);
    }
    //查找
//    @RequestMapping("/admin/courseid")
//    public CEntity findbygh(Integer gh){
//        return tService.findbygh(gh);
//    }

    //加入
    @RequestMapping("/admin/addcourse")
    public Integer addcourse(CEntity cEntity){
        try{
            cService.AddCourse(cEntity);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
    //删除
    @RequestMapping("/admin/deletecourse")
    public Integer deletecourse(Integer kh){
        try {
            cService.DeleteCourse(kh);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }




//开不开课
    @RequestMapping("/admin/allopen")
    public Page<OEntity> show_o(Integer page,Integer size ){
        return oService.show_o(page-1,size);
    }


    @RequestMapping("/admin/addopen")
    public Integer addopen(OEntity oEntity){
        try{
            oService.AddOpenCourse(oEntity);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @RequestMapping("/admin/deleteopen")
    public Integer deleteopen(OEntityPK oEntityPK){
        try {
            oService.DeleteOpenCourse(oEntityPK);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }




    //页面的显示

    //stu
    @RequestMapping("/adm/stu")
    public ModelAndView stu(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/A/stu");
        return mv;
    }
    //tea
    @RequestMapping("/adm/tea")
    public ModelAndView tea(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/A/tea");
        return mv;
    }
    //course
    @RequestMapping("/adm/course")
    public ModelAndView course(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/A/course");
        return mv;
    }
    //open
    @RequestMapping("/adm/open")
    public ModelAndView open(){
        ModelAndView mv= new ModelAndView();
        mv.setViewName("/A/open");
        return mv;
    }
}
