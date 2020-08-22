package payroll;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
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

        List<EmployeeEntity> employeeEntityList = employeeService.search(q);

        model.addAttribute("q", q);
        model.addAttribute("itemList", employeeEntityList);


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

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName(name);
        employeeEntity.setRole(role);

        List<EmployeeEntity> employeeEntityList = employeeService.create(employeeEntity);


        model.addAttribute("process", "create");
        model.addAttribute("cnt", employeeEntityList.size());

        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("success.html");//NOTE: no slash

        return modelAndView;
    }

    @GetMapping("/remove")
    public ModelAndView remove(Model model) {

        ModelAndView modelAndView = new ModelAndView();

        List<EmployeeEntity> employeeEntityList = employeeService.findAll();

        int cnt = employeeEntityList.size();

        List<EmployeeForm> employeeFormList = new LinkedList<>();

        for(int i=0;i<cnt;i++){

            EmployeeForm employeeForm = new EmployeeForm();

            BeanUtils.copyProperties(employeeEntityList.get(i),employeeForm);

            employeeForm.setHiddenCheckId(employeeEntityList.get(i).getId());

            employeeFormList.add(employeeForm);
        }

        EmployeeForm employeeForm = new EmployeeForm();

        model.addAttribute("employeeForm", employeeForm);
        model.addAttribute("employeeFormList", employeeFormList);

        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("delete.html");//NOTE: no slash

        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(
            @ModelAttribute EmployeeForm employeeForm
            , Model model) {

        ModelAndView modelAndView = new ModelAndView();

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId(employeeForm.getHiddenCheckId());

        List<EmployeeEntity> employeeEntityList = employeeService.delete(employeeEntity);

        model.addAttribute("process", "delete");
        model.addAttribute("cnt", employeeEntityList.size());

        //https://stackoverflow.com/questions/48963242/cannot-access-templates-running-spring-boot-with-jar
        modelAndView.setViewName("success.html");//NOTE: no slash

        return modelAndView;
    }

}
