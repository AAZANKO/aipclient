package by.aip.dao;

import by.aip.dao.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;

public class AnketaDaoTest {

    // фабрика для открытия сессии
    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    // аннатация для закрытия соединения по окончании всех тестов
    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }


    @Before
    public void clean() {
        int result;
        try (Session session = FACTORY.openSession()) {
            session.beginTransaction();
            result = session.createQuery("delete from Anketa").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Anketa anketa = new Anketa(Contract.builder().build(), Client.builder().build(), 1, 1, Instant.now(), Instant.now(), Status.OPEN, Officer.builder().build());
            // сохраняем в БД
            Serializable id = session.save(anketa);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }


    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            //Anketa anketa = new Anketa();
            Anketa anketa = new Anketa(Contract.builder().build(), Client.builder().build(), 1, 1, Instant.now(), Instant.now(), Status.OPEN, Officer.builder().build());
            Serializable saveAnketa = session.save(anketa);
            assertNotNull(saveAnketa);
            Anketa getAnketa = session.find(Anketa.class, saveAnketa);
            assertNotNull(getAnketa);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Anketa> list = session.createQuery("select a from Anketa a", Anketa.class).list();
            System.out.println("List: =" + list.size());
        }
    }

}