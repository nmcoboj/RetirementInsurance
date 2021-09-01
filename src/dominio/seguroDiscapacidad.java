package dominio;

public class seguroDiscapacidad extends Seguro implements Pension {

    float pensionFinal;
    int nivelDiscapacidad;

    public float getPensionFinal() {
        return pensionFinal;
    }

    public int getNivelDiscapacidad() {
        return nivelDiscapacidad;
    }

    public seguroDiscapacidad(int discapacidad, long cedula, String nombre, float pensionBase, int aniosAporte) {
        super(cedula, nombre, pensionBase, aniosAporte);
        this.nivelDiscapacidad = discapacidad;
        pensionFinal(pensionBase);
    }

    @Override
    public float pensionBase(int aniosAporte) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pensionFinal(float pensionBase) {
        if (this.nivelDiscapacidad <= 10) {
            pensionFinal = (float) (pensionBase + pensionBase * 0.5);
        } else if (this.nivelDiscapacidad >= 11 && this.nivelDiscapacidad <= 20) {
            pensionFinal = (float) (pensionBase + pensionBase * 0.6);
        } else if (this.nivelDiscapacidad >= 21 && this.nivelDiscapacidad <= 30) {
            pensionFinal = (float) (pensionBase + pensionBase * 0.7);
        } else if (this.nivelDiscapacidad >= 31 && this.nivelDiscapacidad <= 35) {
            pensionFinal = (float) (pensionBase + pensionBase * 0.8);
        } else if (this.nivelDiscapacidad >= 36 && this.nivelDiscapacidad <= 39) {
            pensionFinal = (float) (pensionBase + pensionBase * 0.9);
        } else if (this.nivelDiscapacidad >= 40) {
            pensionFinal = pensionBase + pensionBase;
        }
    }

}
