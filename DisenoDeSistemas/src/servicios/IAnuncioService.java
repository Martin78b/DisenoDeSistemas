/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.util.List;
import entidades.Subasta;

/**
 *
 * @author martin
 */
public interface IAnuncioService {
        
    
    public void agregar(Subasta subasta); //agregar(Anuncio anuncio)
    
    public List<Subasta> listar(); //List<Anuncio>
    
    public List<Subasta> buscar(String texto); //List<Anuncio>
    
    public void comprar(int cantidad, Subasta subasta, int pago);
    
    public void pujar(float monto, Subasta unSubasta);
    
}
