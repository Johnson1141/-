package test1.test1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.entity.AEntity;

public interface AdmRepository extends JpaRepository<AEntity,Integer> {
    AEntity findByUserid(Integer userid);
}
