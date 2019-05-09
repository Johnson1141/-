package test1.test1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.entity.SEntity;

public interface SRepository extends JpaRepository<SEntity,Integer> {
    SEntity findByXh(Integer xh);
}
