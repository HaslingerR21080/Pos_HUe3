import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Weapon {
    private int strength;
    private int value;
    private int speed;
    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
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

    public int getStrength() {
        return strength;
    }

    public int getValue() {
        return value;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %d | %d | %d | %d", name, combatType, damageType, damage, speed, strength, value);
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
        int speed = Integer.parseInt(fields[4]);
        int strength = Integer.parseInt(fields[5]);
        int value = Integer.parseInt(fields[6]);

        return new Weapon(name, combatType, damageType, damage, speed, strength, value);
    }



}
