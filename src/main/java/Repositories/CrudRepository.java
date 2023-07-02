package Repositories;

// CRUD - Create, Read, Update, Delete
public interface CrudRepository<T, L extends Number> {
    void save(T model);
}

