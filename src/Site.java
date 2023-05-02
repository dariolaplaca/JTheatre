import java.util.HashSet;
import java.util.Set;

public class Site {
    private int id;
    private static int idcounter;
    private String name;
    private String address;
    private String city;
    private boolean isOutdoor;
    private Set<Hall> halls;

    public Site(String name, String address, String city, boolean isOutdoor) {
        this.id = ++idcounter;
        this.name = name;
        this.address = address;
        this.city = city;
        this.isOutdoor = isOutdoor;
        halls = new HashSet<>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isOutdoor() {
        return this.isOutdoor;
    }

    public void setOutdoor(boolean outdoor) {
        isOutdoor = outdoor;
    }

    public Set<Hall> getHalls() {
        return this.halls;
    }

    public void addHall(Hall hall){
        this.halls.add(hall);
    }
}
