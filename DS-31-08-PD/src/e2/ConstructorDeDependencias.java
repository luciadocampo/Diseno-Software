package e2;
import java.util.Objects;

public class ConstructorDeDependencias {
    private final String elemento1;
    private final String elemento2;

    public ConstructorDeDependencias(String e1, String e2){
        this.elemento1=e1;
        this.elemento2=e2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if(!(o instanceof ConstructorDeDependencias cddp)){
            return false;
        }
        if(!Objects.equals(elemento1, cddp.getElemento1()) || !Objects.equals(elemento2, cddp.getElemento2())){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;                                //hash 31 con numeros primos para hacer el hashcode de cada billete más único.
        hash = 31 * hash + Objects.hashCode(this.elemento1);
        hash = 31 * hash + Objects.hashCode(this.elemento2);

        return hash;
    }

    public String getElemento1() {
        return elemento1;
    }
    public String getElemento2() {
        return elemento2;
    }
}
