package test1.test1.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "t", schema = "test1", catalog = "")
public class TEntity {
    private int gh;
    private String xm;
    private Byte xb;
    private Date csrq;
    private String xl;
    private Double jbgz;
    private Integer yxh;
    private String password;

    @Id
    @Column(name = "gh")
    public int getGh() {
        return gh;
    }

    public void setGh(int gh) {
        this.gh = gh;
    }

    @Basic
    @Column(name = "xm")
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    @Basic
    @Column(name = "xb")
    public Byte getXb() {
        return xb;
    }

    public void setXb(Byte xb) {
        this.xb = xb;
    }

    @Basic
    @Column(name = "csrq")
    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    @Basic
    @Column(name = "xl")
    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    @Basic
    @Column(name = "jbgz")
    public Double getJbgz() {
        return jbgz;
    }

    public void setJbgz(Double jbgz) {
        this.jbgz = jbgz;
    }

    @Basic
    @Column(name = "yxh")
    public Integer getYxh() {
        return yxh;
    }

    public void setYxh(Integer yxh) {
        this.yxh = yxh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TEntity tEntity = (TEntity) o;
        return gh == tEntity.gh &&
                Objects.equals(xm, tEntity.xm) &&
                Objects.equals(xb, tEntity.xb) &&
                Objects.equals(csrq, tEntity.csrq) &&
                Objects.equals(xl, tEntity.xl) &&
                Objects.equals(jbgz, tEntity.jbgz) &&
                Objects.equals(yxh, tEntity.yxh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gh, xm, xb, csrq, xl, jbgz, yxh);
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
