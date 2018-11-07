package by.aip.dao;

import by.aip.dao.model.Client;
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

public class ClientDaoTest {

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
            result = session.createQuery("delete from Client").executeUpdate();
            System.out.println("result= " + result);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveEntity() {
        try (Session session = FACTORY.openSession()) {
            // создаем объект
            Client client = new Client("12-4mc/8", "Ivan company", "Ivanovich", 1, 1, Instant.now(), Instant.now(), 206941123, "BY23BSBB301212312345010040", "Minsk", "Pobedy", "20", "Minsk", "Pobedy", "20", 2, 3, 2000, Status.OPEN, Officer.builder().build());
            // сохраняем в БД
            Serializable id = session.save(client);
            // проверяем сохранился ли?
            assertNotNull(id);
        }
    }

    @Test
    public void checkGetById() {
        try (Session session = FACTORY.openSession()) {
            // Client client = new Client();
            Client client = new Client("12-4mc/8", "Ivan company", "Ivanovich", 1, 1, Instant.now(), Instant.now(), 206941123, "BY23BSBB301212312345010040", "Minsk", "Pobedy", "20", "Minsk", "Pobedy", "20", 2, 3, 2000, Status.OPEN, Officer.builder().build());
            Serializable saveClient = session.save(client);
            assertNotNull(saveClient);
            Client getClient = session.find(Client.class, saveClient);
            assertNotNull(getClient);
        }
    }

    @Test
    public void checkGetAll() {
        try (Session session = FACTORY.openSession()) {
            List<Client> list = session.createQuery("select c from Client c", Client.class).list();
            System.out.println("List: =" + list.size());
        }

    }
}