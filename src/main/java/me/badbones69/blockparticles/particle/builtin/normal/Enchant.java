package me.badbones69.blockparticles.particle.builtin.normal;

import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.ParticleTickHandler;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.List;

public class Enchant extends AbstractParticle {

    public Enchant() {
        super(new Vector(.5, 1.5, .5), 2, location -> new ParticleTickHandler() {
            @Override
            public void tick(final List<Player> receivers) {
                ParticleEffect.ENCHANTMENT_TABLE.send(receivers, location, 0, 0, 0, 2, 20);
            }
        });
    }
}
