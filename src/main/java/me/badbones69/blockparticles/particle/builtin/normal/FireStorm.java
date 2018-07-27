package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import me.badbones69.blockparticles.util.ParticleUtils;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class FireStorm extends AbstractParticle {

    public FireStorm() {
        super(new Vector(.5, 2, .5), 2, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.SMOKE_LARGE.send(receivers, location, .3, 0, .3, 0, 15);
                for (int i = 0; i < 2; i++) {
                    ParticleEffect.FLAME.send(receivers, ParticleUtils.drop(location), 0, -.2, 0, 1, 1);
                }
            }
        });
    }
}
