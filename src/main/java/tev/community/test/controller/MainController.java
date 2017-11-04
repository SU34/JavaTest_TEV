package tev.community.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tev.community.test.model.TestInterval;
import tev.community.test.repository.CrudTestIntervarRepositoryImpl;

/**
 * Created by evg_uh on 03.11.17.
 */
@Controller
@RequestMapping(value="/")
public class MainController {

    private final CrudTestIntervarRepositoryImpl CrudTestIntervarRepositoryImpl;

    @Autowired
    public MainController(CrudTestIntervarRepositoryImpl CrudTestIntervarRepositoryImpl) {
        this.CrudTestIntervarRepositoryImpl = CrudTestIntervarRepositoryImpl;
    }

    @GetMapping
    public String showIndexPage() {
        return "/index";
    }

    @GetMapping("/testPage01")
    public String showTestPage01(ModelMap model) {
        System.out.println(CrudTestIntervarRepositoryImpl.getAll());
        TestInterval testInterval = new TestInterval(23,33);
        CrudTestIntervarRepositoryImpl.add(testInterval);
        CrudTestIntervarRepositoryImpl.delete(2);
        System.out.println(CrudTestIntervarRepositoryImpl.getAll());

        return "/testPage01";
    }
}
