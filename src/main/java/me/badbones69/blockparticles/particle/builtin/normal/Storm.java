package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class Storm extends AbstractParticle {

    public Storm() {
        super(new Vector(.5, 2, .5), 2, location -> new ParticleTickHandler() {
            private Location location1 = location.clone().add(0, 0, .1);

            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.CLOUD.send(receivers, location, .3, 0, .3, 0, 15);
                ParticleEffect.WATER_DROP.send(receivers, location1, .2, 0, .2, 0, 10);
            }
        });
    }
}
