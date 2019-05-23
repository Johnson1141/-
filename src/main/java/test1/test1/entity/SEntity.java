package test1.test1.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "s", schema = "test1", catalog = "")
public class SEntity {

    private int xh;
    private Date csrq;
    private String jg;
    private String sjhm;
    private Byte xb;
    private String xm;
    private Integer yxh;
    private String password;

    @Id
    @Column(name = "xh")
    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
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
    @Column(name = "jg")
    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    @Basic
    @Column(name = "sjhm")
    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
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
    @Column(name = "xm")
    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
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
        SEntity sEntity = (SEntity) o;
        return xh == sEntity.xh &&
                Objects.equals(csrq, sEntity.csrq) &&
                Objects.equals(jg, sEntity.jg) &&
                Objects.equals(sjhm, sEntity.sjhm) &&
                Objects.equals(xb, sEntity.xb) &&
                Objects.equals(xm, sEntity.xm) &&
                Objects.equals(yxh, sEntity.yxh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xh, csrq, jg, sjhm, xb, xm, yxh);
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SEntity{" +
                "xh=" + xh +
                ", csrq=" + csrq +
                ", jg='" + jg + '\'' +
                ", sjhm='" + sjhm + '\'' +
                ", xb=" + xb +
                ", xm='" + xm + '\'' +
                ", yxh=" + yxh +
                ", password='" + password + '\'' +
                '}';
    }
}
