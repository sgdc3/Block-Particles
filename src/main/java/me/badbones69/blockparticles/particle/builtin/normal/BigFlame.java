package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import me.badbones69.blockparticles.util.ParticleUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class BigFlame extends AbstractParticle {

    public BigFlame() {
        super(new Vector(.5, .1, .5), 5, location -> new ParticleTickHandler() {
            private List<Location> circle1 = ParticleUtils.getCircle(location, 1, 15);
            private List<Location> circle2 = ParticleUtils.getCircle(location, 2, 25);

            @Override
            public void tick(final List<Player> receivers) {
                for (Location current : circle1) {
                    ParticleEffect.FLAME.send(receivers, current, 0, 0, 0, 0, 1);
                }
                for (Location current : circle2) {
                    ParticleEffect.FLAME.send(receivers, current, 0, 0, 0, 0, 1);
                }
            }
        });
    }
}
