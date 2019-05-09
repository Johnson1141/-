package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test1.test1.repository.CRepository;

import java.util.Map;

@Transactional
@Service
public class CService {

    @Autowired
    CRepository cRepository;

    public  Page<Map<String,Object> > findbygh(Integer gh, Integer page,Integer size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return cRepository.findById(gh,pageRequest);
    }
}
