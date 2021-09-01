package dominio;

public class seguroPatronal extends Seguro implements Pension {

    float pensionFinal;
    float inflacion = (float) 0.18;
    String empresa;

    public seguroPatronal(String empresa, long cedula, String nombre, float pensionBase, int aniosAporte) {
        super(cedula, nombre, pensionBase, aniosAporte);
        this.empresa = empresa;
        pensionFinal(pensionBase);
    }

    public float getPensionFinal() {
        return pensionFinal;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public float pensionBase(int aniosAporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pensionFinal(float pensionBase) {
        if ("Publica".equals(this.empresa) || "publica".equals(this.empresa)) {
            pensionFinal = pensionBase + (pensionBase * (this.inflacion));
            pensionFinal = (float) (pensionFinal + pensionFinal * 0.05);
        } else {
            pensionFinal = pensionBase + (pensionBase* (this.inflacion));
            pensionFinal= (float) (pensionFinal + pensionFinal * 0.1);
        }
    }

}
