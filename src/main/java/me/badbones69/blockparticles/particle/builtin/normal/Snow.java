package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class Snow extends AbstractParticle {

    public Snow() {
        super(new Vector(.5, 2, .5), 2, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.FIREWORKS_SPARK.send(receivers, location, .7, .7, .7, 0, 1);
            }
        });
    }
}
