package me.badbones69.blockparticles;

import org.bukkit.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

public class ParticleManager {
    private final Plugin plugin;
    private final HashMap<String, BukkitTask> particles;
    private final HashMap<String, Integer> r;
    private int activationRange;

    private final Random random;

    public ParticleManager(final Plugin plugin) {
        this.plugin = plugin;
        particles = new LinkedHashMap<>();
        r = new LinkedHashMap<>();
        activationRange = 25; // TODO: config?
        random = new Random();
    }

    public static void playEnderSignal(final Location loc, String L) {
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 0, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                loc.getWorld().spawnParticle();
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
            }
        }, 0, 8));
    }

    public static void playRainbow(final Location loc, String L) {
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                ParticleEffects.REDSTONE.display((float) .5, (float) .5, (float) .5, 1, 10, l, 100);
            }
        }, 0, 5));
    }

    public static void playSnowBlast(final Location loc, String L) {
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                ParticleEffects.SNOW_SHOVEL.display(0, 0, 0, (float) .2, 40, l, 100);
            }
        }, 0, 2));
    }

    public static void playHalo(final Location loc, String L) {
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1.3, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                try {
                    for (int i = 0; i < 3; i++) {
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(.5, 0, 0), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(.45, 0, .13), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(.35, 0, .35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(.13, 0, .45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(0, 0, .5), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(-.13, 0, .45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(-.35, 0, .35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(-.45, 0, .13), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(-.5, 0, 0), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(-.45, 0, -.13), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(-.35, 0, -.35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(-.13, 0, -.45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(0, 0, -.5), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(.13, 0, -.45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(.35, 0, -.35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), location.clone().add(.45, 0, -.13), Color.fromRGB(255, 255, 0));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5));
    }

    public static void playSantaHat(final Location loc, String L) {
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l1 = loc.clone().add(.5, 1, .5);
            Location l2 = l1.clone().add(0, .05, 0);
            Location l3 = l2.clone().add(0, .05, 0);
            Location l4 = l3.clone().add(0, .05, 0);
            Location l5 = l4.clone().add(0, .05, 0);
            Location l6 = l5.clone().add(0, .05, 0);
            Location l7 = l6.clone().add(0, .05, 0);
            Location l8 = l7.clone().add(0, .05, 0);
            Location l9 = l8.clone().add(0, .05, 0);
            Location l10 = l9.clone().add(0, .1, 0);
            Location l11 = l10.clone().add(0, .05, 0);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l1.clone(), 20)) return;
                try {
                    for (int i = 0; i < 3; i++) {
                        Color red = Color.RED;
                        Color white = Color.fromRGB(255, 255, 255);
                        for (Location loc : getCircle(l1, .5, 20))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, white);
                        for (Location loc : getCircle(l2, .4, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l3, .35, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l4, .3, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l5, .2, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l6, .15, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l7, .1, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l8, .05, 10))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l9, .05, 10))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, red);
                        for (Location loc : getCircle(l10, .05, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, white);
                        for (Location loc : getCircle(l11, .05, 15))
                            ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), loc, white);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5));
    }

    public static void playSoulWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startSoulWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 2, 50);
                        ArrayList<Location> locs2 = getCircleReverse(l, 2, 50);
                        ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 1, locs.get(i), 100);
                        ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 1, locs2.get(i), 100);
                        i++;
                        f++;
                        l.add(0, .035, 0);
                        if (i == 50) i = 0;
                        if (f == 75) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                startSoulWell(l, L);
            }
        }, 0, 16));
    }

    public static void playBigSoulWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startBigSoulWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 3.5, 75);
                        ArrayList<Location> locs2 = getCircleReverse(l, 3.5, 75);
                        ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 1, locs.get(i), 100);
                        ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 1, locs2.get(i), 100);
                        i++;
                        f++;
                        l.add(0, .04, 0);
                        if (i == 75) i = 0;
                        if (f == 105) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                startBigSoulWell(l, L);
            }
        }, 0, 25));
    }

    public static void playFlameWheel(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, .1, .5);
            Random r = new Random();

            void startFlameWheel(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int o = 74;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 3.5, 75);
                        ArrayList<Location> locs2 = getCircleReverse(l, 3.5, 75);
                        float speed = (float) .1;
                        Vector v = locs.get(i).toVector().subtract(l.toVector()).normalize();
                        Vector v2 = locs2.get(i).toVector().subtract(l.toVector()).normalize();
                        Vector v3 = locs.get(o).toVector().subtract(l.toVector()).normalize();
                        Vector v4 = locs2.get(o).toVector().subtract(l.toVector()).normalize();
                        ParticleEffects.FLAME.display(v.multiply(-2), speed, locs.get(i), 100);
                        ParticleEffects.FLAME.display(v2.multiply(-2), speed, locs2.get(i), 100);
                        ParticleEffects.FLAME.display(v3.multiply(-2), speed, locs.get(o), 100);
                        ParticleEffects.FLAME.display(v4.multiply(-2), speed, locs2.get(o), 100);
                        i++;
                        f++;
                        o--;
                        if (i == 75) i = 0;
                        if (o == 0) o = 74;
                        if (f == 105) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                startFlameWheel(l.clone(), L);
            }
        }, 0, 25));
        r.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                ArrayList<Location> locs = getCircle(l, 3.5, 75);
                for (Location i : locs)
                    ParticleEffects.FLAME.display(0, 0, 0, 0, 1, i, 100);
            }
        }, 0, 10));

    }

    public static void playWitchTornado(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startWitchTornado(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone().add(0, 5, 0);
                    int i = 0;
                    int e = 0;
                    double r = 1.5;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, r, 50);
                        ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 1, locs.get(i), 100);
                        i++;
                        e++;
                        f++;
                        if (i == 50) i = 0;
                        l.add(0, -.02, 0); //Controls how far each particle goes Down.
                        if (e == 7) { //Controls when diameter Changes.
                            e = 0;
                            r = r - .05; //Controls how far it goes in.
                        }
                        if (f == 207) { //Controls how far the particle effect go down.
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                startWitchTornado(l, L);
            }
        }, 0, 30));
    }

    public static void playLoveTornado(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startLoveTornado(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone().add(0, 5, 0);
                    int i = 0;
                    int e = 0;
                    double r = 1.5;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, r, 50);
                        ParticleEffects.HEART.display(0, 0, 0, 0, 1, locs.get(i), 100);
                        i++;
                        e++;
                        f++;
                        if (i == 50) i = 0;
                        l.add(0, -.02, 0); //Controls how far each particle goes Down.
                        if (e == 7) { //Controls when diameter Changes.
                            e = 0;
                            r = r - .05; //Controls how far it goes in.
                        }
                        if (f == 207) { //Controls how far the particle effect go down.
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                startLoveTornado(l, L);
            }
        }, 0, 30));
    }

    public static void playBigLoveWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startBigLoveWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 3.5, 75);
                        ArrayList<Location> locs2 = getCircleReverse(l, 3.5, 75);
                        ParticleEffects.HEART.display(0, 0, 0, 0, 1, locs.get(i), 100);
                        ParticleEffects.HEART.display(0, 0, 0, 0, 1, locs2.get(i), 100);
                        i++;
                        f++;
                        l.add(0, .04, 0);
                        if (i == 75) i = 0;
                        if (f == 105) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                startBigLoveWell(l, L);
            }
        }, 0, 25));
    }

    public static void playLoveWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        particles.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startLoveWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 2, 50);
                        ArrayList<Location> locs2 = getCircleReverse(l, 2, 50);
                        ParticleEffects.HEART.display(0, 0, 0, 0, 1, locs.get(i), 100);
                        ParticleEffects.HEART.display(0, 0, 0, 0, 1, locs2.get(i), 100);
                        i++;
                        f++;
                        l.add(0, .035, 0);
                        if (i == 50) i = 0;
                        if (f == 75) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), activationRange)) return;
                startLoveWell(l, L);
            }
        }, 0, 16));
    }
}