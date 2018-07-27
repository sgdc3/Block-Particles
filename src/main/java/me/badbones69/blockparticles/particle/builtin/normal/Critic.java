package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class Critic extends AbstractParticle {

    public Critic() {
        super(new Vector(.5, 1.1, .5), 2, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.CRIT.send(receivers, location, 0, 0, 0, 0, 1);
            }
        });
    }
}
