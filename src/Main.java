import java.time.LocalDate;
import java.util.List;

public class Main {
    static void main(String[] args) {

        //customer
        Customer Homer = new Customer(123456789, "homer", 1);
        Customer Marge = new Customer(123456710, "marge", 2);
        Customer Flanders = new Customer(1234567811, "flanders", 2);
        Customer Boe = new Customer(1234567812, "boe", 3);

        //products
        Product p1 = new Product(1L, "Harry Potter Saga", "Books", 120.00);
        Product p2 = new Product(2L, "Narnia", "Books", 45.00);
        Product p3 = new Product(3L, "Pannolini", "Baby", 25.00);
        Product p4 = new Product(4L, "Lego", "Baby", 25.00);
        Product p5 = new Product(5L, "Maglia bimbo", "Boys", 30.00);
        Product p6 = new Product(6L, "Scarpe bimbo", "Boys", 80.00);
        Product p7 = new Product(7L, "Mouse", "Tech", 19.99);

        List<Product> productsList = List.of(p1, p2, p3, p4, p5, p6, p7);

        //orders
        Order o1 = new Order(
                101,
                LocalDate.of(2025, 2, 10),
                LocalDate.of(2025, 2, 15),
                Marge,
                "DELIVERED",
                List.of(p1, p7)
        );

        Order o2 = new Order(
                102,
                LocalDate.of(2025, 2, 5),
                LocalDate.of(2025, 2, 9),
                Flanders,
                "PENDING",
                List.of(p3, p4)
        );

        Order o3 = new Order(
                103,
                LocalDate.of(2025, 2, 20),
                LocalDate.of(2025, 2, 25),
                Flanders,
                "DELIVERED",
                List.of(p5)
        );

        Order o4 = new Order(
                104,
                LocalDate.of(2025, 2, 1),
                LocalDate.of(2025, 2, 7),
                Homer,
                "DELIVERED",
                List.of(p6)
        );

        List<Order> ordersList = List.of(o1, o2, o3, o4);


    }
}
