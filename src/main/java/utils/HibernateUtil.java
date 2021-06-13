package utils;

import demo_jpa.Department;
import demo_jpa.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        super();
    }

    private static void buildSessionFactoryFromXML() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure() // Load hibernate.cfg.xml from resource folder by default
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    private static void buildSessionFactoryFromJavaCode() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties  settings = new Properties();
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            settings.put(Environment.HBM2DDL_AUTO, "update");
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo_jpa");
            settings.put(Environment.USER, "hoang");
            settings.put(Environment.PASS, "hoang2kthptlk");
            settings.put(Environment.SHOW_SQL, "true");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Department.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
    }

    public static SessionFactory getSessionFactory() {
        buildSessionFactoryFromJavaCode();
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }
}
