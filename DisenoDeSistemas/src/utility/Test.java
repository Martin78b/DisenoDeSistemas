/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;
import org.hibernate.Session;
import entidades.Comprador;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author martin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        String hql = "FROM Comprador E WHERE E.username = 'caca' and E.contrasenia = 'nandito'";
        //Comprador u = (Comprador) session.load(Comprador.class, 35116194);
        Query query = session.createQuery(hql);
        Comprador c= (Comprador) query.list().get(0);
        tx.commit();
        System.out.println(c.getNombre());
        //System.out.println(u.getApellido());
        
    }
    
}
