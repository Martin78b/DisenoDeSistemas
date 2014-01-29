/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AnuncioDAO;
import java.util.List;
import entidades.Anuncio;
import entidades.Categoria;
import entidades.Imagen;
import entidades.Subcategoria;
import entidades.SubcategoriaId;
import entidades.Tipoanuncio;
import entidades.Vendedor;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import utility.DetectorDeSO;

/**
 *
 * @author martin
 */
public class AnuncioService implements IAnuncioService {

    AnuncioDAO anunciodao = new AnuncioDAO();

    @Override
    public List<Anuncio> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Anuncio> buscar(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void comprar(int cantidad, Anuncio anuncio, int pago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pujar(float monto, Anuncio anuncio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarFecha(Anuncio anuncio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Vendedor getVendedor(Anuncio anuncio) {
        Vendedor v;
        v = new Vendedor();
        return v;
    }

    public void validarCompra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregar(int categoria, int subcategoria, Vendedor vendedor, Tipoanuncio tipoanuncio, String titulo,
            String descripcion, float preciobase, float preciominimo, Date fechafin, boolean estado, int cantidadart) {
        Anuncio anuncio = new Anuncio();
        SubcategoriaId id = new SubcategoriaId(subcategoria, categoria);
        anuncio.setSubcategoria(anunciodao.subcategoria(id));
        anuncio.setVendedor(vendedor);
        anuncio.setTipoanuncio(tipoanuncio);
        anuncio.setTitulo(titulo);
        anuncio.setDescripcion(descripcion);
        anuncio.setPreciobase(preciobase);
        anuncio.setPreciominimo(preciominimo);
        anuncio.setEstado(estado);
        anuncio.setCantarticulos(cantidadart);
        anuncio.setFechainicio(new Date());
        anuncio.setFechafin(fechafin);
        anunciodao.save(anuncio);
    }

    public void agregarImagen(Anuncio anuncio, String direccion) {
        File archivo = new File(direccion);
        FileInputStream fileInputStream;
        byte[] bFile = new byte[(int) archivo.length()];
        try{
        fileInputStream = new FileInputStream(archivo);
        fileInputStream.read(bFile);
        fileInputStream.close();
        } catch (IOException e){
            
        }
        Imagen imagen = new Imagen();
        imagen.setArchivo(bFile);
        anunciodao.imagen(anuncio, imagen);
    }
    
    public BufferedImage getImagen(Anuncio anuncio){
        BufferedImage buff= null;
        ByteArrayInputStream bais = new ByteArrayInputStream(anunciodao.imagen(anuncio).get(0).getArchivo());
        try{
        buff = ImageIO.read(bais);
        } catch(IOException e){
            //e.printStackTrace();
        }
        return buff;
        //FileInputStream fileInputStream = null;
        //FileOutputStream fos = new FileOutputStream("C:\\Users\\Mauricio\\Desktop\\DB.jpg");
        //fos.write(imagen.getArchivo());
        //fos.close();
    }
    
    public List<String> tipoanuncios(){
        List<Tipoanuncio> listatipos = anunciodao.tipoanuncio();
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < listatipos.size(); i++) {
            lista.add(listatipos.get(i).getNombre());
        }
        return lista;
    }
    
    public List<String> categorias (){
        List<Categoria> listacategoria = anunciodao.categorias();
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < listacategoria.size(); i++) {
            lista.add(listacategoria.get(i).getNombre());
        }
        return lista;
    }
    
    public List<String> subcategorias (int cat){
        Categoria categoria = new Categoria(cat, null);
        List<Subcategoria> listasubcategoria = anunciodao.subcategorias(categoria);
        List<String> lista = new ArrayList<>();
        for (int i = 0; i < listasubcategoria.size(); i++) {
            lista.add(listasubcategoria.get(i).getNombre());
        }
        return lista;
    }

}
