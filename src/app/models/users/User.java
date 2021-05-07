package app.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represent any user.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

    private String name;
    private String password;
}
