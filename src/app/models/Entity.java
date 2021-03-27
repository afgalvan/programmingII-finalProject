package app.models;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor
public abstract class Entity implements Comparable<Entity>, Serializable {

    private static final long serialVersionUID = 274736873469220325L;
    private final String code;

    public Entity(Entity entity) {
        this(entity.getCode());
    }

    @Override
    public int compareTo(Entity anotherEntity) {
        return getCode().compareTo(anotherEntity.getCode());
    }
}
