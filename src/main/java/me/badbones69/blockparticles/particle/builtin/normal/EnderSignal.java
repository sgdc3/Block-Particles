package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class EnderSignal extends AbstractParticle {

    public EnderSignal() {
        super(new Vector(.5, 0, .5), 8, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                for(int i=0; i<4; i++) {
                    location.getWorld().playEffect(location, Effect.ENDER_SIGNAL, 1);
                }
            }
        });
    }
}
