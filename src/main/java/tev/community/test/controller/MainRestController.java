package tev.community.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tev.community.test.TestIntervalRepository;
import tev.community.test.model.TestInterval;
import tev.community.test.utils.PsevdoLogger;
import tev.community.test.utils.TestIntervalUtil;

import java.util.List;

/**
 * Created by evg_uh on 03.11.17.
 */
@RestController
@RequestMapping(value = "/rest")
public class MainRestController {
    private static final long TIME_SLEEP = 1000;
    private static final int COUNT_OPERATIONS_IN_THREAD = 10;

    private static final PsevdoLogger log = new PsevdoLogger();

    private final TestIntervalRepository repository;

    @Autowired
    public MainRestController(TestIntervalRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/testInterval/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TestInterval> getAll() {
        log.info("rest: getAll");
        return repository.getAll();
    }

    @GetMapping(value = "/testInterval/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TestInterval getOne(@PathVariable("id") Integer id) {
        return repository.getOne(id);
    }

    @PostMapping(value = "/testInterval/delete/{id}")
    public void postRequestDeleteById(@PathVariable("id") Integer id) {
        log.info("rest: delete(id)");
        repository.delete(id);
    }

    @PostMapping(value = "testInterval/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveTestInterval(@RequestBody TestInterval testInterval) {
        log.info("rest: testInterval/save");
        repository.add(testInterval);
    }

    @PostMapping("/addThreadDelete")
    public void startThreadDelete() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("startThreadDelete - is started");
                int lifeThread = 0;
                while (lifeThread <= COUNT_OPERATIONS_IN_THREAD) {
                    lifeThread++;
                    try {
                        Integer id = TestIntervalUtil.getRandomId(repository);
                        repository.delete(id);
                        Thread.sleep(TIME_SLEEP);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("startThreadDelete - is ended");
            }
        }).start();
    }

    @PostMapping("/addThreadCreate")
    public void startThreadCreate() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("startThreadCreate - is started");
                int lifeThread = 0;
                while (lifeThread <= COUNT_OPERATIONS_IN_THREAD) {
                    lifeThread++;
                    try {
                        repository.add(TestIntervalUtil.getRandomTestInterval());
                        Thread.sleep(TIME_SLEEP);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.info("startThreadCreate - is ended");
            }
        }).start();
    }
}
