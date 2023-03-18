package domain;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long employeeNumber;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department")
    Department department;

    public Employee(){}
    public Employee (String name){
        this.name = name;
    }

    public long getEmployeeNumber(){
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee: " + " employeeNumber= " + employeeNumber + ", name= " + name;
    }

}
