package test1.test1.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test1.test1.entity.OEntity;
import test1.test1.entity.OEntityPK;
import test1.test1.repository.ORepository;
import test1.test1.repository.ViewCourse;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class OService {
    @Autowired
    private ORepository oRepository;


    public Page<ViewCourse> allpage(int page, int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<ViewCourse> content=oRepository.findViewCourse(pageRequest);
        return content;
    }


    public Page<Map<String,Object>> searchpage(int page,int size,ViewCourse viewCourse){
        PageRequest pageRequest=PageRequest.of(page,size);
        System.out.println(viewCourse);
        Page<Map<String,Object>> content=oRepository.find(viewCourse.getKh(),viewCourse.getCname(),viewCourse.getTname(),viewCourse.getSksj(),viewCourse.getXf(),pageRequest);
        return content;
    }

    public void AddOpenCourse(OEntity oEntity){
        oRepository.save(oEntity);
    }

    public Page<OEntity> show_o(int page,int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return oRepository.findAll(pageRequest);
    }

    public void DeleteOpenCourse(OEntityPK oEntityPK){
        oRepository.deleteById(oEntityPK);
    }
}
