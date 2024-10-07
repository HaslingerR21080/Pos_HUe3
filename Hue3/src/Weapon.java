import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Weapon {
    public enum CombatType { MELEE, RANGED,NONE }
    public enum DamageType { SLASHING, PIERCING, BLUNT,NONE }

    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;


    public Weapon(String name, CombatType combatType, DamageType damageType, int damage) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
    }


    public String getName() {
        return name;
    }
    public CombatType getCombatType() {
        return combatType;
    }
    public DamageType getDamageType() {
        return damageType;
    }
    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %d", name, combatType, damageType, damage);
    }

    public static List<Weapon> readWeaponsFromCSV(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .skip(1)
                    .map(Weapon::initialize)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static Weapon initialize(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        CombatType combatType = CombatType.valueOf(fields[1].toUpperCase());
        DamageType damageType = DamageType.valueOf(fields[2].toUpperCase());
        int damage = Integer.parseInt(fields[3]);
        return new Weapon(name, combatType, damageType, damage);
    }
}
