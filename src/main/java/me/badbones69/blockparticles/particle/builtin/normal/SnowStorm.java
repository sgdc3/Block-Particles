package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class SnowStorm extends AbstractParticle {

    public SnowStorm() {
        super(new Vector(.5, 2, .5), 2, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.CLOUD.send(receivers, location, .3, 0, .3, 0, 15);
                ParticleEffect.FIREWORKS_SPARK.send(receivers, location, .3, 0, .3, 0, 2);
            }
        });
    }
}
