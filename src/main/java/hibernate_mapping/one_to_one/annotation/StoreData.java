package hibernate_mapping.one_to_one.annotation;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class StoreData {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Address address = new Address();
            address.setDistrict("Hai Hau");
            address.setProvince("Nam Dinh");

            Worker worker = new Worker();
            worker.setName("Phong");
            worker.setAdress(address);
            address.setWorker(worker);

            session.persist(worker);
            transaction.commit();
            System.out.println("Successfully.");
        }
    }
}
