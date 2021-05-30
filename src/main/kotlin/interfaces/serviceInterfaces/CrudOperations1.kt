package interfaces.serviceInterfaces;

import java.util.List;

public interface CrudOperations<T> {
    void save(T object);
    void delete(int id);
    void update(int id, T object);
    boolean exist(int id);
    List<T> getAll();
    T getById(int id);
}
