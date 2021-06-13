package hibernate_mapping.mapping_map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Question question = new Question();
        question.setQname("What is your major");

        Map<String, String> answers = new LinkedHashMap<>();
        answers.put("Information technology", "Luong Ba Hoang");
        answers.put("Accountant", "Nguyen Thi Van Anh");
        answers.put("Database administrator", "Do Vinh Ha");
        question.setAnswers(answers);

        session.persist(question);
        transaction.commit();
        System.out.println("Successfully saved.");
        sessionFactory.close();
        session.close();
    }
}
