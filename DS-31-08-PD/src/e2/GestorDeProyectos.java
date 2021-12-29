package e2;

public class  GestorDeProyectos {
    private final ClasificadorDeTareas clasiLista;
    private final DepRaizInterfaz raiz;

    public String Planificador(){
        //EL GESTOR DE PROYECTOS DECIDE QUE TIPO DE DEPENDENCIA SE USA SI BIEN: FUERTE, DÉBIL U ORDEN JERÁRQUICO.
        StringBuilder cadenaVacia = new StringBuilder();
        cadenaVacia.append(raiz.ordenFinal(clasiLista));
        return cadenaVacia.toString();
    }
    public GestorDeProyectos(DepRaizInterfaz raiz, ClasificadorDeTareas clasiLista){
        this.clasiLista=clasiLista;
        this.raiz=raiz;
    }
}
