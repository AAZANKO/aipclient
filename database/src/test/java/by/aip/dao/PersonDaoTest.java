package by.aip.dao;

import by.aip.dao.model.Client;
import by.aip.dao.model.Officer;
import by.aip.dao.model.Person;
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

public class PersonDaoTest {

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
            result = session.createQuery("delete from Person").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }


    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Person person = new Person(Client.builder().build(),"Ivanov", "Ivan", "Ivanovich", Officer.builder().build(), "comment", Status.OPEN, 2L, 1L, Instant.now(), Instant.now());
            // сохраняем в БД
            Serializable id = session.save(person);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            Person person = new Person();
            Serializable savePerson = session.save(person);
            assertNotNull(savePerson);
            Person getPerson = session.find(Person.class, savePerson);
            assertNotNull(getPerson);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Person> list = session.createQuery("select p from Person p", Person.class).list();
            System.out.println("List: =" + list.size());
        }
    }

}