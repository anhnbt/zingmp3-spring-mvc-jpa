package vn.codegym.zingmp3.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import vn.codegym.zingmp3.model.Song;

import java.util.List;

@Service
public class HibernateSongService implements ISongService {
    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;


    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
//            sessionFactory.close();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Song> findAll() {
        // Java Persistence Query Language (JPQL)
        String queryStr = "SELECT c FROM Song AS c";
        TypedQuery<Song> query = entityManager.createQuery(queryStr, Song.class);
        return query.getResultList();
    }

    @Override
    public List<Song> search(String name, String artist, String genre) {
        // Java Persistence Query Language (JPQL)
        TypedQuery<Song> query = entityManager.createNamedQuery("findAllSongsWithNameArtistGenre", Song.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("artist", "%" + artist + "%")
                .setParameter("genre", "%" + genre + "%");
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        Transaction transaction = null;
        Song origin;
        if (song.getId() == null) {
            origin = new Song();
        } else {
            origin = findById(song.getId());
        }
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            if (!transaction.isActive()) {
                transaction.begin();
            }
            origin.setName(song.getName());
            origin.setArtist(song.getArtist());
            origin.setGenre(song.getGenre());
            origin.setUrl(song.getUrl());
            session.saveOrUpdate(song);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Song findById(Long id) {
        String query = "SELECT c FROM Song AS c WHERE c.id = :id";
        TypedQuery<Song> typedQuery = entityManager.createQuery(query, Song.class).setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void remove(Long id) {
        Song song = findById(id);
        if (song != null) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.getTransaction();
                if (!transaction.isActive()) {
                    transaction.begin();
                }
                session.remove(song);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }
    }
}