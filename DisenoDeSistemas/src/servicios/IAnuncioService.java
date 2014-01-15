/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.util.List;

/**
 *
 * @author martin
 */
public interface IAnuncioService {
    
    /**
     * Faltan agregar algunos cambios.
     * Hay que hacerlo cuando estén creadas las entidades.
     */
    
    
    public void agregar(); //agregar(Anuncio anuncio)
    
    public List listar(); //List<Anuncio>
    
    public List buscar(String texto); //List<Anuncio>
    
    public void comprar(int cantidad, /*Anuncio anuncio,*/ int pago);
    
    public void pujar(float monto/*, Anuncio unAnuncio*/);
    
}
