package test1.test1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "o", schema = "test1", catalog = "")
@IdClass(OEntityPK.class)
public class OEntity {
    private String xq;
    private int kh;
    private int gh;
    private String sksj;
    private int num;

    @Id
    @Column(name = "xq")
    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    @Id
    @Column(name = "kh")
    public int getKh() {
        return kh;
    }

    public void setKh(int kh) {
        this.kh = kh;
    }

    @Id
    @Column(name = "gh")
    public int getGh() {
        return gh;
    }

    public void setGh(int gh) {
        this.gh = gh;
    }

    @Basic
    @Column(name = "sksj")
    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OEntity oEntity = (OEntity) o;
        return kh == oEntity.kh &&
                gh == oEntity.gh &&
                Objects.equals(xq, oEntity.xq) &&
                Objects.equals(sksj, oEntity.sksj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xq, kh, gh, sksj);
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}
