package Models;
// Generated 11-16-2016 12:49:52 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private BigDecimal idpersona;
     private Municipio municipio;
     private String nombre;
     private String apellidos;
     private String dui;
     private BigDecimal telefono;
     private Date nacimiento;
     private String lugarestudio;
     private String lugartrabajo;
     private String direccion;
     private String padre;
     private String madre;
     private Set usuarios = new HashSet(0);

    public Persona() {
    }

	
    public Persona(BigDecimal idpersona, Municipio municipio, String nombre, String apellidos, String dui) {
        this.idpersona = idpersona;
        this.municipio = municipio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dui = dui;
    }
    public Persona(BigDecimal idpersona, Municipio municipio, String nombre, String apellidos, String dui, BigDecimal telefono, Date nacimiento, String lugarestudio, String lugartrabajo, String direccion, String padre, String madre, Set usuarios) {
       this.idpersona = idpersona;
       this.municipio = municipio;
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.dui = dui;
       this.telefono = telefono;
       this.nacimiento = nacimiento;
       this.lugarestudio = lugarestudio;
       this.lugartrabajo = lugartrabajo;
       this.direccion = direccion;
       this.padre = padre;
       this.madre = madre;
       this.usuarios = usuarios;
    }
   
    public BigDecimal getIdpersona() {
        return this.idpersona;
    }
    
    public void setIdpersona(BigDecimal idpersona) {
        this.idpersona = idpersona;
    }
    public Municipio getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDui() {
        return this.dui;
    }
    
    public void setDui(String dui) {
        this.dui = dui;
    }
    public BigDecimal getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(BigDecimal telefono) {
        this.telefono = telefono;
    }
    public Date getNacimiento() {
        return this.nacimiento;
    }
    
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }
    public String getLugarestudio() {
        return this.lugarestudio;
    }
    
    public void setLugarestudio(String lugarestudio) {
        this.lugarestudio = lugarestudio;
    }
    public String getLugartrabajo() {
        return this.lugartrabajo;
    }
    
    public void setLugartrabajo(String lugartrabajo) {
        this.lugartrabajo = lugartrabajo;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getPadre() {
        return this.padre;
    }
    
    public void setPadre(String padre) {
        this.padre = padre;
    }
    public String getMadre() {
        return this.madre;
    }
    
    public void setMadre(String madre) {
        this.madre = madre;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


