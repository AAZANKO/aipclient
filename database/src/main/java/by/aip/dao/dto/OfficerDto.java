package by.aip.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfficerDto {

    private String name;

    /*public boolean createUser(NewUserDTO newUserDTO) {
        try {
            sessionFactory = DBUtils.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(newUserDTO);
            session.getTransaction().commit();
        } catch (RuntimeException runtimeException) {
            LOGGER.error(runtimeException);
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;


        static {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = auditConfiguration.buildSessionFactory(serviceRegistry);
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
*/


}
