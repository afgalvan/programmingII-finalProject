package app.models;

import app.models.users.User;
import java.io.Serializable;
import lombok.Data;

@Data
public class Session implements Serializable {

    private User user;
    private boolean guest;

    public Session() {
        this.guest = true;
    }

    public Session(User user) {
        this.user = user;
        this.guest = false;
    }
}
