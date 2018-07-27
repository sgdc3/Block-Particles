package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class HappyVillager extends AbstractParticle {

    public HappyVillager() {
        super(new Vector(.5, .1, .5), 20, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.VILLAGER_HAPPY.send(receivers, location, .5, .5, .5, 0, 10);
            }
        });
    }
}
