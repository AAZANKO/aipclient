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

public class ContractDaoTest {


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
            result = session.createQuery("delete from Contract").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Contract contract = new Contract("234234 - 4 / 234", Instant.now(), Client.builder().build(), Service.builder().build(), Officer.builder().build(), 4, 5000, 2000, 1000, 1000, 1000, Status.OPEN);
            // сохраняем в БД
            Serializable id = session.save(contract);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Contract contract = new Contract();
            Serializable saveContract = session.save(contract);
            assertNotNull(saveContract);
            Contract getContract = session.find(Contract.class, saveContract);
            assertNotNull(getContract);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Contract> list = session.createQuery("select c from Contract c", Contract.class).list();
            System.out.println("List: =" + list.size());
        }
    }
}