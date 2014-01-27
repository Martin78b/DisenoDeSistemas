/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Anuncio;
import entidades.Enlace;
import entidades.Imagen;
import entidades.Metododepago;
import java.util.Iterator;
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

    List<Anuncio> listaanuncio = null;

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
            listaanuncio = query.list();
            session.close();
        } catch (Exception ex) {

        }
        return listaanuncio;
    }

    @Override
    public List<Anuncio> find(String anuncio) {
        listaanuncio = this.findAll();
        List<Anuncio> resultado = null;
        Anuncio temporal;
        Iterator iterador = listaanuncio.iterator();
        while (iterador.hasNext()) {
            temporal = (Anuncio) iterador.next();
            if (temporal.getTitulo().contains(anuncio)
                    || temporal.getDescripcion().contains(anuncio)) {
                resultado.add(temporal);
            }
        }
        return resultado;
    }

    @Override
    public Anuncio find(int nro) {
        Anuncio anuncio = null;
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            anuncio = (Anuncio) session.load(Anuncio.class, nro);
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
        List<Imagen> imagen = null;
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            String hql = "FROM Imagen E WHERE E.anuncio =" + anuncio.getNro();
            Query query = session.createQuery(hql);
            imagen = query.list();
            tx.commit();
            session.close();
        } catch (Exception ex) {
            session.getTransaction().rollback();
        }
        return imagen;
    }

    @Override
    public void enlace(Anuncio anuncio, Enlace enlace) {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            enlace.setAnuncio(anuncio);
            session.save(enlace);
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
    }

    @Override
    public Enlace enlace(Anuncio anuncio) {
        Enlace enlace = null;
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String hql = "FROM Enlace E WHERE E.anuncio =" + anuncio.getNro();
            Query query = session.createQuery(hql);
            enlace = (Enlace) query.list().get(0);
            tx.commit();
            session.close();
        } catch (Exception ex) {

        }
        return enlace;
    }

    @Override
    public void metododepago(Anuncio anuncio, Metododepago metododepago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Metododepago> metododepago(Anuncio anuncio) {
        
        /*Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try{
            Transaction tx = session.beginTransaction();
        anuncio = (Anuncio) session.get(Anuncio.class, anuncio.getNro());
        listapago=(List)anuncio.getMetododepagos();
        tx.commit();
        session.close();
        }
        catch (Exception ex){
            session.getTransaction().rollback();
        }*/
        return (List) anuncio.getMetododepagos();
    }

}
