package payroll;


import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private static List<Employee> list = new LinkedList(){{
        add(new Employee(111L,"mariko","chef"));
        add(new Employee(222L,"ぽるこ","豚"));
        add(new Employee(333L,"まるこ","人"));
        add(new Employee(444L,"うんこ","糞"));
        add(new Employee(555L,"うんこ","kuso"));
        add(new Employee(666L,"うんこ","KUSO"));
        add(new Employee(777L,"うんこ","UNKO"));
        add(new Employee(888L,"うんこ","unko"));
    }};

    public List<Employee> mock(String name){

        return list.stream().filter(e->e.getName().equals(name)).collect(Collectors.toList());

    }

}
