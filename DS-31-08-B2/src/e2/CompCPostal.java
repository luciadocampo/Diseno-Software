package e2;

import java.util.Comparator;

public class CompCPostal implements Comparator<Apartamentos> {

    @Override
    public int compare(Apartamentos a1, Apartamentos a2) {
        int i;
        i = a1.getCP().compareTo(a2.getCP());
        if (i != 0)
            return i;
        return i;
    }
}
