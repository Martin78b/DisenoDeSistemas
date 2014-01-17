/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package FrameworkDePersistencia;

import java.util.List;

/**
 *
 * @author martin
 */
public interface DBAccess {
    
    public void save(Object object);
    
    public void update(Object object);
    
    public void delete(Object object);
    
    public List<Object> get(String consulta);
}
