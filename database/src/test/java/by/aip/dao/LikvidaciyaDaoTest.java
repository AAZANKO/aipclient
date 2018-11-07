package by.aip.dao;

import by.aip.dao.model.Client;
import by.aip.dao.model.Likvidaciya;
import by.aip.dao.model.Officer;
import by.aip.dao.model.Status;
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

public class LikvidaciyaDaoTest {

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
            result = session.createQuery("delete from Likvidaciya").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Likvidaciya likvidaciya = new Likvidaciya(34L, Client.builder().build(),Instant.now(),Instant.now(),Status.OPEN, Officer.builder().build());
            // сохраняем в БД
            Serializable id = session.save(likvidaciya);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Likvidaciya likvidaciya = new Likvidaciya();
            Serializable saveLikvidaciya = session.save(likvidaciya);
            assertNotNull(saveLikvidaciya);
            Likvidaciya getLikvidaciya = session.find(Likvidaciya.class, saveLikvidaciya);
            assertNotNull(getLikvidaciya);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Likvidaciya> list = session.createQuery("select l from Likvidaciya l", Likvidaciya.class).list();
            System.out.println("List: =" + list.size());
        }
    }

}