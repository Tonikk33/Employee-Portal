package portal.bindingModel;


public class EmployeeBindingModel {

    private String name;

    private String experienceLevel;

    private String startingDate;

    private Double salary;

    private Integer vacation;

    public EmployeeBindingModel() {
    }

    public EmployeeBindingModel(String name, String experienceLevel, String startingDate, Double salary, Integer vacation) {
        this.name = name;
        this.experienceLevel = experienceLevel;
        this.startingDate = startingDate;
        this.salary = salary;
        this.vacation = vacation;

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

