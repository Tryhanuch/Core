package dataMapper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by tish on 04.05.2014.
 */
public interface DataMapper {

    void save(Object o) throws SQLException;

    Object load(long id, Class clazz);

    List<Object> loadAll(Class clazz);

    void update(Object o);
}
