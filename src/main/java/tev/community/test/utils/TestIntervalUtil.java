package tev.community.test.utils;

import tev.community.test.TestIntervalRepository;
import tev.community.test.model.TestInterval;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by evg_uh on 05.11.17.
 */
public class TestIntervalUtil {
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static Integer getRandomId(TestIntervalRepository repository) {
        List<Integer> idList = repository.getIds();
        int randomIndex = random.nextInt(idList.size());
        return idList.get(randomIndex);
    }

    public static TestInterval getRandomTestInterval() {
        int startI = random.nextInt(Integer.MAX_VALUE);
        int endI = Math.abs(startI + 100);
        return new TestInterval(startI, endI);
    }
}
