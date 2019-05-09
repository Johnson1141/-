package test1.test1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test1.test1.entity.CEntity;
import java.util.List;
import java.util.Map;


//增删查改
//管理员增加课程，删除课程，查找所有的课
public interface CRepository extends JpaRepository<CEntity,Integer> {
    //List<CEntity> findAll();
    //void deleteByKh();
    CEntity findByKh(int kh);

    @Query(nativeQuery = true,value = "select c.kh,c.km,c.xf,c.xs from c,s " +
            "where c.kh in " +
            "(select e.kh from e where e.gh=?1)")
    Page<Map<String,Object> > findById(Integer gh, Pageable pageable);
}
