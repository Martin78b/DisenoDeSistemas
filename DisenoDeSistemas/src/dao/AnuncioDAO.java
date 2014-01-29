/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Anuncio;
import entidades.Categoria;
import entidades.Enlace;
import entidades.Imagen;
import entidades.Metododepago;
import entidades.Subcategoria;
import entidades.SubcategoriaId;
import entidades.Tipoanuncio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());

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
        } catch (HibernateException ex) {

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
        } catch (HibernateException ex) {

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
        } catch (HibernateException ex) {

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
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {

            Transaction tx = session.beginTransaction();
            //anuncio = (Anuncio) session.load(Anuncio.class, nro);
            anuncio = (Anuncio) session.createCriteria(Anuncio.class).add(Restrictions.idEq(nro)).uniqueResult();
            tx.commit();
        } catch (HibernateException ex) {

        } finally {
            session.flush();
            session.close();
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
        } catch (HibernateException ex) {

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
        } catch (HibernateException ex) {
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
        } catch (HibernateException ex) {

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
            enlace = (Enlace) query.uniqueResult();
            tx.commit();
            session.close();
        } catch (HibernateException ex) {

        }
        return enlace;
    }

    @Override
    public void metododepago(Anuncio anuncio, Metododepago metododepago) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        //metododepago.setAnuncios();
        session.save(metododepago);
        tx.commit();
        session.close();
    }

    @Override
    public Set metododepago(Anuncio anuncio) {
        Set listapago = null;
        int nro = anuncio.getNro();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            anuncio = (Anuncio) session.createCriteria(Anuncio.class).add(Restrictions.idEq(nro)).uniqueResult();
            listapago = anuncio.getMetododepagos();
            tx.commit();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        } finally {
            session.flush();
            session.close();
        }
        return listapago;
    }

    @Override
    public Tipoanuncio tipoanuncio(Anuncio anuncio) {
        Tipoanuncio tipo = new Tipoanuncio();
        Anuncio temp;
        int nro = anuncio.getNro();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Transaction tx = session.beginTransaction();
            temp = (Anuncio) session.createCriteria(Anuncio.class).add(Restrictions.idEq(nro)).uniqueResult();
            tipo.setCod(temp.getTipoanuncio().getCod());
            tipo.setNombre(temp.getTipoanuncio().getNombre());
            tx.commit();
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        } finally {
            session.flush();
            session.close();
        }
        return tipo;
    }

    @Override
    public List<Categoria> categorias() {
        List<Categoria> lista = new ArrayList<Categoria>();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Categoria");
            lista = query.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
        return lista;
    }

    @Override
    public List<Subcategoria> subcategorias(Categoria categoria) {
        List<Subcategoria> lista = new ArrayList<Subcategoria>();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Subcategoria where idcategoria=" + categoria.getIdcategoria());
            lista = query.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
        return lista;
    }

    @Override
    public List<Tipoanuncio> tipoanuncio() {
        List<Tipoanuncio> tiposanuncio = new ArrayList<Tipoanuncio>();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String hql = "FROM Tipoanuncio";
            Query query = session.createQuery(hql);
            tiposanuncio = (List) query.list();
            tx.commit();

        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        } finally {
            session.flush();
            session.close();
        }
        return tiposanuncio;
    }
    
    public Subcategoria subcategoria(SubcategoriaId id){
        Subcategoria subca= new Subcategoria();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            subca = (Subcategoria) session.get(Subcategoria.class, id);
            tx.commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.getMessage();
        }finally{
            session.flush();
            session.close();
        }
        return subca;
    }
}
