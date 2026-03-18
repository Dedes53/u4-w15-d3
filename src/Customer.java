public class Customer {

    //attributi
    private final long id;
    private final String name;
    private final int tier;

    //costruttore
    public Customer(long id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    //getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{ id=" + id + ", name='" + name + "', tier=" + tier + "}";
    }
}
