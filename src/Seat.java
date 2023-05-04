public class Seat {
    private int id;
    private int number;
    private int row;
    private int hall_id;

    public Seat(int id, int number, int row, int hall_id) {
        this.id = id;
        this.number = number;
        this.row = row;
        this.hall_id = hall_id;
    }

    public int getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getHall_id() {
        return this.hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

}

