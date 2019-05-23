package test1.test1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test1.test1.entity.TEntity;
import test1.test1.repository.TRepository;

import java.awt.print.Pageable;

@Service
@Transactional
public class TService {
    @Autowired
    TRepository tRepository;

    public Page<TEntity> show_t(int page,int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return tRepository.findAll(pageRequest);
    }

    public TEntity findbygh(int gh){
        return tRepository.findByGh(gh);
    }

    public void DeleteTea(int gh){
        tRepository.deleteByGh(gh);
    }

    public void addTea(TEntity tEntity){
        tRepository.save(tEntity);
    }



}
