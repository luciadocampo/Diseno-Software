package e1;
import java.util.List;

public interface CriterioRaiz<T> {
    //EMPLEAMOS INTERFAZ Y LUEGO EN CADA CRITERIO APLICAMOS UNOS FILTROS
    //DE BÚSQUEDA DIFERENTES PARA CADA COSA.
    List<T> filtradoCriterios(List<T> billetes);
}
