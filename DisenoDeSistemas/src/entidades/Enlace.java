package entidades;
// Generated 17-ene-2014 16:28:31 by Hibernate Tools 3.6.0



/**
 * Enlace generated by hbm2java
 */
public class Enlace  implements java.io.Serializable {


     private int nroenlace;
     private Anuncio anuncio;
     private String link;

    public Enlace() {
    }

	
    public Enlace(int nroenlace, Anuncio anuncio) {
        this.nroenlace = nroenlace;
        this.anuncio = anuncio;
    }
    public Enlace(int nroenlace, Anuncio anuncio, String link) {
       this.nroenlace = nroenlace;
       this.anuncio = anuncio;
       this.link = link;
    }
   
    public int getNroenlace() {
        return this.nroenlace;
    }
    
    public void setNroenlace(int nroenlace) {
        this.nroenlace = nroenlace;
    }
    public Anuncio getAnuncio() {
        return this.anuncio;
    }
    
    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }




}


