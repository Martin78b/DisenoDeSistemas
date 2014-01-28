/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

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
public interface IAnuncioService {
        
    
    public void agregar(Subcategoria subcate, Vendedor vendedor, Tipoanuncio tipoanuncio, String titulo,
            String descripcion, float preciobase, float precioactual, float preciominimo, Date fechainicio, Date fechafin, boolean estado, 
            int cantidadart); //agregar(Anuncio anuncio)
    
    public List<Anuncio> listar(); //List<Anuncio>
    
    public List<Anuncio> buscar(String texto); //List<Anuncio>
    
    public void comprar(int cantidad, Anuncio anuncio, int pago);
    
    public void pujar(float monto, Anuncio unAnuncio);
    
}
