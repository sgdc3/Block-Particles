package me.badbones69.blockparticles;

import org.bukkit.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PlayParticles {
    public static HashMap<String, Integer> Blocks = new HashMap<String, Integer>();
    public static Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("BlockParticles");
    public static HashMap<String, Integer> R = new HashMap<String, Integer>();
    private static int range = 25;

    @SuppressWarnings("static-access")
    public PlayParticles(Plugin plugin) {
        this.plugin = plugin;
    }

    private static Location Drop(Location loc) {
        Random r = new Random();
        Random rr = new Random();
        double x = r.nextInt(100) / 100.0 - .50;
        double z = rr.nextInt(100) / 100.0 - .50;
        return loc.add(x, 0, z);
    }

    private static float Vec() {
        float Vec = (float) -.05 + (float) (Math.random() * ((.05 - -.05)));
        return Vec;
    }

    private static Location RanSpawn(Location loc, double X, double Y, double Z) {
        Random r = new Random();
        Random rr = new Random();
        Random rrr = new Random();
        double x = (r.nextInt(100) / 100.0 - .50) * X;
        double y = (rr.nextInt(100) / 100.0 - .50) * Y;
        double z = (rrr.nextInt(100) / 100.0 - .50) * Z;
        return loc.add(x, y, z);
    }

    public static void playVolcano(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .8, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.LAVA.display(0, 0, 0, 0, 10, l, 100);
            }
        }, 0, 4));
    }

    public static void playBigFlame(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                for (Location loc : getCircle(l, 1, 15))
                    ParticleEffects.FLAME.display(0, 0, 0, 0, 1, loc, 100);
                for (Location loc : getCircle(l, 2, 25))
                    ParticleEffects.FLAME.display(0, 0, 0, 0, 1, loc, 100);
            }
        }, 0, 5));
    }

    public static void playFlame(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                for (Location loc : getCircle(l, .6, 15))
                    ParticleEffects.FLAME.display(0, 0, 0, 0, 1, loc, 100);
                for (Location loc : getCircle(l, 1, 20))
                    ParticleEffects.FLAME.display(0, 0, 0, 0, 1, loc, 100);
            }
        }, 0, 5));
    }

    public static void playDoubleSpiral(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .7, .5);
            int time = 16;

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                if (time == 15) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.8, 0, 0), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.8, 0, 0), 100);
                }
                if (time == 14) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.75, 0, .43), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.75, 0, -.43), 100);
                }
                if (time == 13) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.65, 0, .65), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.65, 0, -.65), 100);
                }
                if (time == 12) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.43, 0, .75), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.43, 0, -.75), 100);
                }
                if (time == 11) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(0, 0, .8), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(0, 0, -.8), 100);
                }
                if (time == 10) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.43, 0, .75), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.43, 0, -.75), 100);
                }
                if (time == 9) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.65, 0, .65), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.65, 0, -.65), 100);
                }
                if (time == 8) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.75, 0, .43), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.75, 0, -.43), 100);
                }
                if (time == 7) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.8, 0, 0), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.8, 0, 0), 100);
                }
                if (time == 6) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.75, 0, -.43), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.75, 0, .43), 100);
                }
                if (time == 5) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.65, 0, -.65), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.65, 0, .65), 100);
                }
                if (time == 4) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.43, 0, -.75), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.43, 0, .75), 100);
                }
                if (time == 3) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(0, 0, -.8), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(0, 0, .8), 100);
                }
                if (time == 2) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.43, 0, -.75), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.43, 0, .75), 100);
                }
                if (time == 1) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.65, 0, -.65), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.65, 0, .65), 100);
                }
                if (time == 0) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.75, 0, -.43), 100);
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.75, 0, .43), 100);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playSpiral(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .7, .5);
            int time = 16;

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                if (time == 15) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.8, 0, 0), 100);
                if (time == 14) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.75, 0, .43), 100);
                if (time == 13) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.65, 0, .65), 100);
                if (time == 12) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.43, 0, .75), 100);
                if (time == 11) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(0, 0, .8), 100);
                if (time == 10)
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.43, 0, .75), 100);
                if (time == 9) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.65, 0, .65), 100);
                if (time == 8) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.75, 0, .43), 100);
                if (time == 7) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.8, 0, 0), 100);
                if (time == 6)
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.75, 0, -.43), 100);
                if (time == 5)
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.65, 0, -.65), 100);
                if (time == 4)
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(-.43, 0, -.75), 100);
                if (time == 3) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(0, 0, -.8), 100);
                if (time == 2) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.43, 0, -.75), 100);
                if (time == 1) ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.65, 0, -.65), 100);
                if (time == 0) {
                    ParticleEffects.FIREWORKS_SPARK.display(0, 0, 0, 0, 1, l.clone().add(.75, 0, -.43), 100);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playCrit(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1.1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.CRIT.display(0, 0, 0, 0, 1, l.clone(), 100);
            }
        }, 0, 2));
    }

    public static void playBigCrit(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                for (Location loc : getCircle(l, 2, 20))
                    ParticleEffects.CRIT.display(0, 0, 0, 0, 1, loc, 100);
            }
        }, 0, 2));
    }

    public static void playStorm(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.CLOUD.display((float) .3, 0, (float) .3, 0, 15, l, 100);
                ParticleEffects.WATER_DROP.display((float) .2, 0, (float) .2, 0, 10, l.clone().add(0, 0, .1), 100);
            }
        }, 0, 2));
    }

    public static void playFog(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.CLOUD.display((float) .3, 0, (float) .3, (float) .05, 20, l, 100);
            }
        }, 0, 2));
    }

    public static void playEnchant(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1.5, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.ENCHANTMENT_TABLE.display((float) 0, 0, (float) 0, (float) 2, 20, l, 100);
            }
        }, 0, 2));
    }

    public static void playChains(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(1, 0, 1), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.9, .1, .9), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.8, .2, .8), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.7, .3, .7), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.6, .4, .6), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.5, .6, .5), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.4, .8, .4), 100);

                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-1, 0, 1), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.9, .1, .9), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.8, .2, .8), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.7, .3, .7), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.6, .4, .6), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.5, .6, .5), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.4, .8, .4), 100);

                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-1, 0, -1), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.9, .1, -.9), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.8, .2, -.8), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.7, .3, -.7), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.6, .4, -.6), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.5, .6, -.5), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(-.4, .8, -.4), 100);

                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(1, 0, -1), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.9, .1, -.9), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.8, .2, -.8), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.7, .3, -.7), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.6, .4, -.6), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.5, .6, -.5), 100);
                ParticleEffects.FLAME.display(0, 0, 0, 0, 1, l.clone().add(.4, .8, -.4), 100);
            }
        }, 0, 5));
    }

    public static void playFireStorm(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.SMOKE_LARGE.display((float) .3, 0, (float) .3, 0, 15, l, 100);
                ParticleEffects.FLAME.display(new Vector(0, -.2, 0), 1, Drop(l.clone()), 100);
                ParticleEffects.FLAME.display(new Vector(0, -.2, 0), 1, Drop(l.clone()), 100);
            }
        }, 0, 2));
    }

    public static void playSnow(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.FIREWORKS_SPARK.display((float) .7, (float) .7, (float) .7, 0, 1, l, 100);
            }
        }, 0, 2));
    }

    public static void playSpew(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.FIREWORKS_SPARK.display(new Vector(Vec(), .1, Vec()), 1, l, 100);
            }
        }, 0, 2));
    }

    public static void playPotion(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .2, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.SPELL_MOB.display((float) .3, (float) 0, (float) .3, Methods.randomColor(), 6, l, 100);
                ParticleEffects.SPELL_MOB.display((float) .3, (float) 0, (float) .3, Methods.randomColor(), 6, l, 100);
                ParticleEffects.SPELL_MOB.display((float) .3, (float) 0, (float) .3, Methods.randomColor(), 6, l, 100);
            }
        }, 0, 2));
    }

    public static void playMusic(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .2, .5);
            ArrayList<Location> locs = getCircle(l, 1, 16);
            int time = 0;

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                int i = time;
                if (time == 15) {
                    ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                    time = -1;
                }
                if (time == 14) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 13) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 12) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 11) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 10) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 9) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 8) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 7) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 6) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 5) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 4) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 3) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 2) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 1) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                if (time == 0) ParticleEffects.NOTE.display(0, 0, 0, Methods.randomColor(), 1, locs.get(i), 100);
                time++;
                i++;
            }
        }, 0, 2));
    }

    public static void playMagic(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);
            int time = 16;

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                if (time == 15) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, .8, 0), 100);
                if (time == 0) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, .75, .43), 100);
                if (time == 1) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, .65, .65), 100);
                if (time == 2) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, .43, .75), 100);
                if (time == 3) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, 0, .8), 100);
                if (time == 4) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, -.43, .75), 100);
                if (time == 5) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, -.65, .65), 100);
                if (time == 86) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, -.75, .43), 100);
                if (time == 7) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, -.8, 0), 100);
                if (time == 8) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, -.75, -.43), 100);
                if (time == 9) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, -.65, -.65), 100);
                if (time == 10) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, -.43, -.75), 100);
                if (time == 11) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, 0, -.8), 100);
                if (time == 12) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, .43, -.75), 100);
                if (time == 13) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, .65, -.65), 100);
                if (time == 14) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, .75, -.43), 100);

                if (time == 15) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(.8, 0, 0), 100);
                if (time == 14) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, .43), 100);
                if (time == 13) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, .65), 100);
                if (time == 12) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, .75), 100);
                if (time == 11) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, 0, .8), 100);
                if (time == 10) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, .75), 100);
                if (time == 9) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, .65), 100);
                if (time == 8) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, .43), 100);
                if (time == 7) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(-.8, 0, 0), 100);
                if (time == 6) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, -.43), 100);
                if (time == 5) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, -.65), 100);
                if (time == 4) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, -.75), 100);
                if (time == 3) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(0, 0, -.8), 100);
                if (time == 2) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, -.75), 100);
                if (time == 1) ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, -.65), 100);
                if (time == 0) {
                    ParticleEffects.CRIT_MAGIC.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, -.43), 100);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playWitch(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .2, .5);
            int time = 16;

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                if (time == 15) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.8, 0, 0), 100);
                if (time == 14) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, .43), 100);
                if (time == 13) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, .65), 100);
                if (time == 12) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, .75), 100);
                if (time == 11) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(0, 0, .8), 100);
                if (time == 10) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, .75), 100);
                if (time == 9) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, .65), 100);
                if (time == 8) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, .43), 100);
                if (time == 7) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.8, 0, 0), 100);
                if (time == 6) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, -.43), 100);
                if (time == 5) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, -.65), 100);
                if (time == 4) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, -.75), 100);
                if (time == 3) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(0, 0, -.8), 100);
                if (time == 2) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, -.75), 100);
                if (time == 1) ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, -.65), 100);
                if (time == 0) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, -.43), 100);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playDoubleWitch(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .2, .5);
            int time = 16;

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                if (time == 15) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.8, 0, 0), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.8, 0, 0), 100);
                }
                if (time == 14) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, .43), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, -.43), 100);
                }
                if (time == 13) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, .65), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, -.65), 100);
                }
                if (time == 12) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, .75), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, -.75), 100);
                }
                if (time == 11) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(0, 0, .8), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(0, 0, -.8), 100);
                }
                if (time == 10) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, .75), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, -.75), 100);
                }
                if (time == 9) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, .65), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, -.65), 100);
                }
                if (time == 8) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, .43), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, -.43), 100);
                }
                if (time == 7) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.8, 0, 0), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.8, 0, 0), 100);
                }
                if (time == 6) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, -.43), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, .43), 100);
                }
                if (time == 5) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, -.65), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, .65), 100);
                }
                if (time == 4) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, -.75), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, .75), 100);
                }
                if (time == 3) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(0, 0, -.8), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(0, 0, .8), 100);
                }
                if (time == 2) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.43, 0, -.75), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.43, 0, .75), 100);
                }
                if (time == 1) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.65, 0, -.65), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.65, 0, .65), 100);
                }
                if (time == 0) {
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(.75, 0, -.43), 100);
                    ParticleEffects.SPELL_WITCH.display(0, 0, 0, 0, 5, l.clone().add(-.75, 0, .43), 100);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playSnowStorm(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.CLOUD.display((float) .3, 0, (float) .3, 0, 15, l, 100);
                ParticleEffects.FIREWORKS_SPARK.display((float) .3, (float) 0, (float) .3, 0, 2, l, 100);
            }
        }, 0, 2));
    }

    public static void playFireSpew(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.FLAME.display(new Vector(Vec(), .1, Vec()), (float) 1.5, l, 100);
                ParticleEffects.FLAME.display(new Vector(Vec(), .1, Vec()), (float) 1.5, l, 100);
                ParticleEffects.FLAME.display(new Vector(Vec(), .1, Vec()), (float) 1.5, l, 100);
            }
        }, 0, 2));
    }

    public static void playFootPrint(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.FOOTSTEP.display(1, 0, 1, 0, 3, l, 100);
            }
        }, 0, 20));
    }

    public static void playHappyVillager(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.VILLAGER_HAPPY.display((float) .5, (float) .5, (float) .5, 0, 10, l, 100);
            }
        }, 0, 5));
    }

    public static void playAngryVillager(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.VILLAGER_ANGRY.display((float) .5, (float) .5, (float) .5, 0, 5, l, 100);
            }
        }, 0, 10));
    }

    public static void playMobSpawner(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.FLAME.display((float) .5, (float) .5, (float) .5, 0, 15, l, 100);
            }
        }, 0, 8));
    }

    public static void startWater(final Location loc, String L) {
        PlayParticles.Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .8, .6);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.WATER_DROP.display(0, 0, 0, 0, 10, l.clone().add(0, .1, 0), 100);
                ParticleEffects.WATER_DROP.display(0, 0, 0, 0, 10, l.clone().add(0, .5, 0), 100);
                ParticleEffects.WATER_DROP.display(0, 0, 0, 0, 10, l.clone().add(.2, .3, .2), 100);
                ParticleEffects.WATER_DROP.display(0, 0, 0, 0, 10, l.clone().add(-.2, .3, .2), 100);
                ParticleEffects.WATER_DROP.display(0, 0, 0, 0, 10, l.clone().add(.2, .3, -.2), 100);
                ParticleEffects.WATER_DROP.display(0, 0, 0, 0, 10, l.clone().add(-.2, .3, -.2), 100);
            }
        }, 0, 2));
    }

    public static void playEnderSignal(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 0, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
            }
        }, 0, 8));
    }

    public static void playRainbow(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.REDSTONE.display((float) .5, (float) .5, (float) .5, 1, 10, l, 100);
            }
        }, 0, 5));
    }

    public static void playSnowBlast(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ParticleEffects.SNOW_SHOVEL.display(0, 0, 0, (float) .2, 40, l, 100);
            }
        }, 0, 2));
    }

    public static void playHalo(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1.3, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                try {
                    for (int i = 0; i < 3; i++) {
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(.5, 0, 0), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(.45, 0, .13), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(.35, 0, .35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(.13, 0, .45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(0, 0, .5), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(-.13, 0, .45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(-.35, 0, .35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(-.45, 0, .13), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(-.5, 0, 0), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(-.45, 0, -.13), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(-.35, 0, -.35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(-.13, 0, -.45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(0, 0, -.5), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(.13, 0, -.45), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(.35, 0, -.35), Color.fromRGB(255, 255, 0));
                        ParticleEffect.REDSTONE.sendColor(Bukkit.getOnlinePlayers(), l.clone().add(.45, 0, -.13), Color.fromRGB(255, 255, 0));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5));
    }

    public static ArrayList<Location> getCircle(Location center, double radius, int amount) {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        ArrayList<Location> locations = new ArrayList<Location>();
        for (int i = 0; i < amount; i++) {
            double angle = i * increment;
            double x = center.getX() + (radius * Math.cos(angle));
            double z = center.getZ() + (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }

    public static ArrayList<Location> getCircleReverse(Location center, double radius, int amount) {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        ArrayList<Location> locations = new ArrayList<Location>();
        for (int i = 0; i < amount; i++) {
            double angle = i * increment;
            double x = center.getX() - (radius * Math.cos(angle));
            double z = center.getZ() - (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }

    public static void playSantaHat(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
                if (!Methods.anyPlayers(l.clone(), range)) return;
                startSoulWell(l, L);
            }
        }, 0, 16));
    }

    public static void playBigSoulWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
                if (!Methods.anyPlayers(l.clone(), range)) return;
                startBigSoulWell(l, L);
            }
        }, 0, 25));
    }

    public static void playFlameWheel(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
                if (!Methods.anyPlayers(l.clone(), range)) return;
                startFlameWheel(l.clone(), L);
            }
        }, 0, 25));
        R.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, .1, .5);

            @Override
            public void run() {
                if (!Methods.anyPlayers(l.clone(), range)) return;
                ArrayList<Location> locs = getCircle(l, 3.5, 75);
                for (Location i : locs)
                    ParticleEffects.FLAME.display(0, 0, 0, 0, 1, i, 100);
            }
        }, 0, 10));

    }

    public static void playWitchTornado(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
                if (!Methods.anyPlayers(l.clone(), range)) return;
                startWitchTornado(l, L);
            }
        }, 0, 30));
    }

    public static void playLoveTornado(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
                if (!Methods.anyPlayers(l.clone(), range)) return;
                startLoveTornado(l, L);
            }
        }, 0, 30));
    }

    public static void playBigLoveWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
                if (!Methods.anyPlayers(l.clone(), range)) return;
                startBigLoveWell(l, L);
            }
        }, 0, 25));
    }

    public static void playLoveWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<Integer, Integer>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
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
                if (!Methods.anyPlayers(l.clone(), range)) return;
                startLoveWell(l, L);
            }
        }, 0, 16));
    }

    public void ranLoc(ParticleEffect part, Location loc, double offsetX, double offsetY, double offsetZ, int Amount, Color color) {
        for (int i = 0; i < Amount; i++) {
            try {
                part.sendColor(Bukkit.getOnlinePlayers(), RanSpawn(loc.clone(), offsetX, offsetY, offsetZ), color);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}