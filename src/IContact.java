import java.util.List;

public interface IContact<T> {
    void add(T person);
    void update(String numberPhone, T person);
    List<T> delete(String numberPhone);
    List<T> searchByName(String name);

}
