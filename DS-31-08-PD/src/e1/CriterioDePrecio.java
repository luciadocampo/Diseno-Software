package e1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CriterioDePrecio implements CriterioRaiz<BilletesAutobus>{
    private final List<BilletesAutobus> listaFiltrada = new ArrayList<>();                // LISTA PARA RECOGER LOS BILLETES FILTRADOS POR EL CRITERIO PROPUESTO.
    private final List<String> filtroDeRangosDePrecios;                                   // LISTA DE FILTRO STRING PARA RANGO DE PRECIOS.
    private final List<Float> filtroDePrecios;                                            // LISTA DE FILTRO INTEGER PARA PRECIOS.

    @Override
    public List<BilletesAutobus> filtradoCriterios(List<BilletesAutobus> bPrecio) {
        int tamRangos = filtroDeRangosDePrecios.size();
        float tamPrecios = filtroDePrecios.size();                                        //LISTAS PARA COMPARAR MÁS ADELANTE.

        int comparadorTam = (int) Math.min(tamPrecios, tamRangos);                        // COMPARA TAMAÑO DE LAS LISTAS Y COGE LA DE MENOR TAMAÑO. SE CASTEA A INT PORQUE NOSOTROS DEFINIMOS EL PRECIO DE UN BILLETE COMO FLOAT PORQUE NO NECESARIAMENTE TIENE QUE COSTAR UN NUMERO EXACTO PUEDEN HABER CÉNTIMOS.

        for(BilletesAutobus billete : bPrecio){
            for(int x=0;x<comparadorTam;++x){
                if(comparadorAux(filtroDeRangosDePrecios.get(x),billete.getPrecio(),filtroDePrecios.get(x))){
                    listaFiltrada.add(billete);                                           //AÑADE EL BILLETE SEGÚN CRITERIO A LA LISTA FILTRADA.
                }
            }
        }
        return listaFiltrada;
    }

    public boolean comparadorAux(String signo, float x, float y){                                //FUNCIÓN AUXILIAR PARA COMPARAR LOS ELEMENTOS DE LA LISTA PARA LOS FILTRADOS.
        if(Objects.equals(signo, "<")){
            return (x<y);
        }
        else if(Objects.equals(signo, "<=")){
            return (x<=y);
        }
        else if(Objects.equals(signo, ">")){
            return (x>y);
        }
        else if(Objects.equals(signo, ">=")){
            return (x>=y);
        }
        else if(Objects.equals(signo, "==")){
            return (x==y);
        }
        return true;
    }

    public CriterioDePrecio(List<String> filtroDeRangosDePrecios,List<Float> filtroDePrecios){
        this.filtroDeRangosDePrecios = filtroDeRangosDePrecios;
        this.filtroDePrecios = filtroDePrecios;
    }
}
