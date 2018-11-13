package portal.controller;

import portal.bindingModel.CompanyEmployeeBindingModel;
import portal.bindingModel.EmployeeBindingModel;
import portal.entity.Company;
import portal.entity.CompanyEmployee;
import portal.entity.Employee;
import portal.repository.CompanyEmployeeRepository;
import portal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import portal.bindingModel.CompanyBindingModel;
import portal.repository.CompanyRepository;

import java.util.List;

@Controller
public class CompanyController {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyEmployeeRepository companyEmployeeRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository, EmployeeRepository employeeRepository,
                             CompanyEmployeeRepository companyEmployeeRepository1) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
        this.companyEmployeeRepository = companyEmployeeRepository1;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Company> companies = companyRepository.findAll();
        model.addAttribute("view", "company/index");
        model.addAttribute("companies", companies);
        return "base-layout";
    }

    @GetMapping("/create")
    public String createCompany(Model model) {

        model.addAttribute("view","company/createcompany");
        return "base-layout";
    }


    @PostMapping("/create")
    public String createProcessCompany(Model model, CompanyBindingModel companyBindingModel) {

       Company company = new Company();
       company.setName(companyBindingModel.getName());
       companyRepository.saveAndFlush(company);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCompany(Model model, @PathVariable int id) {

        Company company = companyRepository.findOne(id);
        model.addAttribute("view", "company/editcompany");
        model.addAttribute("company", company);
        return "base-layout";
    }
    @GetMapping("/company/add")
    public String detailsCompany(Model model) {

        List<Company> companies = companyRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("view", "company/add");
        model.addAttribute("companies", companies);
        model.addAttribute("employees", employees);
        return "base-layout";
    }

    @PostMapping("/company/add")
    public String add (Model model, CompanyEmployeeBindingModel companyEmployeeBindingModel){
        CompanyEmployee companyEmployee = new CompanyEmployee();
        companyEmployee.setCompanyId(companyEmployeeBindingModel.getCompanyId());
        companyEmployee.setEmployeeId(companyEmployeeBindingModel.getEmployeeId());
        companyEmployeeRepository.saveAndFlush(companyEmployee);
        return "redirect:/";

    }

    @PostMapping("/edit/{id}")
    public String editProcessCompany(@PathVariable int id, Model model, CompanyBindingModel companyBindingModel) {

       Company company = companyRepository.findOne(id);
       company.setName(companyBindingModel.getName());
       companyRepository.saveAndFlush(company);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(Model model, @PathVariable int id) {

        Company company = companyRepository.findOne(id);
        model.addAttribute("view", "company/deletecompany");
        model.addAttribute("company", company);
        return "base-layout";
    }

    @PostMapping("/delete/{id}")
    public String deleteProcessCompany(@PathVariable int id, CompanyBindingModel companyBindingModel) {

        companyRepository.delete(id);
        return "redirect:/";
    }


    @GetMapping("/employee")
    public String indexEmployee(Model model) {

        List<Employee> employees = employeeRepository.findAll() ;
        model.addAttribute("view", "employee/employee");
        model.addAttribute("employees", employees);
        return "base-layout";
    }

    @GetMapping("/employee/create")
    public String create(Model model) {

        model.addAttribute("view", "employee/createemployee");
        return "base-layout";
    }

    @PostMapping("/employee/create")
    public String createEmployee(Model model, EmployeeBindingModel employeeBindingModel) {
        Employee employee = new Employee();
        employee.setName(employeeBindingModel.getName());
        employee.setStartingDate(employeeBindingModel.getStartingDate());
        employee.setSalary(employeeBindingModel.getSalary());
        employee.setVacation(employeeBindingModel.getVacation());
        employee.setExperienceLevel(employeeBindingModel.getExperienceLevel());
        System.out.println(employee.getStartingDate());

        employeeRepository.saveAndFlush(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/edit/{id}")
    public String edit(Model model, @PathVariable int id) {

        Employee employee = employeeRepository.findOne(id);
        model.addAttribute("view", "employee/editemployee");
        model.addAttribute("employee", employee);
        return "base-layout";
    }

    @PostMapping("/employee/edit/{id}")
    public String editProcess(@PathVariable int id, Model model, EmployeeBindingModel employeeBindingModel) {

        Employee employee = employeeRepository.findOne(id);
        employee.setName(employeeBindingModel.getName());
        employee.setExperienceLevel(employeeBindingModel.getExperienceLevel());
        employee.setSalary(employeeBindingModel.getSalary());
        employee.setStartingDate(employeeBindingModel.getStartingDate());
        employee.setVacation(employeeBindingModel.getVacation());
        employeeRepository.saveAndFlush(employee);
        return "redirect:/";
    }

    @GetMapping("/employee/delete/{id}")
    public String delete(Model model, @PathVariable int id) {

        Employee employee = employeeRepository.findOne(id);
        model.addAttribute("view", "employee/deleteemployee");
        model.addAttribute("employee", employee);
        return "base-layout";
    }

    @PostMapping("/employee/delete/{id}")
    public String deleteProcess(@PathVariable int id, EmployeeBindingModel employeeBindingModel) {

        employeeRepository.delete(id);
        return "redirect:/";
    }

}
