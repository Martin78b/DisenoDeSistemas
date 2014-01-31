/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.Anuncio;
import entidades.Categoria;
import entidades.Enlace;
import entidades.Imagen;
import entidades.Metododepago;
import entidades.Subcategoria;
import entidades.Tipoanuncio;
import java.util.List;
import java.util.Set;
/**
 *
 * @author martin
 */
public interface IAnuncioDAO {
    
    public int save(Anuncio anuncio);
    
    public void update(Anuncio anuncio);
    
    public void delete(Anuncio anuncio);
    
    public List<Anuncio> findAll();
    
    public List<Anuncio> find(String anuncio);
    
    public Anuncio find(int nro);
    
    public boolean bid(Anuncio anuncio, float monto);
 
    public void imagen(int anuncio, Imagen imagen);
    
    public List<Imagen> imagen(Anuncio anuncio);
    
    public void enlace (Anuncio anuncio, Enlace enlace);
    
    public Enlace enlace (Anuncio anuncio);
    
    public void metododepago (Anuncio anuncio, Metododepago metododepago);
    
    public Set metododepago(Anuncio anuncio);
    
    public Tipoanuncio tipoanuncio(Anuncio anuncio);
    
    public List<Categoria> categorias();
    
    public List<Subcategoria> subcategorias(Categoria categoria);
    
    public List<Tipoanuncio> tipoanuncio();
}
