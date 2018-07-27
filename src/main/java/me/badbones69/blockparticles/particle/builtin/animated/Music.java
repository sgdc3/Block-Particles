package me.badbones69.blockparticles.particle.builtin.animated;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.AnimationTickHandler;
import me.badbones69.blockparticles.util.ParticleUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class Music extends AbstractParticle {

    public Music() {
        super(new Vector(.5, .2, .5), 2, location -> new AnimationTickHandler(16) {
            private List<Location> locations = ParticleUtils.getCircle(location, 1, 16);

            @Override
            public void frame(int currentFrame, final List<Player> receivers) {
                ParticleEffect.NOTE.send(receivers, locations.get(currentFrame), 0, 0, 0, ParticleUtils.randomColor(), 1);
            }
        });
    }
}
