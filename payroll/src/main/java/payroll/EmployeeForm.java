package payroll;

public class EmployeeForm {

    private Long id;
    private String name;
    private String role;
    private Long hiddenCheckId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Long getHiddenCheckId(){
        return this.hiddenCheckId;
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

    public void setHiddenCheckId(Long hiddenCheckId) {
        this.hiddenCheckId = hiddenCheckId;
    }

}
