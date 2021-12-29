package e1;
import java.util.ArrayList;
import java.util.List;

public class CriterioDeFecha implements CriterioRaiz<BilletesAutobus>{
    private final List<BilletesAutobus> listaFiltrada = new ArrayList<>();                // LISTA PARA RECOGER LOS BILLETES FILTRADOS POR EL CRITERIO PROPUESTO.
    private final List<String> filtroDeFechas;                                            // LISTA DE FILTRO STRING PARA DESTINO.

    @Override
    public List<BilletesAutobus> filtradoCriterios(List<BilletesAutobus> bFecha) {
        for(BilletesAutobus billete : bFecha){
            if(filtroDeFechas.contains(billete.getFecha())){
                listaFiltrada.add(billete);                                                // SI EL BILLETE COINCIDE CON EL FILTRO CON EL QUE SE BUSCA EJEMPLO FILTRO -> DESTINO: BARCELONA, PUES INSERTA EL BILLETE A LA LISTA.
            }
        }
        return listaFiltrada;                                                              // LISTA QUE QUEDA DESPUÉS DE FILTRAR LOS BILLETES POR UN CRITERIO.
    }

    public CriterioDeFecha(List<String> filtroDeFechas){
        this.filtroDeFechas = filtroDeFechas;
    }
}
