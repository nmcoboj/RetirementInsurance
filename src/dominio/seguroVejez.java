
package dominio;

public class seguroVejez extends Seguro implements Pension{

    
    float pensionFinal;
    
    public seguroVejez(long cedula, String nombre, float pensionBase, int aniosAporte) {
        super(cedula, nombre, pensionBase, aniosAporte);
        pensionFinal(pensionBase);
        
    }

    public float getPensionFinal() {
        return pensionFinal;
    }

    @Override
    public float pensionBase(int aniosAporte) {
        return 0;
    }

    @Override
    public void pensionFinal(float pensionBase) {
        pensionFinal = (float) (pensionBase+ (pensionBase * 0.15));
    }      
    
}
