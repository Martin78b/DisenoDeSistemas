/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.Anuncio;
import entidades.Imagen;
import java.util.List;
/**
 *
 * @author martin
 */
public interface IAnuncioDAO {
    
    public void save(Anuncio anuncio);
    
    public void update(Anuncio anuncio);
    
    public void delete(Anuncio anuncio);
    
    public List<Anuncio> findAll();
    
    public List<Anuncio> find(Anuncio anuncio);
    
    public Anuncio find(int nro);
    
    public boolean bid(Anuncio anuncio, float monto);
    
    public void imagen(Anuncio anuncio, Imagen imagen);
    
    public List<Imagen>  imagen(Anuncio anuncio);
    
}
