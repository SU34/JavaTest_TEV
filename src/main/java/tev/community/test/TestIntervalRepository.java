package tev.community.test;

import tev.community.test.model.TestInterval;

import java.util.List;

/**
 * Created by evg_uh on 04.11.17.
 */
public interface TestIntervalRepository {

    List<TestInterval> getAll();

    TestInterval getOne(int id);

    TestInterval add(TestInterval testInterval);

    boolean delete(int id);
}
