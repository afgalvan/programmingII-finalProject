package app.models;

public class JuridicPerson extends Person {

    @Override
    public String getFullName() {
        return this.getName();
    }
}
