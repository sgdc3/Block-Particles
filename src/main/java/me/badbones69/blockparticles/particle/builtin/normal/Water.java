package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.Arrays;
import java.util.List;

public class Water extends AbstractParticle {

    public Water() {
        super(new Vector(.5, .8, .6), 2, location -> new ParticleTickHandler() {
            private List<Location> locations = Arrays.asList(
                    location.clone().add(0, .1, 0),
                    location.clone().add(0, .5, 0),
                    location.clone().add(.2, .3, .2),
                    location.clone().add(-.2, .3, .2),
                    location.clone().add(.2, .3, -.2),
                    location.clone().add(-.2, .3, -.2)
            );

            @Override
            public void tick(final List<Player> receivers) {
                for (Location current : locations) {
                    ParticleEffect.WATER_DROP.send(receivers, current, 0, 0, 0, 0, 10);
                }
            }
        });
    }
}
