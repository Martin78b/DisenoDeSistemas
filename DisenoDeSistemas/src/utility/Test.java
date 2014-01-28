/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import dao.AnuncioDAO;
import entidades.Anuncio;
import entidades.Imagen;
import entidades.Metododepago;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author martin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fos = new FileOutputStream("/home/martin/db.jpg");
        AnuncioDAO anunciodao = new AnuncioDAO();
        Imagen imagen = new Imagen();
        File archivo;
        /* try {
         /*Configuration cfg = new Configuration().configure();
         SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.openSession();
         Transaction tx = session.beginTransaction();
         String hql = "FROM Comprador E WHERE E.dni = 34666777";
         //Comprador u = (Comprador) session.load(Comprador.class, 35116194);
         Query query = session.createQuery(hql);
         Comprador c= (Comprador) query.list().get(0);
         tx.commit();
         System.out.println(c.getNombre());
         //System.out.println(u.getApellido());
             
            
         archivo = new File("/home/martin/Descargas/duster.jpg");
         byte[] bFile = new byte[(int) archivo.length()];
         fileInputStream = new FileInputStream(archivo);
         fileInputStream.read(bFile);
         fileInputStream.close();
         imagen.setArchivo(bFile);
         } catch (Exception ex) {
         ex.printStackTrace();
         } */
        Anuncio anuncio;
        //anuncio = (Anuncio) anunciodao.find(2);

        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        anuncio =(Anuncio) session.load(Anuncio.class, 2);
        //Metododepago metodo;
        //metodo = (Metododepago) session.load(Metododepago.class, 2);
        //anuncio = (Anuncio)session.createCriteria(Anuncio.class).add(Restrictions.idEq(2)).uniqueResult();
        System.out.println(anuncio.getTitulo() +"\n "
                            +anuncio.getPrecioactual());
        System.out.println(anuncio.isEstado() +"\n ");
        System.out.println(anunciodao.tipoanuncio(anuncio).getNombre()+"\n ");
        tx.commit();
        session.flush();
        session.close();
        //fos.write(imagen.getArchivo());
        //fos.close();
    }

}
