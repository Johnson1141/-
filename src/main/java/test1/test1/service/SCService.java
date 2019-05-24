package test1.test1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test1.test1.entity.EEntity;
import test1.test1.repository.SCRepository;
import test1.test1.repository.ViewSC;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class SCService {
    @Autowired
    private SCRepository scRepository;

//    public List<EEntity> getallbyxh(int x) {
//        return scRepository.getAllByXh(x);
//    }

    public boolean usaveSC(EEntity eEntity){ //必须不存在这一门选课
        try{
            if(!scRepository.getAllByXhAndKh(eEntity.getXh(),eEntity.getKh()).isEmpty()) return false;
            scRepository.save(eEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updatecj(Integer xh,Integer kh,Integer gh,Integer pscj,Integer kscj,Integer zpcj){
        try{
            scRepository.updatecj(xh,kh,gh,pscj,kscj,zpcj);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean delSC(EEntity eEntity){
        try{
            if(scRepository.getAllByXhAndKh(eEntity.getXh(),eEntity.getKh()).isEmpty()) return false;
            scRepository.delete(eEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<EEntity> TAllC(int gh,int kh){
        return scRepository.getAllByGhAndKh(gh,kh);
    }

    public void SDelC(int xh,int kh){
        scRepository.deleteByXhAndKh(xh,kh);
    }

    public Page<EEntity> allpage(Pageable pageable){
        return scRepository.findAll(pageable);
    }

    public List<ViewSC> xk_user_Course(int xh){
        return scRepository.getAllByXh(xh);
    }

    public Page<Map<String,Object>> showsc_t_c(Integer gh,Integer kh,Integer page,Integer size){
        PageRequest pageRequest = PageRequest.of(page,size);

        return scRepository.findkhandgh(kh,gh,pageRequest);
    }
}

