import java.util.Comparator;
import java.util.List;
import java.util.Collections;
public class WeaponComparator implements Comparator<Weapon> {

    @Override
    public int compare(Weapon w1, Weapon w2) {

        return w1.getName().compareTo(w2.getName());
    }

    // damage absteigend
    public static Comparator<Weapon> sortByDamageDesc() {
        return (w1, w2) -> Integer.compare(w2.getDamage(), w1.getDamage());
    }


    public static Comparator<Weapon> sortByCombatTypeDamageTypeName() {
        return Comparator
                .comparing(Weapon::getCombatType)
                .thenComparing(Weapon::getDamageType)
                .thenComparing(Weapon::getName);
    }
}
