package demo_jpa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.LinkedHashSet;


public class Main {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            /*Department department = new Department();
            department.setName("Information technology");
            department.setEmployees(new LinkedHashSet<>());

            Employee e1 = new Employee();
            e1.setName("Hoang");
            Employee e2 = new Employee();
            e2.setName("Anh");
            department.addEmployee(e1, e2);

            Department department1 = new Department();
            department1.setName("Finance department");
            department1.setEmployees(new LinkedHashSet<>());

            Employee e3 = new Employee();
            e3.setName("Linh");
            department1.addEmployee(e3);
            session.persist(department);
            session.persist(department1);*/
            Department department = session.load(Department.class, 1);
            System.out.println(department.getEmployees().size());
            transaction.commit();
            session.close();
            HibernateUtil.close();
        }
    }
}
