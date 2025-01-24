package org.librarymanagement.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.librarymanagement.dto.Author;
import org.librarymanagement.util.HibernateUtil;

import java.util.List;

public class AuthorDao {
    public void addAuthor(Author author) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(author);

        transaction.commit();
        session.close();
    }

    public List<Author> getAllAuthors() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();
        session.close();
        return authors;
    }
}
