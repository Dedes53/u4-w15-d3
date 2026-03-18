import java.time.LocalDate;
import java.util.List;

public class Main {
    static void main(String[] args) {

        double sconto = 0.90;
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
                LocalDate.of(2025, 3, 5),
                LocalDate.of(2025, 3, 9),
                Flanders,
                "PENDING",
                List.of(p3, p4)
        );

        Order o3 = new Order(
                103,
                LocalDate.of(2025, 1, 20),
                LocalDate.of(2025, 1, 25),
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


        //esercizio 1: lista prodotti Books con prezzo > 100
        List<Product> books = productsList.stream() //avvio lo stream
                .filter(p -> "Books".equals(p.getCategory())) //ciclo i prodotti e trovo quelli di categoria Books
                .filter(p -> p.getPrice() > 100) //tra i Books trovo quelli con price > 100
                .toList(); //ritorno una lista di tutti i prodotti che ho trovato
        System.out.println("ESERCIZIO 1");
        books.forEach(System.out::println);
        System.out.println();


        //esercizio 2: lista di ordini che appartengono alla categoria Baby
        List<Order> babyOrders = ordersList.stream() //avvio lo stream
                .filter(o -> o.getProducts().stream() //ciclo gli ordini per ottenere gli ordini di ognuno, e su ognuno di questi avvio un altro stream
                        .anyMatch(p -> "Baby".equals(p.getCategory()))) //tra tutti i prodotti trovo quelli che appartengono alla cat Baby
                .toList(); //creo la lista degli ordini con prodotti con la cat Baby

        System.out.println("ESERCIZIO 2");
        babyOrders.forEach(System.out::println);
        System.out.println();


        //esercizio 3: lista di prodotti che appartengono alla cat. Boys e applicare il 10% di sconto
        List<Product> boys = productsList.stream() //avvio lo stream
                .filter(p -> "Boys".equals(p.getCategory())) //trovo i prodotti di cat Boys
                .map(p -> new Product( //per ogni prodotto trovato che creo una copia
                        p.getId(),
                        p.getName(),
                        p.getCategory(),
                        p.getPrice() * sconto)) //il prezzo dei nuovi prodotti con lo sconto applicato
                .toList(); //creo la lista delle copie di prodotti Boys con lo sconto applicato

        System.out.println("ESERCIZIO 3");
        boys.forEach(System.out::println);
        System.out.println();


        //esercizio 4: lista di prodotti ordinati da clienti tier 2 tra 1-02-2025 e 1-04-2025
        LocalDate from = LocalDate.of(2025, 2, 1);
        LocalDate to = LocalDate.of(2025, 4, 1);

        List<Product> orderTier2 = ordersList.stream() //avvio lo stream
                .filter(o -> o.getCustomer().getTier() == 2) //filtro gli ordini in base se i clienti sono di tier 2
                .filter(o -> !o.getOrderDate().isBefore(from) && !o.getOrderDate().isAfter(to)) //li filtro poi in case alla data in cui sono stati effettuati
                .flatMap(o -> o.getProducts().stream()) //degli ordini rimasti ne prendo i prodotti
                .toList(); //ne ritorno la lista di prodotti di ordini fatti da clienti tier2 entro le date

        System.out.println("ESERCIZIO 4");
        orderTier2.forEach(System.out::println);
        System.out.println();

    }
}
