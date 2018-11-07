package by.aip.dao;

import by.aip.dao.model.Client;
import by.aip.dao.model.Contract;
import by.aip.dao.model.Officer;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OrmDemo {
    public static void main(String[] args) {

        Long offiserId = 1L;
        Long offiserId2 = 3L;

        // List<Officer> list = session.createQuery("select o from Officer o", Officer.class).list();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<Officer> query = session.createQuery("select o from Officer o", Officer.class);
            List<Officer> list = query.list();


            for (Officer officer : list) {
                System.out.println(officer.getId() + " " + officer.getFirstName() + " " + officer.getLastName() + " " +officer.getMiddleName());
            }

/*            Query<Client> query2 = session.createQuery("select c from Client c join fetch c.contract o where c.id = :officerId", Client.class)
                    .setParameter("officerId", offiserId);
            List<Client> list2 = query2.list();

            for (Client client: list2) {
                System.out.println(client.getId()+" "+client.getName()+" "+client.getUnp());
            }*/

            /*
            List<String> someList = new ArrayList<String>();

            // add "monkey", "donkey", "skeleton key" to someList
            for (String item : someList) {
                 System.out.println(item);
            }
             */

/*            Query<Client> query3 = session.createQuery("select c from Client c join c.contract ct where c.id = :officerId", Client.class)
                    .setParameter("officerId", offiserId);
            List<Client> list3 = query3.list();
*/

            session.getTransaction().commit();
            // session.beginTransaction().rollback();
            session.clear();
            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            sessionFactory.close();
            System.out.println("Exception e catch sessionFactory.close");
            System.out.println(e);
        }
        // sessionFactory.close();
    }
}
