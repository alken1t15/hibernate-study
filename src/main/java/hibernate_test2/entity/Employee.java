package hibernate_test2.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees") //Подключение к нужной базе данной
public class Employee {
    @Id // Обозначает что столбец являеться авто инкрименцией
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Правило генерации значении id в MySql
    @Column(name = "id") // Столбец
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;
    @OneToOne(cascade = CascadeType.ALL) // Указывает какое будет отношение
    @JoinColumn(name = "details_id") // Указыает с каким столбцом будет
    private Detail empDetail;

    public Employee() {

    }
    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Detail getEmpDetail() {
        return empDetail;
    }
    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }
}
