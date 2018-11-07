package by.aip.dao;

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

/***
 * FATAL -> ERROR -> WARN -> INFO -> DEBUG -> TRACE
 */

public class OfficerDaoTest {

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
            result = session.createQuery("delete from Officer").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Officer officer = new Officer("Ivanov", "Ivan", "Ivanovich", 1, 1, Instant.now(), Instant.now(), Status.CLOSED);
            // сохраняем в БД
            Serializable id = session.save(officer);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Officer officer = new Officer();
            Serializable saveOfficer = session.save(officer);
            assertNotNull(saveOfficer);
            Officer getOfficer = session.find(Officer.class, saveOfficer);
            assertNotNull(getOfficer);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Officer> list = session.createQuery("select o from Officer o", Officer.class).list();
            System.out.println("List: =" + list.size());
        }
    }

}