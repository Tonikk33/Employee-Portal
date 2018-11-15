package portal.bindingModel;

import javax.validation.constraints.NotNull;

public class CompanyBindingModel {


    @NotNull
    private String name;


    public CompanyBindingModel() {
    }

    public CompanyBindingModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
