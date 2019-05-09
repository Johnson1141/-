package test1.test1.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "a", schema = "test1", catalog = "")
public class AEntity {
    private int userid;
    private String password;

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AEntity aEntity = (AEntity) o;
        return userid == aEntity.userid &&
                Objects.equals(password, aEntity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, password);
    }
}
