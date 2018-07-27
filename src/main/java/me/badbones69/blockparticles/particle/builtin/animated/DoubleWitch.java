package me.badbones69.blockparticles.particle.builtin.animated;

import javafx.util.Pair;
import me.badbones69.blockparticles.particle.AbstractParticle;
import me.badbones69.blockparticles.particle.AnimationTickHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.inventivetalent.particle.ParticleEffect;

import java.util.Arrays;
import java.util.List;

public class DoubleWitch extends AbstractParticle {

    public DoubleWitch() {
        super(new Vector(.5, .2, .5), 2, location -> new AnimationTickHandler(16) {
            private List<Pair<Location, Location>> locations = Arrays.asList(
                    new Pair<>(location.clone().add(.8, 0, 0), location.clone().add(-.8, 0, 0)),
                    new Pair<>(location.clone().add(.75, 0, .43), location.clone().add(-.75, 0, -.43)),
                    new Pair<>(location.clone().add(.65, 0, .65), location.clone().add(-.65, 0, -.65)),
                    new Pair<>(location.clone().add(.43, 0, .75), location.clone().add(-.43, 0, -.75)),
                    new Pair<>(location.clone().add(0, 0, .8), location.clone().add(0, 0, -.8)),
                    new Pair<>(location.clone().add(-.43, 0, .75), location.clone().add(.43, 0, -.75)),
                    new Pair<>(location.clone().add(-.65, 0, .65), location.clone().add(.65, 0, -.65)),
                    new Pair<>(location.clone().add(-.75, 0, .43), location.clone().add(.75, 0, -.43)),
                    new Pair<>(location.clone().add(-.8, 0, 0), location.clone().add(.8, 0, 0)),
                    new Pair<>(location.clone().add(-.75, 0, -.43), location.clone().add(.75, 0, .43)),
                    new Pair<>(location.clone().add(-.65, 0, -.65), location.clone().add(.65, 0, .65)),
                    new Pair<>(location.clone().add(-.43, 0, -.75), location.clone().add(.43, 0, .75)),
                    new Pair<>(location.clone().add(0, 0, -.8), location.clone().add(0, 0, .8)),
                    new Pair<>(location.clone().add(.43, 0, -.75), location.clone().add(-.43, 0, .75)),
                    new Pair<>(location.clone().add(.65, 0, -.65), location.clone().add(-.65, 0, .65)),
                    new Pair<>(location.clone().add(.75, 0, -.43), location.clone().add(-.75, 0, .43))
            );

            @Override
            public void frame(int currentFrame, final List<Player> receivers) {
                Pair<Location, Location> current = locations.get(currentFrame);
                ParticleEffect.SPELL_WITCH.send(receivers, current.getKey(), 0, 0, 0, 0, 5);
                ParticleEffect.SPELL_WITCH.send(receivers, current.getValue(), 0, 0, 0, 0, 5);
            }
        });
    }
}
