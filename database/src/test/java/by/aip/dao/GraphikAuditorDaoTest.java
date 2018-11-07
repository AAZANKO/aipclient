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

public class GraphikAuditorDaoTest {

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
            result = session.createQuery("delete from GraphikAuditor").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            GraphikAuditor graphikAuditor = new GraphikAuditor(Graphik.builder().build(), Auditor.builder().build(), Instant.now(),"comment", Officer.builder().build(), Status.CLOSED);
            // сохраняем в БД
            Serializable id = session.save(graphikAuditor);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            GraphikAuditor graphikAuditor = new GraphikAuditor();
            Serializable saveGraphikAuditor = session.save(graphikAuditor);
            assertNotNull(saveGraphikAuditor);
            GraphikAuditor getGraphikAuditor = session.find(GraphikAuditor.class, saveGraphikAuditor);
            assertNotNull(getGraphikAuditor);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<GraphikAuditor> list = session.createQuery("select ga from GraphikAuditor ga", GraphikAuditor.class).list();
            System.out.println("List: =" + list.size());
        }
    }
}