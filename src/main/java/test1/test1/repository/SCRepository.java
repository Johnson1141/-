package test1.test1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test1.test1.entity.EEntity;
import test1.test1.entity.EEntityPK;

import java.util.List;
import java.util.Map;

//选课表
//因为选课表是根据开课表来的，不用控制根据学期查，控制学期是管理员的事情。
//对于就这个选课系统而言，就查询，删除，以及修改
//查询：学生根据查询他选所有的课 教师根据工号和课程号查询其课
//删除：学生退课，根据学号和课号删除，因为业务上控制，学生没办法一学期选一样的课
//插入：学生选课
public interface SCRepository extends JpaRepository<EEntity, EEntityPK> {

    @Query(value = "SELECT new test1.test1.repository.ViewSC(e,t,c,o.num) FROM TEntity t,EEntity e,CEntity c,OEntity o WHERE e.kh=o.kh and e.xq=o.xq and e.gh=o.gh " +
            "and t.gh = o.gh and o.kh =c.kh and e.xh=:xh order by e.kh asc")
    List<ViewSC> getAllByXh(@Param("xh") int xh);

    List<EEntity> getAllByGhAndKh(int gh,int kh);

    //业务查询不能重课
    List<EEntity> getAllByXhAndKh(int xh,int kh);

    void deleteByXhAndKh(int xh,int kh);
    //save不用重写

    //工号和课号 所有的课
    @Query(nativeQuery = true, value = "select distinct e.xh,s.xm,e.kh,c.km,e.pscj,e.kscj,e.zpcj from c,s,e " +
            "where e.kh=c.kh and e.xh=s.xh "
            +" and e.kh= :kh "
            +" and e.gh= :gh ")
    //select e.xh,s.xm,e.kh,c.km,e.pscj,e.kscj,e.zpcj from c,s,e where e.kh = c.kh and e.xh=s.xh and e.gh=101 and e.kh=8305004
    Page<Map<String,Object>> findkhandgh(@Param("kh") Integer kh,@Param("gh") Integer gh, Pageable pageable);

    @Modifying
    @Query(nativeQuery = true, value = "update e set e.pscj = ?4,e.kscj= ?5,e.zpcj=?6 where " +
            "e.xh=?1 and e.kh=?2 and e.gh=?3 ")
    void updatecj(Integer xh,Integer kh,Integer gh,Integer pscj,Integer kscj,Integer zpcj);
}
