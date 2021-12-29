package e1;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeBilletes {
    private final List<BilletesAutobus> buscadorBilletes;

    public List<BilletesAutobus> buscadorBilletesFunc(List<CriterioRaiz<BilletesAutobus>> criteriosBilletes){
        List<BilletesAutobus> listaFiltrada = new ArrayList<>(buscadorBilletes);
        for(CriterioRaiz<BilletesAutobus> criterio : criteriosBilletes){
            listaFiltrada = criterio.filtradoCriterios(listaFiltrada);
        }
        return listaFiltrada;
    }

    @Override
    public String toString() {                                 //toString de VARIOS BILLETES A LA VEZ.
        StringBuilder cadena = new StringBuilder();
        for (BilletesAutobus billete : buscadorBilletes) {
            cadena.append(billete.toString());
        }
        return cadena.toString();
    }

    public BuscadorDeBilletes(List <BilletesAutobus> buscadorBilletes) {
            this.buscadorBilletes = buscadorBilletes;
        }
}
