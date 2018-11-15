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
public class EmployeeBindingModelTests {

    private static final String VALID_NAME = "name";
    private static final String VALID_EXPERIENCE_LEVEL = "experienceLevel";
    private static final String VALID_STARTING_DATE = "startingDate";
    private static final Double VALID_SALARY = 2.0;
    private static final Integer VALID_VACATION =  1;

    private static final String FIELD_NAME = "name";
    private static final String FIELD_EXPERIENCE_LEVEL = "experienceLevel";
    private static final String FIELD_STARTING_DATE = "startingDate";
    private static final String FIELD_SALARY = "salary";
    private static final String FIELD_VACATION = "vacation";

    private final Validator validator = Validation
            .byDefaultProvider()
            .configure()
            .buildValidatorFactory()
            .getValidator();

    private EmployeeBindingModel model;

    private boolean validateField(Object obj, String fieldName) {
        return this.validator.validateProperty(obj, fieldName).isEmpty();
    }

    private String generateTestString(int length) {
        return new String(new char[length]);
    }


    @Before
    public void prepareTestEnvironment() {
        this.model = new EmployeeBindingModel();
    }

    @Test
    public void bindingModel_validName_validationPasses() {
        this.model.setName(VALID_NAME);
        Assert.assertTrue(this.validateField(this.model, FIELD_NAME));
    }

    @Test
    public void bindingModel_NameIsNull_validationFails() {
        this.model.setName(null);
        Assert.assertFalse(this.validateField(this.model, FIELD_NAME));
    }
    @Test
    public void bindingModel_valid_Experience_Level_validationPasses() {
        this.model.setExperienceLevel(VALID_EXPERIENCE_LEVEL);
        Assert.assertTrue(this.validateField(this.model, FIELD_EXPERIENCE_LEVEL));
    }

    @Test
    public void bindingModel_Experience_Level_IsNull_validationFails() {
        this.model.setExperienceLevel(null);
        Assert.assertFalse(this.validateField(this.model, FIELD_EXPERIENCE_LEVEL));
    }

    @Test
    public void bindingModel_valid_StartingDate_validationPasses() {
        this.model.setStartingDate(VALID_STARTING_DATE);
        Assert.assertTrue(this.validateField(this.model, FIELD_STARTING_DATE));
    }

    @Test
    public void bindingModel_StartingDate_IsNull_validationFails() {
        this.model.setStartingDate(null);
        Assert.assertFalse(this.validateField(this.model, FIELD_STARTING_DATE));
    }

    @Test
    public void bindingModel_valid_Salary_validationPasses() {
        this.model.setSalary(VALID_SALARY);
        Assert.assertTrue(this.validateField(this.model, FIELD_SALARY));
    }

    @Test
    public void bindingModel_Salary_IsNull_validationFails() {
        this.model.setSalary(null);
        Assert.assertFalse(this.validateField(this.model, FIELD_SALARY));
    }
    @Test
    public void bindingModel_valid_Vacation_validationPasses() {
        this.model.setVacation(VALID_VACATION);
        Assert.assertTrue(this.validateField(this.model, FIELD_VACATION));
    }

    @Test
    public void bindingModel_Vacation_IsNull_validationFails() {
        this.model.setVacation(null);
        Assert.assertFalse(this.validateField(this.model, FIELD_VACATION));
    }


}
