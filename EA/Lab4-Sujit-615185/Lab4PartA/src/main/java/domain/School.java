package domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class School {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "school")
    @MapKey(name = "studentId")
    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    public School() {
    }

    public School(String name) {
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

    public Map<Long, Student> getStudentList() {
        return studentMap;
    }

    public Student addStudent(Student student) {
        System.out.println(student.getStudentId() + "Test.......");
        return studentMap.put(student.getStudentId(), student);
    }



    @Override
    public String toString() {
        return "School : " + "id=" + id + ", name='" + name + ", Students : " + getStudentList() ;
    }
}
