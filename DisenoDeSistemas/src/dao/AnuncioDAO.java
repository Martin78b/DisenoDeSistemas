/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Anuncio;
import entidades.Imagen;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author martin
 */
public class AnuncioDAO implements IAnuncioDAO {

    
    List<Anuncio> lista = null;
    
    
    @Override
    public void save(Anuncio anuncio) {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(anuncio);
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
    }

    @Override
    public void update(Anuncio anuncio) {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(anuncio);
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
    }

    @Override
    public void delete(Anuncio anuncio) {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(anuncio);
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
    }

    @Override
    public List<Anuncio> findAll() {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("");
            lista = query.list();
            session.close();
        } catch (Exception ex) {

        }
        return lista;
    }

    @Override
    public List<Anuncio> find(Anuncio anuncio) {
        
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            Serializable id = session.getIdentifier(anuncio);
            lista.add((Anuncio) session.get(Anuncio.class, id));
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
        return lista;
    }
    
    @Override
    public Anuncio find(int nro) {
        Anuncio  anuncio = null;
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            anuncio= (Anuncio) session.get(Anuncio.class, nro);
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
        return anuncio;
    }

    @Override
    public boolean bid(Anuncio anuncio, float monto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imagen(Anuncio anuncio, Imagen imagen) {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            imagen.setAnuncio(anuncio);
            session.save(imagen);
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
    }

    @Override
    public List<Imagen> imagen(Anuncio anuncio) {    
        List<Imagen> imagen=null;
        try{
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            
            String hql = "FROM Imagen E WHERE E.anuncio ="+ anuncio.getNro();
            Query query = session.createQuery(hql);
            imagen = query.list();
            tx.commit();
            session.close();
            }
            catch (Exception ex){
                
            }
            return imagen;
    }

}
