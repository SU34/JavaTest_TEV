package tev.community.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tev.community.test.TestIntervalRepository;
import tev.community.test.model.TestInterval;
import tev.community.test.utils.PsevdoLogger;

import java.util.List;

/**
 * Created by evg_uh on 04.11.17.
 */
@Repository
public class CrudTestIntervarRepositoryImpl implements TestIntervalRepository {
    private static final PsevdoLogger log = new PsevdoLogger();

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
        TestInterval save = crudTestIntervalRepository.save(testInterval);
        String message = (save != null) ? "created:" : "NOT CREATED!:";
        log.info(message + save);
        return save;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = (crudTestIntervalRepository.delete(id)) != 0;
        String message = isDeleted ? "deleted:" : "NOT DELETED!:";
        log.info(message + "testInterval with id=" + id);
        return isDeleted;
    }

    @Override
    public List<Integer> getIds() {
        return crudTestIntervalRepository.getIdList();
    }

}
