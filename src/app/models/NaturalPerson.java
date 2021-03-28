package app.models;

public class NaturalPerson extends Person {
    public NaturalPerson(String name, String secondName, String lastName, String secondLastName,
                         String id, IdTypes idType) {
        super(name, secondName, lastName, secondLastName, id, idType);
    }
}
