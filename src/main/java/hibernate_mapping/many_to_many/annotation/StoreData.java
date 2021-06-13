package hibernate_mapping.many_to_many.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.HashSet;
import java.util.Set;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Category category = new Category("Electronic Device");
        Product product1 = new Product("Television");
        Product product2 = new Product("Iphone");
        Product product3 = new Product("Samsung Galaxy S9");

        Set<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        category.setProducts(products);

        session.persist(category);
        transaction.commit();
        System.out.println("Successfully saved.");
        sessionFactory.close();
        session.close();
    }
}
