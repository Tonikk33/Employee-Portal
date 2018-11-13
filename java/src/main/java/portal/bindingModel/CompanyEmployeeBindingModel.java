package portal.bindingModel;

public class CompanyEmployeeBindingModel {

    private Integer companyId;

    private Integer employeeId;

    public CompanyEmployeeBindingModel() {
    }

    public CompanyEmployeeBindingModel(Integer companyId, Integer employeeId) {
        this.companyId = companyId;
        this.employeeId = employeeId;
    }

    public Integer getCompanyId() {

        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
