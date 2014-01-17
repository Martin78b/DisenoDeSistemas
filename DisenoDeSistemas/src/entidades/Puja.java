package entidades;
// Generated 17-ene-2014 16:28:31 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Puja generated by hbm2java
 */
public class Puja  implements java.io.Serializable {


     private int idpuja;
     private Comprador comprador;
     private Anuncio anuncio;
     private float monto;
     private Date fecha;
     private Date hora;
     private int nroarticulos;
     private Float topeaut;
     private boolean estado;
     private Float incremento;

    public Puja() {
    }

	
    public Puja(int idpuja, Comprador comprador, Anuncio anuncio, float monto, Date fecha, Date hora, int nroarticulos, boolean estado) {
        this.idpuja = idpuja;
        this.comprador = comprador;
        this.anuncio = anuncio;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
        this.nroarticulos = nroarticulos;
        this.estado = estado;
    }
    public Puja(int idpuja, Comprador comprador, Anuncio anuncio, float monto, Date fecha, Date hora, int nroarticulos, Float topeaut, boolean estado, Float incremento) {
       this.idpuja = idpuja;
       this.comprador = comprador;
       this.anuncio = anuncio;
       this.monto = monto;
       this.fecha = fecha;
       this.hora = hora;
       this.nroarticulos = nroarticulos;
       this.topeaut = topeaut;
       this.estado = estado;
       this.incremento = incremento;
    }
   
    public int getIdpuja() {
        return this.idpuja;
    }
    
    public void setIdpuja(int idpuja) {
        this.idpuja = idpuja;
    }
    public Comprador getComprador() {
        return this.comprador;
    }
    
    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
    public Anuncio getAnuncio() {
        return this.anuncio;
    }
    
    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    public float getMonto() {
        return this.monto;
    }
    
    public void setMonto(float monto) {
        this.monto = monto;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHora() {
        return this.hora;
    }
    
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public int getNroarticulos() {
        return this.nroarticulos;
    }
    
    public void setNroarticulos(int nroarticulos) {
        this.nroarticulos = nroarticulos;
    }
    public Float getTopeaut() {
        return this.topeaut;
    }
    
    public void setTopeaut(Float topeaut) {
        this.topeaut = topeaut;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Float getIncremento() {
        return this.incremento;
    }
    
    public void setIncremento(Float incremento) {
        this.incremento = incremento;
    }




}


