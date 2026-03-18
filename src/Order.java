import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order {

    //attributi
    private final long id;
    private final LocalDate orderDate;
    private final LocalDate deliveryDate;
    private final Customer customer;
    private final String status;
    private List<Product> products;

    public Order(long id, LocalDate orderDate, LocalDate deliveryDate, Customer customer, String status, List<Product> products) {
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.customer = customer;
        this.status = status;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(Objects.requireNonNull(product, "product"));
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", status='" + status + "', orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate + ", customer=" + customer +
                ", products=" + products + "}";
    }
}
