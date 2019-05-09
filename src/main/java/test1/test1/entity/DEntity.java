package test1.test1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "d", schema = "test1", catalog = "")
public class DEntity {
    private int yxh;
    private String mc;
    private String dz;
    private String lxdh;

    @Id
    @Column(name = "yxh")
    public int getYxh() {
        return yxh;
    }

    public void setYxh(int yxh) {
        this.yxh = yxh;
    }

    @Basic
    @Column(name = "mc")
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    @Basic
    @Column(name = "dz")
    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    @Basic
    @Column(name = "lxdh")
    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DEntity dEntity = (DEntity) o;
        return yxh == dEntity.yxh &&
                Objects.equals(mc, dEntity.mc) &&
                Objects.equals(dz, dEntity.dz) &&
                Objects.equals(lxdh, dEntity.lxdh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(yxh, mc, dz, lxdh);
    }
}
