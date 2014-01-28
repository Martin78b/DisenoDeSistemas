/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import dao.AnuncioDAO;
import entidades.Anuncio;
import entidades.Categoria;
import entidades.Imagen;
import entidades.Metododepago;
import entidades.Subcategoria;
import entidades.SubcategoriaId;
import entidades.Tipoanuncio;
import entidades.Vendedor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import servicios.AnuncioService;

/**
 *
 * @author martin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        
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
         } */
        //Anuncio anuncio;
        //anuncio = (Anuncio) anunciodao.find(2);

        //Configuration cfg = new Configuration().configure();
        //SessionFactory factory = cfg.buildSessionFactory();
        //Session session = factory.openSession();
        //Transaction tx = session.beginTransaction();
        //Vendedor vendedor = (Vendedor) session.load(Vendedor.class, 35116194);
        //Tipoanuncio tipo = (Tipoanuncio) session.load(Tipoanuncio.class, 5);
        //SubcategoriaId subcatego = new SubcategoriaId(2, 2);
        //Subcategoria subca = (Subcategoria) session.load(Subcategoria.class, subcatego);
        //Calendar cal = new GregorianCalendar(2014, 1, 31);
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date fechafin = cal.getTime();
        
        //Metododepago metodo;
        //metodo = (Metododepago) session.load(Metododepago.class, 2);
        //anuncio = (Anuncio)session.createCriteria(Anuncio.class).add(Restrictions.idEq(2)).uniqueResult();
       // tx.commit();
        //session.flush();
        //session.close();
        //AnuncioService anuncioserv = new AnuncioService();
        //anuncioserv.agregar(subca, vendedor, tipo, "Yamaha", "Impecable", 50000, 0, sdf.parse("2014-1-31"), true, 1);
        
        //fos.write(imagen.getArchivo());
        //fos.close();*/
        AnuncioService as = new AnuncioService();
        List<String> lista = as.tipoanuncios();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
            
        }
        
    }
}
