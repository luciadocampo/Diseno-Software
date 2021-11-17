package e2;

import java.util.Comparator;

public class CompTamano implements Comparator<Apartamentos> {

    @Override
    public int compare(Apartamentos a1, Apartamentos a2) {
        int i;
        i = a1.getTamanos() - a2.getTamanos();
        if (i != 0)
            return i;
        return i;
    }
}
