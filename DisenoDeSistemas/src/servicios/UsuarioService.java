/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.UsuarioDAO;
import entidades.Vendedor;

/**
 *
 * @author martin
 */
public class UsuarioService {

    UsuarioDAO usuariodao = new UsuarioDAO();

    public int validar(String usuario, String contrasena) {

        return usuariodao.validate(usuario, contrasena);
    }

    public Vendedor obtenerVendedor(int dniComprador) {
        
        return usuariodao.getVendedor(dniComprador);
    }
}
