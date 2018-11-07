package by.aip.dao;

import by.aip.dao.model.Auditor;
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

public class AuditorDaoTest {
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
            result = session.createQuery("delete from Auditor").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Auditor auditor = new Auditor("Ivanonv", "Ivan", "Ivanovich", 1, 1, Instant.now(), Instant.now(), Status.OPEN, Officer.builder().build());
            // сохраняем в БД
            Serializable id = session.save(auditor);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Auditor auditor = new Auditor();
            Serializable saveAuditor = session.save(auditor);
            assertNotNull(saveAuditor);
            Auditor getAuditor = session.find(Auditor.class, saveAuditor);
            assertNotNull(getAuditor);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Auditor> list = session.createQuery("select a from Auditor a", Auditor.class).list();
            System.out.println("List: =" + list.size());
        }
    }

}