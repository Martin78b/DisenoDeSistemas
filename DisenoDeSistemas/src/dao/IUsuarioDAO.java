/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


import entidades.Comprador;
import entidades.Vendedor;
/**
 *
 * @author martin
 */
public interface IUsuarioDAO 
{
    
    public void save(Comprador usuario);
    
    public void save(Vendedor usuario);
    
    public void update(Comprador usuario);
    
    public void update(Vendedor usuario);
    
    public int validate(String user, String pass);
    
}
