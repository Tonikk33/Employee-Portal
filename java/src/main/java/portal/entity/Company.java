package portal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    @NotNull
    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Employee> employee;

    public Company() {
    }

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
        //this.employee = employee;
    }

    public Integer getId(int id) {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Employee> getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(List<Employee> employee) {
//        this.employee = employee;
//    }
}


