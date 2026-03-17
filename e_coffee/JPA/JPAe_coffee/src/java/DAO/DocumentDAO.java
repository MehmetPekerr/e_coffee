package DAO;

import Entity.Document;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class DocumentDAO {

    @PersistenceContext(unitName = "JPAe_coffeePU")
    private EntityManager em;

    public void insert(Document document) {
        try {
            em.persist(document);
        } catch (Exception e) {
            throw new RuntimeException("Document insertion error: " + e.getMessage());
        }
    }

    public List<Document> findAll() {
        TypedQuery<Document> query = em.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }
}
