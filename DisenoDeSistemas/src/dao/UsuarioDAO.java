/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Comprador;
import entidades.Vendedor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author martin
 */
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public void save(Comprador usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Vendedor usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Comprador usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Vendedor usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int validate(String user, String pass) {
        int compra =0;
        List<Comprador> lista = new ArrayList<>();
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            String hql = "Select dni FROM Comprador E WHERE E.username = " + user
                    + " AND E.contrasenia = " + pass;
            Query query = session.createQuery(hql);
            compra = (int)query.uniqueResult();
            session.flush();
            session.close();
        } catch (Exception ex) {

        }
        return compra;
    }

    public List<String> listarUsuarios() {
        List<String> compradores = new ArrayList<>();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("SELECT username FROM Comprador");
            compradores = query.list();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
        return compradores;
    }
    
    public Vendedor getVendedor(int dni){
        Vendedor vendor = new Vendedor();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("SELECT username FROM Comprador");
            vendor = (Vendedor)query.uniqueResult();

        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            session.flush();
            session.close();
        }
        return vendor;
    }

}
