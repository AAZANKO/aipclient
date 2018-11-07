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

public class GraphikDaoTest {

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
            result = session.createQuery("delete from Graphik").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Graphik graphik = new Graphik(Contract.builder().build(), Client.builder().build(), Instant.now(), Instant.now(), 2, Auditor.builder().build(), Status.OPEN, Officer.builder().build());
            // сохраняем в БД
            Serializable id = session.save(graphik);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Graphik graphik = new Graphik();
            Serializable saveGraphik = session.save(graphik);
            assertNotNull(saveGraphik);
            Graphik getGraphik = session.find(Graphik.class, saveGraphik);
            assertNotNull(getGraphik);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Graphik> list = session.createQuery("select g from Graphik g", Graphik.class).list();
            System.out.println("List: =" + list.size());
        }

    }
}