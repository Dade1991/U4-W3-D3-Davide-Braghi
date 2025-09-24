package epicode.dao;

import epicode.entities.Persona;
import epicode.exceptions.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPersona);
        transaction.commit();
        System.out.println(newPersona + " è stato aggiunto all'evento.");
    }

    public Persona findById(String id) {
        Persona found = entityManager.find(Persona.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
