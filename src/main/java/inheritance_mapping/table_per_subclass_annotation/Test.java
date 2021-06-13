package inheritance_mapping.table_per_subclass_annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = new Employee();
        employee.setName("Vinh");

        RegularEmployee regularEmployee = new RegularEmployee();
        regularEmployee.setName("Cuong");
        regularEmployee.setSalary(1000);
        regularEmployee.setBonus(200);

        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setName("Quan");
        contractEmployee.setPayPerHour(400);
        contractEmployee.setContractPeriod("2 nam");

        session.persist(employee);
        session.persist(regularEmployee);
        session.persist(contractEmployee);
        transaction.commit();
        System.out.println("Successfully saved.");
        sessionFactory.close();
        session.close();
    }
}
