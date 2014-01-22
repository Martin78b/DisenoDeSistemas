/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import dao.AnuncioDAO;
import entidades.Anuncio;
import entidades.Imagen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.proxy.HibernateProxy;

/**
 *
 * @author martin
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = null; //Para guardar una imagen
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Mauricio\\Desktop\\db.jpg"); //Para recueperar una imagen
        AnuncioDAO anunciodao = new AnuncioDAO();
        Anuncio anuncio;
        anuncio = (Anuncio) anunciodao.find(7);        
        Imagen imagen = new Imagen();
        File archivo;
      /*  try {
  BUSCAR UN USUARIO      
            Configuration cfg = new Configuration().configure();
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
  
  GUARDAR UNA IMAGEN EN LA BASE DE DATOS
            archivo = new File("C:\\Users\\Mauricio\\Desktop\\caca.jpg");
            byte[] bFile = new byte[(int) archivo.length()];
            fileInputStream = new FileInputStream(archivo);
            fileInputStream.read(bFile);
            fileInputStream.close();
            imagen.setArchivo(bFile);
            anunciodao.imagen(anuncio, imagen);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 

        }
              */
        //
        anuncio = (Anuncio) anunciodao.find(7);
        imagen= anunciodao.imagen(anuncio).get(0);
        fos.write(imagen.getArchivo());
        fos.close();
    }}
    
