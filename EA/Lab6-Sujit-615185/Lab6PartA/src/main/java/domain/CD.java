package domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "CD.findByArtist", query = "select cd from CD cd where cd.artist = :artist")
})
public class CD extends Product{
    private String artist;

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CD : " + "name='" + super.getName() + ", description='" + super.getDescription() +
                ", price=" + super.getPrice() + ", artist='" + artist ;
    }

}
