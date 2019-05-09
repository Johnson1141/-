package test1.test1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test1.test1.entity.OEntity;
import test1.test1.entity.OEntityPK;

import java.util.List;
import java.util.Map;

//学生 看所有课
//老师 看自己有那些课
//管理员 删增


public interface ORepository extends JpaRepository<OEntity,OEntityPK> {
    //按课号升序 返回页表对象
    @Query(value = "SELECT new test1.test1.repository.ViewCourse(o,t.xm,c) FROM TEntity t,OEntity o,CEntity c WHERE t.gh = o.gh " +
            "and o.kh =c.kh order by o.kh asc")
    Page<ViewCourse> findViewCourse(Pageable pageable);


//    @Query(value = "select new test1.test1.repository.ViewCourse(o,t.xm,c) from TEntity t,OEntity o,CEntity c where IF(:kh ,o.kh=:kh,1=1) " +
//            "and if(?2 !='',o.km like %?2%,1=1) " +
//            "and if(?3 !='',t.xm like %?3%,1=1) " +
//            "and if(?4 !='',o.sksj like %?4%,1=1) " +
//            "and if(?5 != 0,c.xf=?5,1=1) " +
//            "and t.gh=o.gh " +
//            "and o.kh=c.kh order by o.kh asc")
//    Page<ViewCourse> find(@Param("kh") int kh,String km,String tname,String sksj,int xf,Pageable pageable);
//private int xh;
//    private String xq;
//    private int kh;
//    private int gh;
//    private Integer pscj;
//    private Integer kscj;
//    private Integer zpcj;
//    private String sksj;
//    private String tname;
//    private String cname;
//    private int num;
//    private int xf;

    @Query(value = "select o.sksj,o.xq,o.kh,o.gh,t.xm,c.km,o.num,c.xf " +
            "from t,o,c where if( ?1 is not null,o.kh=?1,1=1) " +
            //"and if( ?2!='',?2 like c.km,1=1)" +
            "and if( ?2!='',c.km like CONCAT('%',?2,'%'),1=1) " +
            "and if( ?3!='',t.xm like CONCAT('%',?3,'%'),1=1) " +
            "and if( ?4!='',o.sksj like CONCAT('%',?4,'%'),1=1) " +
            "and if( ?5 is not NULL,c.xf = ?5,1=1) " +
            "and t.gh=o.gh " +
            "and o.kh=c.kh order by o.kh asc",nativeQuery = true)
    Page<Map<String,Object>> find(Integer kh,String km,String tname,String sksj,Integer xf,Pageable pageable);

    //管理员删除开课,就是不开了
    void deleteByKhAndGhAndXq(int kh,int gh,String xq);
    //加课就不写了

    //查一个老师开了那些课
    List<OEntity> findAllByGh(int gh);

}
