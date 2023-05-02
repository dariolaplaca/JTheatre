import java.time.LocalDate;

public class Spectacle {
    private int id;
    private static int idcounter;
    private LocalDate schedule;
    private String name;
    //java.sql.Date ?
    private int duration;
    private double price;
    private String genre;

    public Spectacle(String name, LocalDate schedule, int duration, double price, String genre) {
        this.id = ++idcounter;
        this.name = name;
        this.schedule = schedule;
        this.duration = duration;
        this.price = price;
        this.genre = genre;
    }

    public int getId() {
        return this.id;
    }


    public LocalDate getSchedule() {
        return this.schedule;
    }

    public void setSchedule(LocalDate schedule) {
        this.schedule = schedule;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

