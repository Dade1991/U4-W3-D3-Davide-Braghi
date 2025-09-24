package davidebraghi;

import davidebraghi.dao.EventDAO;
import davidebraghi.entities.Event;
import davidebraghi.entities.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    // Per connetterci al database dobbiamo aggiungere nella classe main una EntityManagerFactory
    // Dobbiamo passargli il nome della persistence unit che abbiamo configurato nel persistence.xml
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D3-Davide-Braghi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); // Oggetto che gestirà tutte le operazioni con il database
        EventDAO eventDAO = new EventDAO(em);

        // Creazione Eventi con Dettagli di ciascun Evento

        Event event1 = new Event("Foo Fighters",
                LocalDate.of(2026, 8, 25),
                "Foo Fighters ignite Milan with raw energy, thunderous riffs, and unforgettable rock anthems in a night of pure adrenaline.",
                EventType.PUBLIC,
                40000);

        Event event2 = new Event("Metallica",
                LocalDate.of(2025, 12, 13),
                "Metallica storms Gothenburg with blazing riffs, iconic anthems, and electrifying energy in a night of metal mastery.",
                EventType.PUBLIC,
                60000);

        Event event3 = new Event("Exclusive Game Developers Week",
                LocalDate.of(2025, 10, 7),
                "Exclusive Game Dev Week: private sessions, cutting-edge insights, networking, and innovation shaping the future of interactive entertainment.",
                EventType.PRIVATE,
                1500);

        Event event4 = new Event("Impara a vendere forchette con Sergio Mastrotta",
                LocalDate.of(2026, 5, 30),
                "Sergio Mastrotta svela strategie vincenti per vendere forchette in acciaio inox: tecnica, persuasione e mercato in evoluzione.",
                EventType.PUBLIC,
                80);

        // Salvataggio Eventi con metodo richiamato "save"

        eventDAO.save(event1);
        eventDAO.save(event2);
        eventDAO.save(event3);
        eventDAO.save(event4);

        // __________ Gestione Errori ____________________ (Scommentare per verificare il funzionamento)
        // __________ Gestione Errore: FIND BY

//        try {
//            Event dataFromDB = eventDAO.getById();
//            System.out.println(dataFromDB);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        // __________ Gestione Errore: FIND BY AND DELETE

//        try {
//            eventDAO.findAndDeleteById();
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

        // MANDATORY!! Come per lo Scanner, anche EntityManagerFactory & EntityManager hanno bisogno di essere chiusi

        em.close();
        emf.close();
    }
}
