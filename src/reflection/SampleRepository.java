package reflection;

import java.util.List;

public abstract class SampleRepository extends AbstractRepository {

    void save(Object object) {

    }

    Object find(Long id) {
        return null;
    }

    List<Object> findAll() {
        return null;
    }

    abstract void abstractMethod();

}
