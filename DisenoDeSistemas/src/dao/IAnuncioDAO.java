/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.Subasta;
import java.util.List;
/**
 *
 * @author martin
 */
public interface IAnuncioDAO {
    
    public void save(Subasta subasta);
    
    public void update(Subasta subasta);
    
    public void delete(Subasta subasta);
    
    public List<Subasta> findAll();
    
    public List<Subasta> find(Subasta subasta);
    
    public boolean bid(Subasta subasta, float monto);
    
}
