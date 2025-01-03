import java.sql.Date;
import java.sql.Timestamp;

public class Orders {
    private int id;

    private Timestamp time;
    private double price;


    public Orders(int id, Timestamp time, double price) {
        this.id = id;
        this.time = time;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", time=" + time +
                ", price=" + price +
                '}';
    }
}
