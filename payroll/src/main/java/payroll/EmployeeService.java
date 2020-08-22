package payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<EmployeeEntity> findAll(){
        Spliterator<EmployeeEntity>  employeeSpliterator = repository.findAll().spliterator();

        Stream<EmployeeEntity> stream = StreamSupport.stream(employeeSpliterator,false);

        return stream.collect(Collectors.toList());
    }


    public List<EmployeeEntity> search(String name){

        Spliterator<EmployeeEntity>  employeeSpliterator = repository.findAll().spliterator();

        Stream<EmployeeEntity> stream = StreamSupport.stream(employeeSpliterator,false);

        return stream.filter(e->e.getName().equals(name)).collect(Collectors.toList());

    }

    public List<EmployeeEntity> create(EmployeeEntity employeeEntity){
        List<EmployeeEntity> list = new LinkedList<>();
        list.add(repository.save(employeeEntity));
        return list;
    }

    public List<EmployeeEntity> delete(EmployeeEntity employeeEntity){

        List<EmployeeEntity> list = new LinkedList<>();

        Optional<EmployeeEntity> tobeEmployeeEntity = repository.findById(employeeEntity.getId());

        if(tobeEmployeeEntity.isPresent()){
            repository.delete(tobeEmployeeEntity.get());
            list.add(tobeEmployeeEntity.get());
        }

        return list;
    }
}