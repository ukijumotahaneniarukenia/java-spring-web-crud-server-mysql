package payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> search(String name){

        Spliterator<Employee>  employeeSpliterator = repository.findAll().spliterator();

        Stream<Employee> stream = StreamSupport.stream(employeeSpliterator,false);

        return stream.filter(e->e.getName().equals(name)).collect(Collectors.toList());

    }

    public List<Employee> create(Employee employee){
        List<Employee> list = new LinkedList<>();
        list.add(repository.save(employee));
        return list;
    }
}