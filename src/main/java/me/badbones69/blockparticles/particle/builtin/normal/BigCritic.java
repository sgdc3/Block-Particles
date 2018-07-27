package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import me.badbones69.blockparticles.util.ParticleUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class BigCritic extends AbstractParticle {

    public BigCritic() {
        super(new Vector(.5, .5, .5), 2, location -> new ParticleTickHandler() {
            private List<Location> circle = ParticleUtils.getCircle(location, 2, 20);

            @Override
            public void tick(final List<Player> receivers) {
                for (Location current : circle) {
                    ParticleEffect.CRIT.send(receivers, current, 0, 0, 0, 0, 1);
                }
            }
        });
    }
}
