package test1.test1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test1.test1.entity.CEntity;
import java.util.List;
import java.util.Map;


//增删查改
//管理员增加课程，删除课程，查找所有的课
public interface CRepository extends JpaRepository<CEntity,Integer> {
    //List<CEntity> findAll();
    //void deleteByKh();
    CEntity findByKh(int kh);

    @Query(nativeQuery = true,value = "select * from c  " +
            "where c.kh in " +
            "(select e.kh from e,o where e.gh = ?1 and e.xq=o.xq and e.kh=o.kh)")
    Page<Map<String,Object> > findById(Integer gh, Pageable pageable);

    Page<CEntity> findAll(Pageable pageable);


    @Query(value = "call sec_to_time(?1) ", nativeQuery = true)
    int selectdByLike(@Param("pname") String pname);



}
