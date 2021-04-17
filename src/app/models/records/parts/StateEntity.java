package app.models.records.parts;

public class StateEntity extends Person {

    public StateEntity(String name) {
        this.setName(name);
    }

    @Override
    public String getFullName() {
        return this.getName();
    }
}
