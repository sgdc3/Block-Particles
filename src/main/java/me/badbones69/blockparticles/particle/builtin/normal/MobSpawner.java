package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class MobSpawner extends AbstractParticle {

    public MobSpawner() {
        super(new Vector(.5, .1, .5), 8, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.FLAME.send(receivers, location, .5, .5, .5, 0, 15);
            }
        });
    }
}
