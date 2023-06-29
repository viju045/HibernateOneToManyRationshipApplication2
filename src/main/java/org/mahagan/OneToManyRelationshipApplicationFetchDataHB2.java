package org.mahagan;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mahagan.domain.Answers;
import org.mahagan.domain.Question;

import java.util.Iterator;
import java.util.List;

public class OneToManyRelationshipApplicationFetchDataHB2 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr =new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction tsx = session.beginTransaction();

        TypedQuery query = session.createQuery("from Question question");
        List<Question>list = query.getResultList();
        Iterator<Question>iterator = list.listIterator();

        while(iterator.hasNext()){
            Question question = iterator.next();
            System.out.println("Name of the will be ------------->>>>>>>>>>>>>>"+question.getQuestionName());

            List<Answers>list1 = question.getAnswers();
            Iterator<Answers>iterator1 = list1.iterator();
            while(iterator1.hasNext())
            {
                Answers answers = iterator1.next();
                System.out.println(answers.getAnsName()+ " "+answers.getCreatedBy()+" "+answers.getPostedBy());
            }

        }
        session.close();
        System.out.println("Fetach data successfully");
    }
}
