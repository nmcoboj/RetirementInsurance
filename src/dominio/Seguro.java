
package dominio;

public class Seguro {
    
    long cedula;
    String nombre;
    float pensionBase;
    int aniosAporte;

    public Seguro(long cedula, String nombre, float pensionBase, int aniosAporte) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.pensionBase = pensionBase;
        this.aniosAporte = aniosAporte;
    }

    public Long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPensionBase() {
        return pensionBase;
    }

    public int getAniosAporte() {
        return aniosAporte;
    }
    
    
}
