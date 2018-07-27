package me.badbones69.blockparticles.util;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.inventivetalent.particle.ParticleEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class ParticleUtils {

    private final static Random RANDOM = new Random();

    private ParticleUtils() {
    }

    public static Location drop(final Location location) {
        double x = RANDOM.nextInt(100) / 100.0 - .50;
        double z = RANDOM.nextInt(100) / 100.0 - .50;
        return location.clone().add(x, 0, z);
    }

    public static float vector() {
        return (float) -.05 + (float) (Math.random() * ((.05 - -.05)));
    }

    public static List<Location> getCircle(Location center, double radius, int amount) {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            double angle = i * increment;
            double x = center.getX() + (radius * Math.cos(angle));
            double z = center.getZ() + (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }

    public static List<Location> getCircleReverse(Location center, double radius, int amount) {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            double angle = i * increment;
            double x = center.getX() - (radius * Math.cos(angle));
            double z = center.getZ() - (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }

    public static Location ranSpawn(final Location location, double rangeX, double rangeY, double rangeZ) {
        double x = (RANDOM.nextInt(100) / 100.0 - .50) * rangeX;
        double y = (RANDOM.nextInt(100) / 100.0 - .50) * rangeY;
        double z = (RANDOM.nextInt(100) / 100.0 - .50) * rangeZ;
        return location.clone().add(x, y, z);
    }

    public void ranLoc(final ParticleEffect effect, final Location location, double offsetX, double offsetY, double offsetZ, int amount, final Color color) {
        for (int i = 0; i < amount; i++) {
            effect.sendColor(Bukkit.getOnlinePlayers(), ranSpawn(location, offsetX, offsetY, offsetZ), color);
        }
    }

    public static int randomColor() {
        return RANDOM.nextInt(255);
    }
}
