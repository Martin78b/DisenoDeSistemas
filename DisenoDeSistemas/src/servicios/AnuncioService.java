/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.util.List;
import entidades.Anuncio;
import entidades.Vendedor;

/**
 *
 * @author martin
 */
public class AnuncioService implements IAnuncioService{

    @Override
    public void agregar(Anuncio anuncio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    
    
    private void validarFecha (Anuncio anuncio){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Vendedor getVendedor (Anuncio anuncio){
        Vendedor v;
        v = new Vendedor();
        return v;
    }
    
    public void validarCompra(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
