package hibernate_mapping.component_mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Address address = new Address();
        address.setCommune("Xuan Phu");
        address.setDistrict("Tho Xuan");
        address.setProvince("Thanh Hoa");

        Employee employee = new Employee();
        employee.setName("Hoang");
        employee.setAddress(address);

        Employee employee1 = new Employee();
        employee1.setName("Anh");
        employee1.setAddress(address);

        session.persist(employee);
        session.persist(employee1);
        transaction.commit();
        System.out.println("Successfully saved.");
        sessionFactory.close();
        session.close();
    }
}
