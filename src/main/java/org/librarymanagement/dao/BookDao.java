package org.librarymanagement.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.librarymanagement.dto.Book;
import org.librarymanagement.util.HibernateUtil;

import java.util.List;

public class BookDao {
    public void addBook(Book book) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(book);

        transaction.commit();
        session.close();
    }

    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createQuery("from Book", Book.class).list();
        session.close();
        return books;
    }
}
