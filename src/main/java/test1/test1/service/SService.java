package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test1.test1.entity.SEntity;
import test1.test1.repository.SRepository;


@Service
@Transactional
public class SService {
    @Autowired
    private SRepository sRepository;

    public Page<SEntity> show_s(int page,int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return sRepository.findAll(pageRequest);
    }

    public void DeleteStu(Integer xh){
        sRepository.deleteByXh(xh);
    }

    public void AddStu(SEntity sEntity){
        sRepository.save(sEntity);
    }
    public SEntity findbyid(Integer id){
        return sRepository.findByXh(id);
    }
}
