package e2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepDebil implements DepRaizInterfaz {
    String comienzo = "";
    String cadena = "";
    List<String> secuenciaFinal = new ArrayList<>();
    int x = 0;
    boolean booleano=false;

    @Override
    public String ordenFinal(ClasificadorDeTareas clasi) {
        ClasificadorDeTareas cdt = new ClasificadorDeTareas(clasi);
        List<String> listaDePrimarias = cdt.buscarPrimarias();
        do{
            Collections.sort(listaDePrimarias);
            comienzo = listaDePrimarias.get(x);
            if(!booleano || (cdt.buscarElementos2(comienzo))){
                listaDePrimarias.remove(x);
                secuenciaFinal.add(comienzo);
                for (ConstructorDeDependencias cddp : cdt.buscarDeps(comienzo)){
                    if(!(secuenciaFinal.contains(cddp.getElemento2())) && !(listaDePrimarias.contains(cddp.getElemento2()))){
                        listaDePrimarias.add(cddp.getElemento2());
                    }
                }
            }
        }while (listaDePrimarias.size() != 0);
        return cadenaEsperada(secuenciaFinal);
    }

    @Override
    public String cadenaEsperada(List<String> cadena2){
        if(cadena2.size() > 0){
            String cadena3 = cadena2.get(0);
            cadena = cadena + cadena3;
            for(String cadenaSF : cadena2.subList(1,cadena2.size())){
                cadena = cadena + "-" + cadenaSF;
            }
            return cadena; // aquí se devuelve la cadena esperada.
        } else {
            return cadena; // como no pasa por el if cadena sigue siendo "";
        }
    }
}
