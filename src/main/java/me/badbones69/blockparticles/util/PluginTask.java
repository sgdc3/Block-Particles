package me.badbones69.blockparticles.util;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class PluginTask extends BukkitRunnable {
    private final int delay;
    private final int interval;

    public PluginTask(int delay, int interval) {
        this.delay = delay;
        this.interval = interval;
    }

    public PluginTask(int delay) {
        this(delay, -1);
    }

    public void start(final Plugin plugin) {
        if (!isCancelled()) {
            cancel();
        }
        if (interval < 0) {
            runTaskLater(plugin, delay);
        } else {
            runTaskTimer(plugin, delay, interval);
        }
    }
}
