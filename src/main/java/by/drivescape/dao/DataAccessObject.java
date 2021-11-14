package by.drivescape.dao;

import java.sql.SQLException;
import java.util.List;

public interface DataAccessObject<T> {

    List<T> getAll();

    T getById(Long id) throws SQLException;

    void create(T t);
}
