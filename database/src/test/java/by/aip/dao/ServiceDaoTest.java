package by.aip.dao;

import by.aip.dao.model.Service;
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

public class ServiceDaoTest {

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
            result = session.createQuery("delete from Service").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Service service = new Service("service", "service", Status.OPEN, Instant.now(), Instant.now());
            // сохраняем в БД
            Serializable id = session.save(service);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }


    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Service service = new Service();
            Serializable saveService = session.save(service);
            assertNotNull(saveService);
            Service getService = session.find(Service.class, saveService);
            assertNotNull(getService);
        }
    }


    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Service> list = session.createQuery("select s from Service s", Service.class).list();
            System.out.println("List: =" + list.size());
        }
    }

}