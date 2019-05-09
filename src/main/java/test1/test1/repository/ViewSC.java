package test1.test1.repository;

import test1.test1.entity.CEntity;
import test1.test1.entity.EEntity;
import test1.test1.entity.TEntity;

import java.io.Serializable;

public class ViewSC implements Serializable {
    private int xh;
    private String xq;
    private int kh;
    private int gh;
    private Integer pscj;
    private Integer kscj;
    private Integer zpcj;
    private String sksj;
    private String tname;
    private String cname;
    private int num;
    private int xf;

    public ViewSC(EEntity e, TEntity t, CEntity c,int num) {
        this.xh = e.getXh();
        this.xq = e.getXq();
        this.kh = e.getKh();
        this.gh = t.getGh();
        this.pscj = e.getPscj();
        this.kscj = e.getKscj();
        this.zpcj =e.getZpcj();
        this.sksj = e.getSksj();
        this.tname = t.getXm();
        this.cname = c.getKm();
        this.xf=c.getXf();
        this.num = num;
    }

    public int getXh() {
        return xh;
    }

    public int getXf() {
        return xf;
    }

    public void setXf(int xf) {
        this.xf = xf;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public int getKh() {
        return kh;
    }

    public void setKh(int kh) {
        this.kh = kh;
    }

    public int getGh() {
        return gh;
    }

    public void setGh(int gh) {
        this.gh = gh;
    }

    public Integer getPscj() {
        return pscj;
    }

    public void setPscj(Integer pscj) {
        this.pscj = pscj;
    }

    public Integer getKscj() {
        return kscj;
    }

    public void setKscj(Integer kscj) {
        this.kscj = kscj;
    }

    public Integer getZpcj() {
        return zpcj;
    }

    public void setZpcj(Integer zpcj) {
        this.zpcj = zpcj;
    }

    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
