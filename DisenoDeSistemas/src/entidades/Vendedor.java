package entidades;
// Generated 17-ene-2014 16:28:31 by Hibernate Tools 3.6.0


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Vendedor generated by hbm2java
 */
public class Vendedor  implements java.io.Serializable {


     private int dni;
     private Comprador comprador;
     private Serializable cuil;
     private Boolean estado;
     private Set anuncios = new HashSet(0);

    public Vendedor() {
    }

	
    public Vendedor(Comprador comprador, Serializable cuil) {
        this.comprador = comprador;
        this.cuil = cuil;
    }
    public Vendedor(Comprador comprador, Serializable cuil, Boolean estado, Set anuncios) {
       this.comprador = comprador;
       this.cuil = cuil;
       this.estado = estado;
       this.anuncios = anuncios;
    }
   
    public int getDni() {
        return this.dni;
    }
    
    public void setDni(int dni) {
        this.dni = dni;
    }
    public Comprador getComprador() {
        return this.comprador;
    }
    
    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
    public Serializable getCuil() {
        return this.cuil;
    }
    
    public void setCuil(Serializable cuil) {
        this.cuil = cuil;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getAnuncios() {
        return this.anuncios;
    }
    
    public void setAnuncios(Set anuncios) {
        this.anuncios = anuncios;
    }




}


