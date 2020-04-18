package clasesjava;
// Generated 16-abr-2020 17:36:16 by Hibernate Tools 4.3.1



/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private Empleado empleado;
     private String dniNie;
     private String nombreCliente;
     private String apellidoCliente;
     private String telefonoCliente;
     private String paisCliente;
     private String provinciaCliente;
     private String ciudadCliente;
     private String direccionCliente;
     private int codigoPostalCliente;
     private String emailCliente;

    public Cliente() {
    }

	
    public Cliente(Empleado empleado, String dniNie, String nombreCliente, String apellidoCliente, String telefonoCliente, String paisCliente, String provinciaCliente, String ciudadCliente, String direccionCliente, int codigoPostalCliente) {
        this.empleado = empleado;
        this.dniNie = dniNie;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.paisCliente = paisCliente;
        this.provinciaCliente = provinciaCliente;
        this.ciudadCliente = ciudadCliente;
        this.direccionCliente = direccionCliente;
        this.codigoPostalCliente = codigoPostalCliente;
    }
    public Cliente(Empleado empleado, String dniNie, String nombreCliente, String apellidoCliente, String telefonoCliente, String paisCliente, String provinciaCliente, String ciudadCliente, String direccionCliente, int codigoPostalCliente, String emailCliente) {
       this.empleado = empleado;
       this.dniNie = dniNie;
       this.nombreCliente = nombreCliente;
       this.apellidoCliente = apellidoCliente;
       this.telefonoCliente = telefonoCliente;
       this.paisCliente = paisCliente;
       this.provinciaCliente = provinciaCliente;
       this.ciudadCliente = ciudadCliente;
       this.direccionCliente = direccionCliente;
       this.codigoPostalCliente = codigoPostalCliente;
       this.emailCliente = emailCliente;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public String getDniNie() {
        return this.dniNie;
    }
    
    public void setDniNie(String dniNie) {
        this.dniNie = dniNie;
    }
    public String getNombreCliente() {
        return this.nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getApellidoCliente() {
        return this.apellidoCliente;
    }
    
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
    public String getTelefonoCliente() {
        return this.telefonoCliente;
    }
    
    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    public String getPaisCliente() {
        return this.paisCliente;
    }
    
    public void setPaisCliente(String paisCliente) {
        this.paisCliente = paisCliente;
    }
    public String getProvinciaCliente() {
        return this.provinciaCliente;
    }
    
    public void setProvinciaCliente(String provinciaCliente) {
        this.provinciaCliente = provinciaCliente;
    }
    public String getCiudadCliente() {
        return this.ciudadCliente;
    }
    
    public void setCiudadCliente(String ciudadCliente) {
        this.ciudadCliente = ciudadCliente;
    }
    public String getDireccionCliente() {
        return this.direccionCliente;
    }
    
    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }
    public int getCodigoPostalCliente() {
        return this.codigoPostalCliente;
    }
    
    public void setCodigoPostalCliente(int codigoPostalCliente) {
        this.codigoPostalCliente = codigoPostalCliente;
    }
    public String getEmailCliente() {
        return this.emailCliente;
    }
    
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }




}


