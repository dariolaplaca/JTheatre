import java.util.HashSet;
import java.util.Set;

public class Hall {
    private int id;
    private static int idcounter;
    private String name;
    private Set<Seat> seats;
    private Set<Spectacle> spectacles;

    public Hall(String name) {
        id = ++idcounter;
        this.name = name;
        seats = new HashSet<>();
        spectacles = new HashSet<>();
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

    public Set<Seat> getSeats() {
        return this.seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Set<Spectacle> getSpectacles() {
        return this.spectacles;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public void addSpectacle(Spectacle spectacle){
        this.spectacles.add(spectacle);
    }
}
