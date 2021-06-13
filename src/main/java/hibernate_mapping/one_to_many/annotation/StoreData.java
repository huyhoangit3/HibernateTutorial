package hibernate_mapping.one_to_many.annotation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.LinkedHashSet;
import java.util.Set;

public class StoreData {
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
//            Department department = session.load(Department.class, 1);

//            session.delete(department);
            Employee employee = session.load(Employee.class, 4);
            session.delete(employee);
            /*Department department = new Department();
            department.setName("Finance Department");
            Employee emp1 = new Employee();
            emp1.setName("Hoang");
            emp1.setDepartment(department);
            Employee emp2 = new Employee();
            emp2.setName("Anh");
            emp2.setDepartment(department);

            Set<Employee> employees = new LinkedHashSet<>();
            employees.add(emp1);
            employees.add(emp2);
            department.setEmployees(employees);

            session.saveOrUpdate(department);*/
            transaction.commit();
            System.out.println("Successfully");
        }
    }
}
