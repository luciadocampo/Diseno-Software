package e2;

import java.util.Comparator;

public class CompPrecioFinal implements Comparator<Apartamentos> {

    @Override
    public int compare(Apartamentos a1, Apartamentos a2) {
        int i;
        i = a1.getPrecioFinal() - a2.getPrecioFinal();
        if (i != 0)
            return i;
        return i;
    }
}
