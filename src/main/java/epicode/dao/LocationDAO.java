package epicode.dao;

import epicode.entities.Location;
import epicode.exceptions.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLocation);
        transaction.commit();
        System.out.println(newLocation + " è stata aggiunta");
    }

    public Location findById(String id) {
        Location found = entityManager.find(Location.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
