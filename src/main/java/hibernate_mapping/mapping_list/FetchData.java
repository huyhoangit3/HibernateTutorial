package hibernate_mapping.mapping_list;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import java.util.List;

public class FetchData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        TypedQuery<Question> query = session.createQuery("from Question");
        List<Question> questions = query.getResultList();
        for (Question q : questions) {
            System.out.println("Question name: " + q.getQname());

            List<String> answers = q.getAnswers();
            for (String answer : answers) {
                System.out.println("  ++" + answer);
            }
        }
        session.close();
        sessionFactory.close();
    }
}
