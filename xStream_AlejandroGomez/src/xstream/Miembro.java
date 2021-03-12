package xstream;

public class Miembro {
    private String nombre;
    private String numero;
    private String posicion;
    private String year;
    private String estado;

    public Miembro(String nombre, String numero, String posicion, String year, String estado) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
        this.year = year;
        this.estado = estado;
    }
    
    public String getNombre(){
        return nombre;
    }    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
