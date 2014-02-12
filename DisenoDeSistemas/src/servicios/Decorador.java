/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import entidades.Anuncio;
import entidades.Enlace;
import entidades.Imagen;
import entidades.Metododepago;

/**
 *
 * @author martin
 */
public abstract class Decorador extends Anuncio{
    
    public void agregar (Object elemento){
        if(elemento.getClass()==Imagen.class){
            super.getImagens().add(elemento);
        } else if (elemento.getClass()==Metododepago.class){
            super.getMetododepagos().add(elemento);
        } else if (elemento.getClass()==Enlace.class){
            super.getEnlaces().add(elemento);
        }
    }
    
    public void comentar (String texto){
        
    }
    
}
