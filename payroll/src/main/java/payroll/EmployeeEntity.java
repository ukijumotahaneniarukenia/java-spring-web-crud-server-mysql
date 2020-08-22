package payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "employee")
class EmployeeEntity {

    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    EmployeeEntity() {}

    public EmployeeEntity(String name, String role) {

        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof EmployeeEntity))
            return false;
        EmployeeEntity employeeEntity = (EmployeeEntity) o;
        return Objects.equals(this.id, employeeEntity.id) && Objects.equals(this.name, employeeEntity.name)
                && Objects.equals(this.role, employeeEntity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }
}