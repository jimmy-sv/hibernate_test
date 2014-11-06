package com.jimmy.students.app;

import com.jimmy.students.entity.Book;
import com.jimmy.students.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class App {
    public static void main(String[] args) {

        /*
        Student student = new Student();
        student.setName("Mike");
        student.setId(1);
        */

       /*
        Book book1 = new Book();
        book1.setName("First Book");
        book1.setDescription("First Book Desc");
        book1.setStudent(student);
       */

        /*
        Book book2 = new Book();
        book2.setName("Fourth Book");
        book2.setDescription("Fourth Book Desc");
        book2.setStudent(student);
        */

        /*student.getBookList().add(book1);*/

        /*student.getBookList().add(book2);*/

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        /*session.save(student);*/
        /*session.refresh(student);*/
        /*session.save(book1);*/
        /*session.save(book2);*/

        org.hibernate.Query query = session.createQuery("from Student where id = :id order by name");
        query.setParameter("id",1);

        List<Student> stud = query.list();

        session.getTransaction().commit();
        session.close();

        /*Lazy init not work because session was commited and closed*/

        for(Student ent : stud){
            System.out.println(ent.getName());
            for(Book book : ent.getBookList()){
                System.out.println(book.getName());
            }
        }




    }
}
