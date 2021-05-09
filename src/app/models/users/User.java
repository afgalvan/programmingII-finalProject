package app.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents any user.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    private String name;
    private String password;
    private String salt;
}
