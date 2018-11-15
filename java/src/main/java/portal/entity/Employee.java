package portal.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String experienceLevel;

    @Column
    @NotNull
    private String startingDate;

    @Column
    @NotNull
    private Double salary;

    @Column
    @NotNull
    private Integer vacation;


    public Employee() {
    }

    public Employee(Integer id, String name, String experienceLevel, String startingDate, Double salary, Integer vacation) {
        this.id = id;
        this.name = name;
        this.experienceLevel = experienceLevel;
        this.startingDate = startingDate;
        this.salary = salary;
        this.vacation = vacation;
    }

    public Integer getId() {
        return id;
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

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getVacation() {
        return vacation;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

}
