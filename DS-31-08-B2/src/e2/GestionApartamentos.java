package e2;

import java.util.*;

public class GestionApartamentos implements Comparator<Apartamentos> {

    static ArrayList<Apartamentos> apartamentos = new ArrayList<>();

    public static void addApartamento(Apartamentos ap){
        if(apartamentos.isEmpty()){
            apartamentos.add(ap);
        }
        else {
            for (int x = 0; x < apartamentos.size(); x++) {
                if (ap.getReferencias() == apartamentos.get(x).getReferencias()) {
                    throw new IllegalArgumentException("Ya existe un piso con esta referencia. DUPLICADO.");
                }
            }
            apartamentos.add(ap);
        }
    }

    @Override
    public int compare(Apartamentos a1, Apartamentos a2) {
        int i;
        // COVERAGE BAJO EN ESTA FUNCIÓN YA QUE EL NÚMERO DE REFERENCIA SIEMPRE ES DISTINTO POR ESO AL COMPARAR POR REFERENCIA SIEMPRE SALE DISTINTO Y NO COMPARA CON LOS OTROS ATRIBUTOS.
        i = a1.getReferencias() - a2.getReferencias();
        if (i != 0) return i;

        i = a1.getPrecioViviendas() - a2.getPrecioViviendas();
        if (i != 0) return i;

        i = a1.getPrecioPlazas() - a2.getPrecioPlazas();
        if (i != 0) return i;

        i = a1.getTamanos() - a2.getTamanos();
        if (i != 0) return i;

        i = a1.getCP().compareTo(a2.getCP());
        if (i != 0) return i;

        return i;
    }
}
