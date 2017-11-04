package tev.community.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tev.community.test.TestIntervalRepository;
import tev.community.test.model.TestInterval;

import java.util.List;

/**
 * Created by evg_uh on 04.11.17.
 */
@Repository
public class CrudTestIntervarRepositoryImpl implements TestIntervalRepository {

    @Autowired
    private CrudTestIntervalRepository crudTestIntervalRepository;

    @Override
    public List<TestInterval> getAll() {
        return crudTestIntervalRepository.findAll();
    }

    @Override
    public TestInterval getOne(int id) {
        return crudTestIntervalRepository.findOne(id);
    }

    @Override
    public TestInterval add(TestInterval testInterval) {
        return crudTestIntervalRepository.save(testInterval);
    }

    @Override
    public boolean delete(int id) {
        return crudTestIntervalRepository.delete(id) != 0;
    }

}
