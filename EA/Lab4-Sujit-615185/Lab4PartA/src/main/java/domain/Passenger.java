package domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "passenger")
    @OrderColumn(name = "sequence")
    List<Flight> flightList = new ArrayList<Flight>();

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlightList() {
        return Collections.unmodifiableList(flightList);
    }

    public boolean addFlight(Flight flight) {
        return flightList.add(flight);
    }



    @Override
    public String toString() {
        return "Passenger: " +   "id=" + id + ", name='" + name + ", flight list=" + flightList ;
    }
}
