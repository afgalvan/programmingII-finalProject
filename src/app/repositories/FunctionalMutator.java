package app.repositories;

@FunctionalInterface
public interface FunctionalMutator<T, N> {
    void mutate(T toMutate, N newData);
}
