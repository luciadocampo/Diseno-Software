package e2;

import java.util.Comparator;

public class CompPrecioBase implements Comparator<Apartamentos> {

    @Override
    public int compare(Apartamentos a1, Apartamentos a2) {
        int i;
        i = a1.getPrecioViviendas() - a2.getPrecioViviendas();
        if (i != 0)
            return i;
        return i;
    }
}
