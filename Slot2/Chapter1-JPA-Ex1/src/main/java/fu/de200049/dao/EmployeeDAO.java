package fu.de200049.dao;


import fu.de200049.pojo.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDAO {

    private final EntityManagerFactory emf;

    public EmployeeDAO() {
        emf = Persistence.createEntityManagerFactory("hsf302PU");
    }

    public void save(Employee employee) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(employee);

            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            throw e;

        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}