import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void searchTestWhenFewProductsFound() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        Book book1 = new Book(1, "Harry Potter 1", 1000, "QA");
        Book book2 = new Book(2, "Harry Potter 2", 1500, "QA");
        Book book3 = new Book(3, "Harry Potter 3", 2000, "QA");
        Smartphone smartphone = new Smartphone(4, "Telephone", 5000, "Alex");

        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone);

        Product[] expected = {book1, book2, book3};
        Product[] actual = manager.searchBy("Potter");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repositoryTestFindAll() {
        ProductRepository repository = new ProductRepository();

        Book book = new Book(1, "Java", 1000, "QA");
        Smartphone smartphone = new Smartphone(1, "Telephone", 5000, "Alex");

        repository.addProduct(book);
        repository.addProduct(smartphone);

        Product[] expected = {book, smartphone};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveCorrectId() {
        ProductRepository repository = new ProductRepository();

        Book book1 = new Book(1, "Java1", 1000, "QA");
        Book book2 = new Book(2, "Java2", 1500, "QA");
        Book book3 = new Book(3, "Java3", 2000, "QA");
        Smartphone smartphone = new Smartphone(1, "Telephone", 5000, "Alex");

        repository.addProduct(book1);
        repository.addProduct(book2);
        repository.addProduct(book3);
        repository.addProduct(smartphone);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeProductById(8));
    }
}