package e2;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClasificadorDeTareas {//SE ENCARGA DE ENCONTRAR LAS TAREAS QUE SON CLAVE PRIMARIA,ES DECIR, NO ESTÁN DEPENDIENDO DE OTRAS TAREAS EN NINGUNA DEPENDENCIA.
    //MEJOR DICHO BUSCA AQUELLAS TAREAS LAS CUALES OTRA TAREAS DEPENDEN DE ELLA Y ESTA MISMA NO DEPENDE DE OTRAS.
    private final List<ConstructorDeDependencias> cddp;
    List<String> listaElementos1 = new ArrayList<>();
    List<String> listaElementos2 = new ArrayList<>();
    List<String> buscarDeps = new ArrayList<>();
    List<ConstructorDeDependencias> removeDeps = new ArrayList<>();

    ClasificadorDeTareas(){
        cddp = new ArrayList<>();
    }
    ClasificadorDeTareas(ClasificadorDeTareas clasificadorDeTareas) {
        cddp = new ArrayList<>(clasificadorDeTareas.getCDDP());
    }

    public List<ConstructorDeDependencias> getCDDP() {
        return cddp;
    }

    public List<String> buscarElementos1(String cadena){
        for (ConstructorDeDependencias cddp2 : cddp){
            if(Objects.equals(cddp2.getElemento2(), cadena)){
                buscarDeps.add(cddp2.getElemento1());
            }
        }
        return buscarDeps;
    }

    public boolean buscarElementos2(String cadena) {
        for (ConstructorDeDependencias cddp2: cddp){
            if(Objects.equals(cddp2.getElemento2(), cadena)){
                return true;
            }
        }
        return false;
    }

    public List<String> buscarPrimarias(){
        for (ConstructorDeDependencias cddp2 : cddp){
            if (!(listaElementos1.contains(cddp2.getElemento2()))) {
                listaElementos2.add(cddp2.getElemento2());
            }
            if (!(listaElementos1.contains(cddp2.getElemento1()))) {
                listaElementos1.add(cddp2.getElemento1());
            }
        }
        listaElementos1.removeAll(listaElementos2);
        return listaElementos1;
    }

    public void addDep(ConstructorDeDependencias cddp2) {
        cddp.add(cddp2);
    }

    public List<ConstructorDeDependencias> buscarDeps(String cadena){
        List<ConstructorDeDependencias> buscarDeps2 = new ArrayList<>();
        for (ConstructorDeDependencias cddp2 : cddp){
            if(Objects.equals(cddp2.getElemento1(), cadena)){
                buscarDeps2.add(cddp2);
            }
        }
        return buscarDeps2;
    }

    public void removeDep(String cadena1, String cadena2){ //UNA ÚNICA DEPENDENCIA.
        cddp.removeIf(d -> Objects.equals(d.getElemento1(), cadena2) && Objects.equals(d.getElemento2(), cadena1));
    }

    public void removeDeps(String cadena){   //VARIAS.
        for(ConstructorDeDependencias cddp2 : cddp){
            if(Objects.equals(cddp2.getElemento1(), cadena)){
                removeDeps.add(cddp2);
            }
        }
        cddp.removeAll(removeDeps);
    }
}
