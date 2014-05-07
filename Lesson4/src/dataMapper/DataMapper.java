package dataMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by tish on 04.05.2014.
 */
public interface DataMapper {

    void save (Object o) throws IOException;

    Object load (long id, Class clazz) throws FileNotFoundException;

    List<Object> loadAll (Class clazz);

    void update (Object o);
}
