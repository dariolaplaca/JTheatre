import java.util.Date;

public class Ticket {
    private int id;
    private static int idcounter;
    private Date date;
    User user;
    Seat seat;

    public Ticket(Date date, User user, Seat seat) {
        this.id = ++idcounter;
        this.date = date;
        this.user = user;
        this.seat = seat;
    }

    public int getId() {
        return this.id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return this.seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
