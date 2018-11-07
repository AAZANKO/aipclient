package by.aip.dao;

import by.aip.dao.model.AnalyticCode;
import by.aip.dao.model.AnalyticCodeDetail;
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

public class AnalyticCodeDaoTest {

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
            result = session.createQuery("delete from AnalyticCode").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            AnalyticCode analyticCode = new AnalyticCode(AnalyticCodeDetail.of(1L, 1L), "deteil", "deteil", "comment",Status.OPEN);
            // сохраняем в БД
            Serializable id = session.save(analyticCode);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            AnalyticCode analyticCode = new AnalyticCode(AnalyticCodeDetail.of(1L, 1L), "deteil", "deteil", "comment",Status.OPEN);
            // сохраняем в БД
            Serializable saveAnalyticCode = session.save(analyticCode);
            assertNotNull(saveAnalyticCode);
            AnalyticCode getAnalyticCode = session.find(AnalyticCode.class, saveAnalyticCode);
            assertNotNull(getAnalyticCode);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<AnalyticCode> list = session.createQuery("select a from AnalyticCode a", AnalyticCode.class).list();
            System.out.println("List: =" + list.size());
        }
    }
}