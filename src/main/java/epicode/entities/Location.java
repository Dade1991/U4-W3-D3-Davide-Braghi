package epicode.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")

public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private long id;
    private String nomeLuogoSpecifico;
    private String citta;

    @ManyToMany(mappedBy = "locations")
    private List<Event> eventList;

    public Location() {
    }

    public Location(String nomeLuogoSpecifico, String citta) {
        this.nomeLuogoSpecifico = nomeLuogoSpecifico;
        this.citta = citta;
    }

    public long getId() {
        return id;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNomeLuogoSpecifico() {
        return nomeLuogoSpecifico;
    }

    public void setNomeLuogoSpecifico(String nomeLuogoSpecifico) {
        this.nomeLuogoSpecifico = nomeLuogoSpecifico;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nomeLuogoSpecifico='" + nomeLuogoSpecifico + '\'' +
                ", citta='" + citta + '\'' +
                ", eventList=" + eventList +
                '}';
    }
}


