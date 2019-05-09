package test1.test1.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EEntityPK implements Serializable {
    private int xh;
    private String xq;
    private int kh;
    private int gh;

    @Column(name = "xh")
    @Id
    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    @Column(name = "xq")
    @Id
    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    @Column(name = "kh")
    @Id
    public int getKh() {
        return kh;
    }

    public void setKh(int kh) {
        this.kh = kh;
    }

    @Column(name = "gh")
    @Id
    public int getGh() {
        return gh;
    }

    public void setGh(int gh) {
        this.gh = gh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EEntityPK eEntityPK = (EEntityPK) o;
        return xh == eEntityPK.xh &&
                kh == eEntityPK.kh &&
                gh == eEntityPK.gh &&
                Objects.equals(xq, eEntityPK.xq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xh, xq, kh, gh);
    }
}
