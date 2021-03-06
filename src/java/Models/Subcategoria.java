package Models;
// Generated 11-16-2016 12:49:52 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Subcategoria generated by hbm2java
 */
public class Subcategoria  implements java.io.Serializable {


     private BigDecimal idsubcategoria;
     private Categoria categoria;
     private String nombresubcategoria;
     private Set recursos = new HashSet(0);

    public Subcategoria() {
    }

	
    public Subcategoria(BigDecimal idsubcategoria, Categoria categoria, String nombresubcategoria) {
        this.idsubcategoria = idsubcategoria;
        this.categoria = categoria;
        this.nombresubcategoria = nombresubcategoria;
    }
    public Subcategoria(BigDecimal idsubcategoria, Categoria categoria, String nombresubcategoria, Set recursos) {
       this.idsubcategoria = idsubcategoria;
       this.categoria = categoria;
       this.nombresubcategoria = nombresubcategoria;
       this.recursos = recursos;
    }
   
    public BigDecimal getIdsubcategoria() {
        return this.idsubcategoria;
    }
    
    public void setIdsubcategoria(BigDecimal idsubcategoria) {
        this.idsubcategoria = idsubcategoria;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getNombresubcategoria() {
        return this.nombresubcategoria;
    }
    
    public void setNombresubcategoria(String nombresubcategoria) {
        this.nombresubcategoria = nombresubcategoria;
    }
    public Set getRecursos() {
        return this.recursos;
    }
    
    public void setRecursos(Set recursos) {
        this.recursos = recursos;
    }




}


