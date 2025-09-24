package davidebraghi.dao;

import davidebraghi.entities.Event;
import davidebraghi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventDAO {

    // Qui a basso, DEFAULT delle righe di codice scritte

    private final EntityManager entityManager;

    public EventDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Metodo "save" che andremo a richiamare nel "Main" per salvare gli oggetti nella lista seguendo i passaggi descritti

    public void findAndDeleteById(long EventId) {

        // 1. Cerco l'Evento nel database tramite id
        Event getById = this.getById(EventId);

        // 2. Chiediamo all'entity manager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        // 4. Rimuoviamo l'Evento dal Persistence Context tramite metodo .remove() dell'Entity Manager (l'oggetto a questo punto non è ancora rimosso
        // dal db
        entityManager.remove(getById);

        // 5. Per rimuovere effettivamente l'Evento dalla tabella, bisogna fare un'operazione di commit tramite la transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("L'Evento " + getById.getTitle() + " è stato rimosso correttamente!");
    }

    // Metodo "getById" che andremo a richiamare nel "Main" per richiamare gli oggetti indicati presenti nella lista

    public void save(Event newEvent) {

        // 1. Chiediamo all'entity manager di creare una nuova transazione
        EntityTransaction transaction = entityManager.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Aggiungiamo il nuovo elemento "newEvent" al Persistence Context tramite metodo .persist() dell'Entity Manager (l'oggetto newEvent diventa MANAGED ma
        // non è ancora parte del database)
        entityManager.persist(newEvent);

        // 4. Per rendere effettivamente newEvent una nuova riga della tabella, bisogna fare un'operazione di commit tramite la transazione
        transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("L'Evento " + newEvent.getTitle() + " è stato salvato correttamente!");

    }

    // Metodo "findAndDeleteById" che andremo a richiamare nel "Main" per richiamare ed eliminare gli oggetti selezionati presenti nella lista seguendo i passaggi descritti

    public Event getById(long EventId) {
        Event foundEvent = entityManager.find(Event.class, EventId);
        if (foundEvent == null) throw new NotFoundException(EventId);
        return foundEvent;
    }
}
