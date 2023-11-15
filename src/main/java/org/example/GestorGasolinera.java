package org.example;

import javax.persistence.*;
import java.util.List;

public class GestorGasolinera {
    private EntityManagerFactory emf;
    private EntityManager em;

    public GestorGasolinera() {
        emf = Persistence.createEntityManagerFactory("per_gasolinera");
        em = emf.createEntityManager();
    }

    public void insertarRepostaje(Repostaje repostaje) {
        em.getTransaction().begin();
        em.persist(repostaje);
        em.getTransaction().commit();
    }

    public void insertarLlenadoDeposito(LlenadoDeposito llenadoDeposito) {
        em.getTransaction().begin();
        em.persist(llenadoDeposito);
        em.getTransaction().commit();
    }

    public void verTodosLosRepostajes() {
        TypedQuery<Repostaje> query = em.createQuery("SELECT r FROM Repostaje r", Repostaje.class);
        List<Repostaje> repostajes = query.getResultList();

        for (Repostaje repostaje : repostajes) {
            if (repostaje instanceof RepostajeNormal) {
                System.out.println("Repostaje Normal: " + repostaje);
            } else if (repostaje instanceof RepostajeFactura) {
                System.out.println("Repostaje Factura: " + repostaje);
            }
        }
    }

    public double calcularImporteTotalCombustibleVendido() {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT SUM(r.importe) FROM Repostaje r");
        Double total = (Double) query.getSingleResult();
        em.getTransaction().commit();

        return total != null ? total : 0.0;
    }

    public void eliminarUltimoLlenadoDeposito() {
        em.getTransaction().begin();

        // Encuentra el último llenado de depósito basado en fecha y hora
        Query query = em.createQuery("SELECT ld FROM LlenadoDeposito ld ORDER BY ld.fecha DESC, ld.hora DESC");
        query.setMaxResults(1);  // Limita a solo el más reciente
        LlenadoDeposito ultimoLlenado = (LlenadoDeposito) query.getSingleResult();

        // Elimina el último llenado de depósito
        if (ultimoLlenado != null) {
            em.remove(ultimoLlenado);
        }

        em.getTransaction().commit();
    }

    public void verTodosLosLlenadosDeposito() {
        em.getTransaction().begin();

        // Realiza una consulta para obtener todos los llenados de depósito
        TypedQuery<LlenadoDeposito> query = em.createQuery("SELECT ld FROM LlenadoDeposito ld", LlenadoDeposito.class);
        List<LlenadoDeposito> todosLosLlenados = query.getResultList();

        // Muestra cada llenado de depósito
        for (LlenadoDeposito llenado : todosLosLlenados) {
            System.out.println(llenado);
        }

        em.getTransaction().commit();
    }
    public void cerrar() {
        em.close();
        emf.close();
    }
}
