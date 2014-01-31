/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import entidades.Vendedor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import servicios.AnuncioService;
import servicios.UsuarioService;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

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
     //   UsuarioService us = new UsuarioService();
      //  Vendedor vendor = us.obtenerVendedor(us.validar("murai", "megustaelcafe"));

        //System.out.println(vendor.getCuil());
        AnuncioService as = new AnuncioService();
 //       agregar(int categoria, int subcategoria, Vendedor vendedor, int tipoanuncio, String titulo,
    //    String descripcion, float preciobase, float preciominimo, Date fechafin, boolean estado, int cantidadart) {
        DateFormat formatofecha = new SimpleDateFormat("yyyy-mm-dd");
        Calendar cal = Calendar.getInstance();
     //   cal.setTime(new Date());
     //   cal.add(Calendar.DATE, 5);
      //  anuncioservice.agregar(jComboBox3.getSelectedIndex(), jComboBox4.getSelectedIndex(), vendedor, jComboBox1.getSelectedIndex(), jTextField1.getText(), jTextArea1.getText(), Float.parseFloat(jTextField2.getText()), 0,cal.getTime(), true, 1);
     //   as.agregar(1, "Laptop", vendor, 4, "titulo", "descripcion", 5000, 0, cal.getTime(), true, 1);
}
}
