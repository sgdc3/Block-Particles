package me.badbones69.blockparticles.particle;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class ParticleTickHandler {

    public ParticleTickHandler() {
    }

    public abstract void tick(final List<Player> receivers);
}
