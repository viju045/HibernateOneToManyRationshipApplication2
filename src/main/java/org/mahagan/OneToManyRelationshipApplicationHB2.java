package org.mahagan;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Answers;
import org.mahagan.domain.Question;

import java.util.ArrayList;
import java.util.List;
public class OneToManyRelationshipApplicationHB2 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr =new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        Answers answers = new Answers();
        answers.setAnsName("Learing Hibenate with JPA");
        answers.setCreatedBy("Vijay");
        answers.setPostedBy("Vijay Mohite");

        Answers answers2 = new Answers();
        answers2.setAnsName("Learing Spring-Boot");
        answers2.setCreatedBy("Sumit");
        answers2.setPostedBy("Sumit Mohite");

        Answers answers3 = new Answers();
        answers3.setAnsName("Learing Rest API");
        answers3.setCreatedBy("Raj");
        answers3.setPostedBy("Raj Patil");

        List<Answers>list2 = new ArrayList<Answers>();
        list2.add(answers);
        list2.add(answers2);
        list2.add(answers3);

        Question question = new Question();
        question.setQuestionName("What is Hibernate???????");

        question.setAnswers(list2);
        session.persist(question);

        tsx.commit();
        session.close();

        System.out.println(" Data has Been Successfully Inserted ,,,,,,,,,, OK! Done");
    }
}
