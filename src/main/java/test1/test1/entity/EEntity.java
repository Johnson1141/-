package test1.test1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "e", schema = "test1", catalog = "")
@IdClass(EEntityPK.class)
public class EEntity {
    private Integer xh;
    private String xq;
    private Integer kh;
    private Integer gh;
    private Integer pscj;
    private Integer kscj;
    private Integer zpcj;
    private String sksj;

    @Id
    @Column(name = "xh")
    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

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
    public Integer getKh() {
        return kh;
    }

    public void setKh(Integer kh) {
        this.kh = kh;
    }

    @Id
    @Column(name = "gh")
    public Integer getGh() {
        return gh;
    }

    public void setGh(Integer gh) {
        this.gh = gh;
    }

    @Basic
    @Column(name = "pscj")
    public Integer getPscj() {
        return pscj;
    }

    public void setPscj(Integer pscj) {
        this.pscj = pscj;
    }

    @Basic
    @Column(name = "kscj")
    public Integer getKscj() {
        return kscj;
    }

    public void setKscj(Integer kscj) {
        this.kscj = kscj;
    }

    @Basic
    @Column(name = "zpcj")
    public Integer getZpcj() {
        return zpcj;
    }

    public void setZpcj(Integer zpcj) {
        this.zpcj = zpcj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EEntity eEntity = (EEntity) o;
        return xh == eEntity.xh &&
                kh == eEntity.kh &&
                gh == eEntity.gh &&
                Objects.equals(xq, eEntity.xq) &&
                Objects.equals(pscj, eEntity.pscj) &&
                Objects.equals(kscj, eEntity.kscj) &&
                Objects.equals(zpcj, eEntity.zpcj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xh, xq, kh, gh, pscj, kscj, zpcj);
    }

    @Basic
    @Column(name = "sksj")
    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
    }
}
