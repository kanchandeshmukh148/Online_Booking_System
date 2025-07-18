public class Booking {
    private String name;
    private String date;
    private String time;

    public Booking(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getTime() { return time; }

    @Override
    public String toString() {
        return "Name: " + name + ", Date: " + date + ", Time: " + time;
    }
}
