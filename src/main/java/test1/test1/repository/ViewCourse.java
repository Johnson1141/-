package test1.test1.repository;

import test1.test1.entity.CEntity;
import test1.test1.entity.EEntity;
import test1.test1.entity.OEntity;
import test1.test1.entity.TEntity;

import java.io.Serializable;

public class ViewCourse implements Serializable {
    private String xq;
    private Integer kh;
    private Integer gh;
    private String sksj;
    private Integer num;
    private String time;

    private Integer xf;

    private String tname;
    private String cname;
    public ViewCourse(){

    }

    public ViewCourse(int kh, String sksj, int xf, String tname, String cname) {
        System.out.println("yes");
        this.kh = kh;
        this.sksj = sksj;
        this.xf = xf;
        this.tname = tname;
        this.cname = cname;
    }
    public ViewCourse(String kh, String sksj, String xf, String tname, String cname) {
        if(kh.isEmpty()) this.kh = 0;
        this.sksj = sksj;
        if(xf.isEmpty()) this.xf = 0;
        this.tname = tname;
        this.cname = cname;
    }

    public ViewCourse(OEntity oEntity, String tname, CEntity C) {
        this.xq=oEntity.getXq();
        this.kh=oEntity.getKh();
        this.gh=oEntity.getGh();
        this.sksj=oEntity.getSksj();
        this.num=oEntity.getNum();
        this.tname = tname;
        this.cname = C.getKm();
        this.xf=C.getXf();
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public Integer getKh() {
        return kh;
    }

    public void setKh(Integer kh) {
        this.kh = kh;
    }

    public Integer getGh() {
        return gh;
    }

    public void setGh(Integer gh) {
        this.gh = gh;
    }

    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getXf() {
        return xf;
    }

    public void setXf(Integer xf) {
        this.xf = xf;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
