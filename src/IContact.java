import java.util.List;

public interface IContact<T> {
    void add(T person);
    void update(String numberPhone, T person);
    void delete(T person);
    List<T> search(String name);

}
