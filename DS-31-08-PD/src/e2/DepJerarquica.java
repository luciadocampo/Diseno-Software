package e2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepJerarquica implements DepRaizInterfaz {
    String comienzo = "";
    String cadena = "";
    List<String> secuenciaFinal = new ArrayList<>();
    List<String> listaDePrimarias2 = new ArrayList<>();
    int x = 0;
    boolean booleano = false;

    @Override
    public String ordenFinal(ClasificadorDeTareas clasi) {
        ClasificadorDeTareas cdt = new ClasificadorDeTareas(clasi);
        List<String> listaDePrimarias = cdt.buscarPrimarias();
        do{
            if(listaDePrimarias.size() == 0){
                listaDePrimarias = new ArrayList<>(listaDePrimarias2);
                listaDePrimarias2 = new ArrayList<>();
            }
            Collections.sort(listaDePrimarias);
            comienzo = listaDePrimarias.get(x);
            if(!booleano || (cdt.buscarElementos2(comienzo))){
                listaDePrimarias.remove(x);
                secuenciaFinal.add(comienzo);
                for (ConstructorDeDependencias cddp : cdt.buscarDeps(comienzo)){
                    if(!(secuenciaFinal.contains(cddp.getElemento2())) && !(listaDePrimarias.contains(cddp.getElemento2())) && !(listaDePrimarias2.contains(cddp.getElemento2()))){
                        listaDePrimarias2.add(cddp.getElemento2());
                    }
                }

            }
        }while ((listaDePrimarias.size() + listaDePrimarias2.size()) != 0);
        return cadenaEsperada(secuenciaFinal);
    }

    @Override
    public String cadenaEsperada(List<String> cadena2){
        if(cadena2.size() > 0){
            String cadena3 = cadena2.get(0);
            cadena = cadena + cadena3;
            for(String s : cadena2.subList(1,cadena2.size())){
                cadena = cadena + "-" + s;
            }
            return cadena; // aquí se devuelve la cadena esperada.
        } else {
            return cadena; // como no pasa por el if cadena sigue siendo "";
        }
    }
}