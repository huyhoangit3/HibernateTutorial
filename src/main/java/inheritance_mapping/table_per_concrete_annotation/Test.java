package inheritance_mapping.table_per_concrete_annotation;

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
        employee.setName("Ha");

        RegularEmployee regularEmployee = new RegularEmployee();
        regularEmployee.setName("Dung");
        regularEmployee.setSalary(2000);
        regularEmployee.setBonus(100);

        ContractEmployee contractEmployee = new ContractEmployee();
        contractEmployee.setName("Phong");
        contractEmployee.setPayPerHour(200);
        contractEmployee.setContractPeriod("7 nam");

        session.persist(employee);
        session.persist(contractEmployee);
        session.persist(regularEmployee);
        transaction.commit();
        System.out.println("Successfully saved.");
        sessionFactory.close();
        session.close();
    }
}
