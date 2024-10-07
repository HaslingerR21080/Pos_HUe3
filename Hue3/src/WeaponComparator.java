import java.util.Comparator;
import java.util.List;
import java.util.Collections;
public class WeaponComparator implements Comparator<Weapon> {

    @Override
    public int compare(Weapon w1, Weapon w2) {

        return w1.getName().compareTo(w2.getName());
    }

    // damage absteigend
    public static void sortByDamageDescending(List<Weapon> weapons) {
        weapons.sort(Comparator.comparingInt(Weapon::getDamage).reversed());
    }

    public List<Weapon> sortByCombatTypeDamageTypeName(List<Weapon> weaponList) {
        weaponList.sort((Comparator.comparing((Weapon o) -> o.getCombatType().toString()).thenComparing(o -> o.getDamageType().toString()).thenComparing(Weapon::getName)));
        return weaponList;
    }
}
