package test1.test1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import test1.test1.entity.EEntity;
import test1.test1.repository.SCRepository;
import test1.test1.repository.ViewSC;
import test1.test1.service.SCService;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class ViewController {
    @Autowired
    SCRepository scRepository;


    @RequestMapping("/view/stu")
    public ModelAndView viewstu(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/tongji/stu");
        return mv;
    }

    @RequestMapping("/view/tea")
    public ModelAndView viewtea(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/tongji/tea");
        return mv;
    }
    @RequestMapping("/view/getstu")
    public List<Object> getstu(HttpSession session){
        List<Object> res = new ArrayList<Object>();
        List<ViewSC> eEntities = scRepository.getAllByXh((Integer)session.getAttribute("userId"));
        List<String> cname=new ArrayList<>();
        List<Integer> cj=new ArrayList<>();

        for(int i=0;i<eEntities.size();i++){
            cname.add(eEntities.get(i).getCname());
            cj.add(eEntities.get(i).getZpcj());
        }
        res.add(cname);
        res.add(cj);
        return res;
    }

    @RequestMapping("/view/gettea")
    public List<Integer> gettea(HttpSession session,Integer kh){
        System.out.println(kh);
        System.out.println((Integer)session.getAttribute("userId"));

        List<Integer> eEntities = scRepository.getAllByGh((Integer)session.getAttribute("userId"),kh);
        eEntities.removeAll(Collections.singleton(null));
        return eEntities;
    }

}
