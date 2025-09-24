package davidebraghi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

// ____________________________________________________________________________________

@Entity
@Table(name = "eventi")

// Fornisco la struttura della tabella da compilare

public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "event_date", nullable = false)
    private LocalDate eventDate;

    @Column(name = "description", nullable = true)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType typeOfEvent;

    @Column(name = "partecipant_number", nullable = true)
    private long partecipantNumber;

    // Costruttore vuoto OBBLIGATORIO

    public Event() {
    }

    // Costruttore

    public Event(String title, LocalDate eventDate, String description, EventType typeOfEvent, long partecipantNumber) {
        this.title = title;
        this.eventDate = eventDate;
        this.description = description;
        this.typeOfEvent = typeOfEvent;
        this.partecipantNumber = partecipantNumber;
    }

    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(EventType typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public long getPartecipantNumber() {
        return partecipantNumber;
    }

    public void setPartecipantNumber(long partecipantNumber) {
        this.partecipantNumber = partecipantNumber;
    }

    // toString

    @Override
    public String toString() {
        return "Event {" +
                "id= " + id +
                ", title= '" + title + '\'' +
                ", eventDate= " + eventDate +
                ", description= '" + description + '\'' +
                ", typeOfEvent= " + typeOfEvent +
                ", partecipantNumber= " + partecipantNumber +
                '}';
    }
}


