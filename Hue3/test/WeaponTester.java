import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class WeaponTester {
    private List<Weapon> createWeaponList() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Varscona", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        weapons.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1, 5, 6, 3500));
        weapons.add(new Weapon("Crom Faeyr", CombatType.MELEE, DamageType.BLUNT, 16, 1, 25, 15500));
        weapons.add(new Weapon("Broken Weapon", CombatType.NONE, DamageType.NONE, 0, 0, 0, 0));
        weapons.add(new Weapon("Carsomyr", CombatType.MELEE, DamageType.SLASHING, 17, 5, 14, 20000));
        weapons.add(new Weapon("Flail of Ages", CombatType.MELEE, DamageType.BLUNT, 13, 4, 13, 4500));
        weapons.add(new Weapon("Boomerang Dagger", CombatType.RANGED, DamageType.PIERCING, 10, 1, 3, 3500));
        weapons.add(new Weapon("Dagger of Venom", CombatType.MELEE, DamageType.PIERCING, 6, 0, 3, 10000));
        weapons.add(new Weapon("Heartseeker", CombatType.RANGED, DamageType.MISSILE, 2, 4, 18, 7800));
        weapons.add(new Weapon("Strong Arm", CombatType.RANGED, DamageType.MISSILE, 3, 5, 19, 5500));
        weapons.add(new Weapon("Kundane", CombatType.MELEE, DamageType.SLASHING, 8, 0, 5, 4000));
        weapons.add(new Weapon("The Burning Earth", CombatType.MELEE, DamageType.SLASHING, 12, 4, 5, 4750));
        weapons.add(new Weapon("Daystar", CombatType.MELEE, DamageType.SLASHING, 12, 3, 6, 10000));
        weapons.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        weapons.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        weapons.add(new Weapon("Long Sword +1", CombatType.MELEE, DamageType.SLASHING, 9, 4, 6, 1250));
        return weapons;
    }

    @Test
    public void testSortByDamageDescending() {
        List<Weapon> weapons = createWeaponList();

        WeaponTester weaponSorterAndLoader = new WeaponTester();
        WeaponComparator.sortByDamageDescending(weapons);

        assertEquals("Carsomyr", weapons.get(0).getName());
        assertEquals("Crom Faeyr", weapons.get(1).getName());
        assertEquals("Flail of Ages", weapons.get(2).getName());
        assertEquals("The Burning Earth", weapons.get(3).getName());
        assertEquals("Daystar", weapons.get(4).getName());
        assertEquals("Varscona", weapons.get(5).getName());
        assertEquals("Boomerang Dagger", weapons.get(6).getName());
        assertEquals("Long Sword +1", weapons.get(7).getName());
        assertEquals("Long Sword +1", weapons.get(8).getName());
        assertEquals("Long Sword +1", weapons.get(9).getName());
        assertEquals("Kundane", weapons.get(10).getName());
        assertEquals("Dagger of Venom", weapons.get(11).getName());
        assertEquals("Strong Arm", weapons.get(12).getName());
        assertEquals("Heartseeker", weapons.get(13).getName());
        assertEquals("Tuigan Bow", weapons.get(14).getName());
        assertEquals("Broken Weapon", weapons.get(15).getName());
    }

    @Test
    public void testSortByCombatTypeDamageTypeAndName() {
        List<Weapon> weapons = createWeaponList();

        WeaponComparator weaponSorterAndLoader = new WeaponComparator();
        weaponSorterAndLoader.sortByCombatTypeDamageTypeName(weapons);

        // Die Reihenfolge sollte nach combatType, damageType und dann name sortiert sein
        assertEquals("Crom Faeyr", weapons.get(0).getName());
        assertEquals("Flail of Ages", weapons.get(1).getName());
        assertEquals("Dagger of Venom", weapons.get(2).getName());
        assertEquals("Carsomyr", weapons.get(3).getName());
        assertEquals("Daystar", weapons.get(4).getName());
        assertEquals("Kundane", weapons.get(5).getName());
        assertEquals("Long Sword +1", weapons.get(6).getName());
        assertEquals("Long Sword +1", weapons.get(7).getName());
        assertEquals("Long Sword +1", weapons.get(8).getName());
        assertEquals("The Burning Earth", weapons.get(9).getName());
        assertEquals("Varscona", weapons.get(10).getName());
        assertEquals("Broken Weapon", weapons.get(11).getName());
        assertEquals("Heartseeker", weapons.get(12).getName());
        assertEquals("Strong Arm", weapons.get(13).getName());
        assertEquals("Tuigan Bow", weapons.get(14).getName());
        assertEquals("Boomerang Dagger", weapons.get(15).getName());
    }

    @Test
    public void testLoadWeapons() throws IOException {
        String testFilePath = "weapons.csv";
        List<Weapon> weapons = Weapon.readWeaponsFromCSV(testFilePath);

        assertEquals(16, weapons.size());
        assertEquals("Varscona", weapons.get(0).getName());
        assertEquals(CombatType.MELEE, weapons.get(0).getCombatType());
        assertEquals(DamageType.SLASHING, weapons.get(0).getDamageType());
        assertEquals(11, weapons.get(0).getDamage());
        assertEquals(3, weapons.get(0).getSpeed());
        assertEquals(5, weapons.get(0).getStrength());
        assertEquals(4250, weapons.get(0).getValue());
    }
}
