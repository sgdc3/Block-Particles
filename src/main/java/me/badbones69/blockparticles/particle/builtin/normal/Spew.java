package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import me.badbones69.blockparticles.util.ParticleUtils;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class Spew extends AbstractParticle {

    public Spew() {
        super(new Vector(.5, 1, .5), 2, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                Vector direction = new Vector(ParticleUtils.vector(), .1, ParticleUtils.vector());
                ParticleEffect.FIREWORKS_SPARK.send(receivers, location, direction.getX(), direction.getY(), direction.getZ(), 1, 1);
            }
        });
    }
}
