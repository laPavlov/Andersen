package company.arrayList;

import java.util.Comparator;

public class Com implements Comparator<People> {

    @Override
    public int compare(People o1, People o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
