package test1.test1.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.entity.SEntity;

public interface SRepository extends JpaRepository<SEntity,Integer> {
    SEntity findByXh(Integer xh);
    Page<SEntity> findAll(Pageable pageable);
    void deleteByXh(Integer xh);
}
