package tev.community.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tev.community.test.model.TestInterval;

import java.util.List;

/**
 * Created by evg_uh on 04.11.17.
 */
@Transactional(readOnly = true)
public interface CrudTestIntervalRepository extends JpaRepository<TestInterval, Integer> {

    @Override
    List<TestInterval> findAll();

    @Override
    TestInterval findOne(Integer integer);

    @Override
    @Transactional
    TestInterval save(TestInterval entity);

    @Transactional
    @Modifying
    @Query("delete from TestInterval tt where tt.id = :id")
    int delete(@Param("id") int id);

}
