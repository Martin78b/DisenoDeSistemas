/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FrameworkDePersistencia;

/**
 *
 * @author martin
 */
public interface DBAccess {
    
    public void save(Object object);
    
    public void update();
}
