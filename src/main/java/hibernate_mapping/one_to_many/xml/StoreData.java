package hibernate_mapping.one_to_many.xml;

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
        question.setQname("Where are you from?");
        Answer a1 = new Answer();
        a1.setAcontent("Thanh Hoa");
        a1.setAby("Hoang");

        Answer a2 = new Answer();
        a2.setAcontent("Ha Noi");
        a2.setAby("Ha");

        List<Answer> answers = new ArrayList<>();
        answers.add(a1);
        answers.add(a2);

        question.setAnswers(answers);

        session.persist(question);
        transaction.commit();
        System.out.println("Successfully saved.");
        sessionFactory.close();
        session.close();
    }
}
