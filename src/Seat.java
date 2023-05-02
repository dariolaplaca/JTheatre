public class Seat {
    private int id;
    private static int idcounter;
    private int number;
    private int row;
    private boolean isOccupied;

    public Seat(int number, int row) {
        this.id = ++idcounter;
        this.number = number;
        this.row = row;
        isOccupied = false;
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

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    public void free(){
        isOccupied = false;
    }
}
