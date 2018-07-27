package me.badbones69.blockparticles.api;

import me.badbones69.blockparticles.Fountains;
import me.badbones69.blockparticles.Main;
import me.badbones69.blockparticles.ParticleManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class BlockParticles {

    static BlockParticles instance = new BlockParticles();

    public static BlockParticles getInstance() {
        return instance;
    }

    public boolean hasParticle(Location loc) {
        for (String L : Main.settings.getData().getConfigurationSection("Locations").getKeys(false)) {
            String w = Main.settings.getData().getString("Locations." + L + ".World");
            World W = Bukkit.getServer().getWorld(w);
            String x = Main.settings.getData().getString("Locations." + L + ".X");
            String y = Main.settings.getData().getString("Locations." + L + ".Y");
            String z = Main.settings.getData().getString("Locations." + L + ".Z");
            int X = Integer.parseInt(x);
            int Y = Integer.parseInt(y);
            int Z = Integer.parseInt(z);
            Location l = new Location(W, X, Y, Z);
            if (l.equals(loc)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Set a Particle to a specified Location;
     *
     * @param type The Particle you wish to use.
     * @param loc  The location you wish to spawn the Particles.
     * @param name The Location Name.
     * @return
     */
    public void setParticle(Particles type, Location loc, String name) {
        if (ParticleManager.blocks.containsKey(name)) {
            Bukkit.getServer().getScheduler().cancelTask(ParticleManager.blocks.get(name));
        }
        switch (type) {
            case LOVETORNADO:
                ParticleManager.playLoveTornado(loc, name);
                break;
            case WITCHTORNADO:
                ParticleManager.playWitchTornado(loc, name);
                break;
            case LOVEWELL:
                ParticleManager.playLoveWell(loc, name);
                break;
            case BIGLOVEWELL:
                ParticleManager.playBigLoveWell(loc, name);
                break;
            case HALO:
                ParticleManager.playHalo(loc, name);
                break;
            case SANTAHAT:
                ParticleManager.playSantaHat(loc, name);
                break;
            case SOULWELL:
                ParticleManager.playSoulWell(loc, name);
                break;
            case BIGSOULWELL:
                ParticleManager.playBigSoulWell(loc, name);
                break;
            case FLAMEWHEEL:
                ParticleManager.playFlameWheel(loc, name);
                break;
            case MARIO:
                Fountains.startMario(loc, name);
                break;
            case POKEMON:
                Fountains.startPokemon(loc, name);
                break;
            case FOOD:
                Fountains.startFood(loc, name);
                break;
            case MOBS:
                Fountains.startMobs(loc, name);
                break;
            case SNOWBLAST:
                ParticleManager.playSnowBlast(loc, name);
                break;
            case RAINBOW:
                ParticleManager.playRainbow(loc, name);
                break;
            case ENDERSIGNAL:
                ParticleManager.playEnderSignal(loc, name);
                break;
            case MOBSPAWNER:
                ParticleManager.playMobSpawner(loc, name);
                break;
            case ANGRYVILLAGER:
                ParticleManager.playAngryVillager(loc, name);
                break;
            case HAPPYVILLAGER:
                ParticleManager.playHappyVillager(loc, name);
                break;
            case FOOTPRINT:
                ParticleManager.playFootPrint(loc, name);
                break;
            case FIRESPEW:
                ParticleManager.playFireSpew(loc, name);
                break;
            case SPEW:
                ParticleManager.playSpew(loc, name);
                break;
            case STORM:
                ParticleManager.playStorm(loc, name);
                break;
            case SNOWSTORM:
                ParticleManager.playSnowStorm(loc, name);
                break;
            case FIRESTORM:
                ParticleManager.playFireStorm(loc, name);
                break;
            case WITCH:
                ParticleManager.playWitch(loc, name);
                break;
            case DOUBLEWITCH:
                ParticleManager.playDoubleWitch(loc, name);
                break;
            case MAGIC:
                ParticleManager.playMagic(loc, name);
                break;
            case PRESENTS:
                Fountains.startPresents(loc, name);
                break;
            case MUSIC:
                ParticleManager.playMusic(loc, name);
                break;
            case POTION:
                ParticleManager.playPotion(loc, name);
                break;
            case SNOW:
                ParticleManager.playSnow(loc, name);
                break;
            case WATER:
                ParticleManager.startWater(loc, name);
                break;
            case CHAINS:
                ParticleManager.playChains(loc, name);
                break;
            case ENCHANT:
                ParticleManager.playEnchant(loc, name);
                break;
            case FOG:
                ParticleManager.playFog(loc, name);
                break;
            case HEADS:
                Fountains.startHeads(loc, name);
                break;
            case FLAME:
                ParticleManager.playFlame(loc, name);
                break;
            case BIGFLAME:
                ParticleManager.playBigFlame(loc, name);
                break;
            case HALLOWEEN:
                Fountains.startHalloween(loc, name);
                break;
            case GEMS:
                Fountains.startGems(loc, name);
                break;
            case VOLCANO:
                ParticleManager.spawnVolcano(loc, name);
                break;
            case SPIRAL:
                ParticleManager.playSpiral(loc, name);
                break;
            case DOUBLESPIRAL:
                ParticleManager.playDoubleSpiral(loc, name);
                break;
            case CRIT:
                ParticleManager.playCrit(loc, name);
                break;
            case BIGCRIT:
                ParticleManager.playBigCrit(loc, name);
                break;
        }
    }

    /**
     * Remove a Particle;
     *
     * @param name The Location Name.
     */
    public void removeParticle(String name) {
        if (ParticleManager.blocks.containsKey(name)) {
            Bukkit.getServer().getScheduler().cancelTask(ParticleManager.blocks.get(name));
            ParticleManager.blocks.remove(name);
        }
        if (ParticleManager.R.containsKey(name)) {
            Bukkit.getServer().getScheduler().cancelTask(ParticleManager.R.get(name));
            ParticleManager.R.remove(name);
        }
    }

    /**
     * Get the Particle Type of a Particle (Particle/Fountain).
     *
     * @param particle The Particle you want to get the ParticleType from.
     * @return A Particle Type.
     */
    public ParticleType getType(Particles particle) {
        return particle.getType();
    }
}