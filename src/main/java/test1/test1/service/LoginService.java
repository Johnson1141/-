package test1.test1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test1.test1.repository.AdmRepository;
import test1.test1.repository.SRepository;
import test1.test1.repository.TRepository;


@Transactional
@Service
public class LoginService {
    @Autowired
    private SRepository stu;
    @Autowired
    private TRepository tea;
    @Autowired
    private AdmRepository adm;

    public Object getUserById(Integer id,int userType) {
        String res;
        if(userType==1) {
            if(stu.findByXh(id)!=null){
                res=stu.findByXh(id).getPassword();
            }else return null;
        }
        else if(userType==2)
            if(tea.findByGh(id)!=null){
                res=tea.findByGh(id).getPassword();
            }else return null;
        else if(userType==3)
            if(adm.findByUserid(id)!=null){
                res=adm.findByUserid(id).getPassword();
            }else  return  null;
        else return null;
        return res;
    }

}
