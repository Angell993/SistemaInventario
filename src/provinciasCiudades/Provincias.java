package provinciasCiudades;


public class Provincias  implements java.io.Serializable {


     private int idProvincia;
     private String provincia;

    public Provincias() {
    }
    
    public Provincias( int idProvincia, String provincia) {
       this.provincia = provincia;
       this.idProvincia = idProvincia;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return provincia;
    }

    

}


