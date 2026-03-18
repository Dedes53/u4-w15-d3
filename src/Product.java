public class Product {
    //attributi
    private final long id;
    private final String name;
    private final String category;
    private final double price;

    // costruttore
    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // getters
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{ id=" + id + ", name='" + name + "', catgory='" + category + "' price=" + price + "}";
    }
}
