/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AnuncioDAO;
import java.util.List;
import entidades.Anuncio;
import entidades.Subcategoria;
import entidades.Tipoanuncio;
import entidades.Vendedor;
import java.util.Date;

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
    public void agregar(Subcategoria subcate, Vendedor vendedor, Tipoanuncio tipoanuncio, String titulo,
            String descripcion, float preciobase, float preciominimo, Date fechafin, boolean estado, int cantidadart) {
        Anuncio anuncio = new Anuncio();
        anuncio.setSubcategoria(subcate);
        anuncio.setVendedor(vendedor);
        anuncio.setTipoanuncio(tipoanuncio);
        anuncio.setTitulo(titulo);
        anuncio.setDescripcion(descripcion);
        anuncio.setPreciobase(preciobase);
        anuncio.setPreciominimo(preciominimo);
        anuncio.setEstado(estado);
        anuncio.setCantarticulos(cantidadart);
        anuncio.setFechainicio(new Date());
        anunciodao.save(anuncio);
        
        
               

    }

}
