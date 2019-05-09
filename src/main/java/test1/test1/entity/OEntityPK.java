package test1.test1.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OEntityPK implements Serializable {
    private String xq;
    private int kh;
    private int gh;

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
        OEntityPK oEntityPK = (OEntityPK) o;
        return kh == oEntityPK.kh &&
                gh == oEntityPK.gh &&
                Objects.equals(xq, oEntityPK.xq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xq, kh, gh);
    }
}
