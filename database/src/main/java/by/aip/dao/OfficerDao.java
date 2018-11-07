package by.aip.dao;

import by.aip.dao.model.Client;
import by.aip.dao.model.Officer;
import by.aip.dao.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
public class OfficerDao {

    private static final OfficerDao INSTANCE = new OfficerDao();

    public List<Officer> getOfficerDao() {

        System.out.println("=1=");

        List<Officer> listOfficer;
        listOfficer = null;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<Officer> query = session.createQuery("select o from Officer o", Officer.class);
            listOfficer = query.list();

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

/*        return Officer.builder()
                .id(1L)
                .firstName("Ivanov")
                .lastName("Ivan")
                .middleName("Ivanovich")
                .officerType(1)
                .officerCode(1)
                .datePrinyat(Instant.now())
                .dateUvolen(Instant.now())
                .status(Status.OPEN)
                .build();*/

        for (Officer officer : listOfficer) {
            System.out.println(officer.getId() + " " + officer.getFirstName() + " " + officer.getLastName() + " " +officer.getMiddleName());
        }
        return listOfficer;
    }

    public static OfficerDao getInstance() {
        return INSTANCE;
    }
}