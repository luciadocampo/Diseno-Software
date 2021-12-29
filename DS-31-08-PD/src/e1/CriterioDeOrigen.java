package e1;
import java.util.ArrayList;
import java.util.List;

public class CriterioDeOrigen implements CriterioRaiz<BilletesAutobus>{
    private final List<BilletesAutobus> listaFiltrada = new ArrayList<>();                // LISTA PARA RECOGER LOS BILLETES FILTRADOS POR EL CRITERIO PROPUESTO.
    private final List<String> filtroDeOrigenes;                                          // LISTA DE FILTRO STRING PARA ORIGEN

    @Override
    public List<BilletesAutobus> filtradoCriterios(List<BilletesAutobus> bOrigen) {
        for(BilletesAutobus billete : bOrigen){
            if(filtroDeOrigenes.contains(billete.getOrigen())){
                listaFiltrada.add(billete);                                 //SI EL BILLETE COINCIDE CON EL FILTRO CON EL QUE SE BUSCA EJEMPLO FILTRO -> ORIGEN: A CORUÑA, PUES INSERTA EL BILLETE A LA LISTA.
            }
        }
        return listaFiltrada;                                               // LISTA QUE QUEDA DESPUÉS DE FILTRAR LOS BILLETES POR UN CRITERIO.
    }

    public CriterioDeOrigen(List<String> filtroDeOrigenes){
        this.filtroDeOrigenes = filtroDeOrigenes;
    }
}
