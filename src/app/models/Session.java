package app.models;

import app.models.users.User;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class Session implements Serializable {

    @Setter
    private User user;

    private boolean active;
    private final boolean guest;

    private Session() {
        this.active = true;
        this.guest = true;
    }

    public Session(User user) {
        this.user = user;
        this.active = true;
        this.guest = false;
    }

    public static Session asGuest() {
        return new Session();
    }

    public boolean end() {
        this.user = null;
        return this.active = false;
    }
}
