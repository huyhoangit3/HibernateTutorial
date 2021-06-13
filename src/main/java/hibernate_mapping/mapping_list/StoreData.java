package hibernate_mapping.mapping_list;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Question question = new Question();
        question.setQname("What is Servlet in Java?");
        List<String> answers = new ArrayList<>();
        answers.add("Servlet is a technology that creates webpages.");
        answers.add("Servlet is an API that provides many interfaces and " +
                "classes including documentation.");
        question.setAnswers(answers);

        session.persist(question);
        transaction.commit();
        System.out.println("Successfully saved.");
        sessionFactory.close();
        session.close();
    }
}
