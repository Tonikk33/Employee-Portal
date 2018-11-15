package portal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "companyemployee")
public class CompanyEmployee {
    @Id
    @Column(unique = true)
    @NotNull
    public Integer employeeId;

    @Column
    @NotNull
    public Integer companyId;

    public CompanyEmployee() {
    }

    public CompanyEmployee(Integer employeeId, Integer companyId) {
        this.employeeId = employeeId;
        this.companyId = companyId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCompanyId(int id) {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
