package payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView();

        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("index.html"); //NOTE: no slash

        return modelAndView;
    }

    @GetMapping("/menu")
    public ModelAndView greeting(@RequestParam(defaultValue="World") String name, Model model) {

        ModelAndView modelAndView = new ModelAndView();

        model.addAttribute("name", name);

        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("menu.html");//NOTE: no slash

        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam(name="q",required = false) String q, Model model) {

        ModelAndView modelAndView = new ModelAndView();

        List<Employee> employeeList = employeeService.search(q);

        model.addAttribute("q", q);
        model.addAttribute("items", employeeList);


        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("list.html");//NOTE: no slash

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {

        ModelAndView modelAndView = new ModelAndView();

        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("add.html");//NOTE: no slash

        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @RequestParam(name="name",required = false) String name
            ,@RequestParam(name="role",required = false) String role
            , Model model) {

        ModelAndView modelAndView = new ModelAndView();

        Employee employee = new Employee();

        employee.setName(name);
        employee.setRole(role);

        List<Employee> employeeList = employeeService.create(employee);


        model.addAttribute("process", "create");
        model.addAttribute("cnt", employeeList.size());

        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("success.html");//NOTE: no slash

        return modelAndView;
    }

}
