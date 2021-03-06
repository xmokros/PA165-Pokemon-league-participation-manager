package cz.muni.fi.pa165.pokemon.league.participation.manager.dao;

import cz.muni.fi.pa165.pokemon.league.participation.manager.entities.Badge;
import cz.muni.fi.pa165.pokemon.league.participation.manager.entities.Gym;
import cz.muni.fi.pa165.pokemon.league.participation.manager.entities.Trainer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * Implementation of BadgeDAO using JPA/Hibernate and Spring stereotypes.
 *
 * @author Tibor Zauko 433531
 */
@Repository
public class BadgeDAOImpl implements BadgeDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void createBadge(Badge badge) {
        em.persist(badge);
    }

    @Override
    public void updateBadge(Badge badge) {
        em.merge(badge);
    }

    @Override
    public void deleteBadge(Badge badge) {
        em.remove(em.contains(badge) ? badge : em.merge(badge));
    }

    @Override
    public Badge findBadgeById(Long id) {
        return em.find(Badge.class, id);
    }

    @Override
    public List<Badge> getAllBadges() {
        return em.createQuery("select b from Badge b", Badge.class).getResultList();
    }

    @Override
    public List<Badge> findBadgesOfGym(Gym gym) {
        return em.createQuery("SELECT b FROM Badge b WHERE b.gym = :g", Badge.class)
                .setParameter("g", gym).getResultList();
    }

    @Override
    public List<Badge> findBadgesOfTrainer(Trainer trainer) {
        return em.createQuery("SELECT b FROM Badge b WHERE b.trainer = :t", Badge.class)
                .setParameter("t", trainer).getResultList();
    }
}
