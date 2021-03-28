package app.models;

public class StateEntity extends Person {

    @Override
    public String getFullName() {
        return this.getName();
    }
}
