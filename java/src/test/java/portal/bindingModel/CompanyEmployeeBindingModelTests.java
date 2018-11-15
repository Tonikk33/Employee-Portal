package portal.bindingModel;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CompanyEmployeeBindingModelTests {
    private static final Integer VALID_COMPNAY_ID = 1;
    private static final Integer VALID_EMPLOYEE_ID = 2;
    private static final String FIELD_COMPANY_ID = "companyId";
    private static final String FIELD_EMPLOYEE_ID = "employeeId";
    private static final String INVALID_ID = "2";

    private final Validator validator = Validation
            .byDefaultProvider()
            .configure()
            .buildValidatorFactory()
            .getValidator();

    private CompanyEmployeeBindingModel model;

    private boolean validateField(Object obj, String fieldName) {
        return this.validator.validateProperty(obj, fieldName).isEmpty();
    }

    private String generateTestString(int length) {
        return new String(new char[length]);
    }


    @Before
    public void prepareTestEnvironment() {
        this.model = new CompanyEmployeeBindingModel();
    }


    @Test
    public void bindingModel_validCompanyId_validationPasses() {
        this.model.setCompanyId(VALID_COMPNAY_ID);
        Assert.assertTrue(this.validateField(this.model, FIELD_COMPANY_ID));
    }

    @Test
    public void bindingModel_validEmployeeId_validationPasses() {
        this.model.setEmployeeId(VALID_EMPLOYEE_ID);
        Assert.assertTrue(this.validateField(this.model, FIELD_EMPLOYEE_ID));
    }

    @Test
    public void bindingModel_companyIsNull_validationFails() {
        this.model.setCompanyId(null);
        Assert.assertFalse(this.validateField(this.model, FIELD_COMPANY_ID));
    }

    @Test
    public void bindingModel_employeeIsNull_validationFails() {
        this.model.setEmployeeId(null);
        Assert.assertFalse(this.validateField(this.model, FIELD_EMPLOYEE_ID));
    }



}
