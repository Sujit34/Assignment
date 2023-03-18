package customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Student {
    @Id
    private int studentNumber;
    private String name;
    private String phone;
    private Address address;
    private List<Grade> grade;

    public Student(int studentNumber, String name, String phone) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.phone = phone;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    private void setStudentNumber(int studentNumber){this.studentNumber = studentNumber;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Grade> getGrade(){return grade;}
    public void setGrade(List<Grade> grade) {this.grade = grade;}


    @Override
    public String toString() {
        return "Student{" +
                " studentNumber=" + studentNumber +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
