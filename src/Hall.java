public class Hall {
    private int id;
    private String name;
    private int site_id;

    public Hall(int id, String name, int site_id) {
        this.id = id;
        this.name = name;
        this.site_id = site_id;
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

    public int getSite_id() {
        return this.site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }
}
