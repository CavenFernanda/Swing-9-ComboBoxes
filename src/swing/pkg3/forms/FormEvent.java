package swing.pkg3.forms;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int ageCategory;
    private String employment;

    public FormEvent(Object source) {
        super(source); //source will be the button from FormPanel that will raise the event

    }

    public FormEvent(Object source, String name, String occupation, int ageCategory,String employment) {
        super(source); //source will be the button from FormPanel that will raise the event
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employment = employment;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }
    public int getAgeCategory() {
        return ageCategory;
    }
    
    public String getEmployment() {
        return employment;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public void setAgeCategory(int ageCategory) {

        this.ageCategory = ageCategory;
    }
    
    public void setEmployment(String employment) {

        this.employment = employment;
    }
}
