package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Department {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Collection<Employee> employeeList = new ArrayList<Employee>();

    public Department(){}

    public Department(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Collection<Employee> getEmployeeList() {
        return employeeList;
    }

    private void setEmployeeList(Collection<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public String toString() {
        return "Department: " +  " id=" + id +  ", name= " + name + ",  employeeList=" + employeeList ;
    }
}
