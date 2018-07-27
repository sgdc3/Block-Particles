package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import me.badbones69.blockparticles.util.ParticleUtils;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class Potion extends AbstractParticle {

    public Potion() {
        super(new Vector(.5, .2, .5), 2, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                for (int i = 0; i < 3; i++) {
                    ParticleEffect.SPELL_MOB.send(receivers, location, .3, 0, .3, ParticleUtils.randomColor(), 6);
                }
            }
        });
    }
}
