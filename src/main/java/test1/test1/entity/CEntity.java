package test1.test1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "c", schema = "test1", catalog = "")
public class CEntity {
    private int kh;
    private String km;
    private Integer xf;
    private Integer xs;
    private Integer yxh;

    @Id
    @Column(name = "kh")
    public int getKh() {
        return kh;
    }

    public void setKh(int kh) {
        this.kh = kh;
    }

    @Basic
    @Column(name = "km")
    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    @Basic
    @Column(name = "xf")
    public Integer getXf() {
        return xf;
    }

    public void setXf(Integer xf) {
        this.xf = xf;
    }

    @Basic
    @Column(name = "xs")
    public Integer getXs() {
        return xs;
    }

    public void setXs(Integer xs) {
        this.xs = xs;
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
        CEntity cEntity = (CEntity) o;
        return kh == cEntity.kh &&
                Objects.equals(km, cEntity.km) &&
                Objects.equals(xf, cEntity.xf) &&
                Objects.equals(xs, cEntity.xs) &&
                Objects.equals(yxh, cEntity.yxh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kh, km, xf, xs, yxh);
    }
}
