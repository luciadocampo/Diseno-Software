package e1;
import java.util.Objects;

public class BilletesAutobus {
    private final String o;
    private final String d;
    private final float p;
    private final String f;

    public BilletesAutobus(String origen,String destino, String fecha, float precio){
        this.o=origen;
        this.d=destino;
        this.f=fecha;
        this.p=precio;
    }

    public String getOrigen() {
        return o;
    }

    public String getDestino() {
        return d;
    }

    public float getPrecio() {
        return p;
    }

    public String getFecha() {
        return f;
    }

    @Override
    public String toString(){                             //FORMATO DE SALIDA DE LA INFORMACIÓN DE LOS BILLETES.
        StringBuilder cadena = new StringBuilder();
        cadena.append("BILLETE:").append("\n")
                .append("ORIGEN: ").append(o).append("\n")
                .append("DESTINO: ").append(d).append("\n")
                .append("FECHA: ").append(f).append("\n")
                .append("PRECIO: ").append(p).append("\n")
                .append("-------------------------------").append("\n");

        return cadena.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if(!(o instanceof BilletesAutobus billeteBus)){
            return false;
        }
        if(!Objects.equals(this.getOrigen(), billeteBus.getOrigen()) || !Objects.equals(this.getDestino(), billeteBus.getDestino())
                || !Objects.equals(this.getFecha(), billeteBus.getFecha()) ||this.getPrecio()!=billeteBus.getPrecio()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;                                //hash 31 con numeros primos para hacer el hashcode de cada billete más único.
        hash = 31 * hash + Objects.hashCode(this.o);
        hash = 31 * hash + Objects.hashCode(this.d);
        hash = 31 * hash + Objects.hashCode(this.p);
        hash = 31 * hash + Objects.hashCode(this.f);

        return hash;
    }
}
