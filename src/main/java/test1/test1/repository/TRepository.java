package test1.test1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test1.test1.entity.TEntity;

public interface TRepository extends JpaRepository<TEntity,Integer> {
    TEntity findByGh(int gh);

}
