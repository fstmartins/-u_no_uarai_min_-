package org.charlie.rapbattle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prod");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
