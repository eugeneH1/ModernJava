package Chapter5;

public class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c) {
        name = n;
        city = c;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader: " + name + ", city='" + city;
    }
}
