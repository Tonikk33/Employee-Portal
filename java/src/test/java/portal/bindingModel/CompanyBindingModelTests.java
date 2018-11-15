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
public class CompanyBindingModelTests {

    private static final String VALID_NAME = "name";
    private static final String FIELD_NAME = "name";

    private final Validator validator = Validation
            .byDefaultProvider()
            .configure()
            .buildValidatorFactory()
            .getValidator();

    private CompanyBindingModel model;

    private boolean validateField(Object obj, String fieldName) {
        return this.validator.validateProperty(obj, fieldName).isEmpty();
    }

    private String generateTestString(int length) {
        return new String(new char[length]);
    }


    @Before
    public void prepareTestEnvironment() {
        this.model = new CompanyBindingModel();
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


}
