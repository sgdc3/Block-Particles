package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.Arrays;
import java.util.List;

public class Chains extends AbstractParticle {

    public Chains() {
        super(new Vector(.5, .1, .5), 5, location -> new ParticleTickHandler() {
            private List<Location> locations = Arrays.asList(
                    location.clone().add(1, 0, 1),
                    location.clone().add(.9, .1, .9),
                    location.clone().add(.8, .2, .8),
                    location.clone().add(.7, .3, .7),
                    location.clone().add(.6, .4, .6),
                    location.clone().add(.5, .6, .5),
                    location.clone().add(.4, .8, .4),

                    location.clone().add(-1, 0, 1),
                    location.clone().add(-.9, .1, .9),
                    location.clone().add(-.8, .2, .8),
                    location.clone().add(-.7, .3, .7),
                    location.clone().add(-.6, .4, .6),
                    location.clone().add(-.5, .6, .5),
                    location.clone().add(-.4, .8, .4),
                    location.clone().add(-1, 0, -1),

                    location.clone().add(-.9, .1, -.9),
                    location.clone().add(-.8, .2, -.8),
                    location.clone().add(-.7, .3, -.7),
                    location.clone().add(-.6, .4, -.6),
                    location.clone().add(-.5, .6, -.5),
                    location.clone().add(-.4, .8, -.4),

                    location.clone().add(1, 0, -1),
                    location.clone().add(.9, .1, -.9),
                    location.clone().add(.8, .2, -.8),
                    location.clone().add(.7, .3, -.7),
                    location.clone().add(.6, .4, -.6),
                    location.clone().add(.5, .6, -.5),
                    location.clone().add(.4, .8, -.4)
            );

            @Override
            public void tick(final List<Player> receivers) {
                for (Location current : locations) {
                    ParticleEffect.FLAME.send(receivers, current, 0, 0, 0, 0, 1);
                }
            }
        });
    }
}
