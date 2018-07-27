package me.badbones69.blockparticles.particle;

import me.badbones69.blockparticles.util.PluginTask;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractParticle {
    private final Vector locationOffset;
    private final int tickInterval;
    private final Function<Location, ParticleTickHandler> handlerSupplier;
    private int activationRange;

    public AbstractParticle(final Vector locationOffset, int tickInterval, final Function<Location, ParticleTickHandler> handlerSupplier) {
        this.locationOffset = locationOffset;
        this.tickInterval = tickInterval;
        this.handlerSupplier = handlerSupplier;
        this.activationRange = 25; // Default activation range
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public void setActivationRange(int activationRange) {
        this.activationRange = activationRange;
    }

    public PluginTask spawn(final Location location) {
        final Location particleLocation = location.clone().add(locationOffset);
        final ParticleTickHandler handler = handlerSupplier.apply(particleLocation);
        return new PluginTask(0, tickInterval) {
            @Override
            public void run() {
                // Get nearby players
                List<Player> receivers = null;
                for (Player player : location.getWorld().getPlayers()) {
                    if (player.getLocation().distanceSquared(location) > (activationRange * activationRange)) {
                        return;
                    }
                    if (receivers == null) {
                        receivers = new ArrayList<>();
                    }
                    receivers.add(player);
                }
                if (receivers == null) {
                    return; // No nearby players
                }
                handler.tick(receivers);
            }
        };
    }
}
