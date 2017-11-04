package tev.community.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tev.community.test.TestIntervalRepository;
import tev.community.test.model.TestInterval;
import tev.community.test.utils.PsevdoLogger;

import java.util.List;

/**
 * Created by evg_uh on 03.11.17.
 */
@RestController
@RequestMapping(value = "/rest")
public class MainRestController {
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
}
