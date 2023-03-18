package domain;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight {

    @Id
    @GeneratedValue
    private long flightNumber;
    @Column(name = "start")
    private String from;
    @Column(name = "end")
    private String to;
    private Date date;

    public Flight() {
    }

    public Flight(String from, String to, Date date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight : " + "flightNumber=" + flightNumber + ", from='" + from +
                ", to='" + to  + ", date=" + date;
    }
}
