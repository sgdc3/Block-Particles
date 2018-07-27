package me.badbones69.blockparticles.particle;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class AnimationTickHandler extends ParticleTickHandler {
    private final int frameCount;
    private int currentFrame;

    public AnimationTickHandler(int frameCount) {
        this.frameCount = frameCount;
        this.currentFrame = 0;
    }

    @Override
    public final void tick(final List<Player> receivers) {
        frame(currentFrame, receivers);
        currentFrame++;
        if (currentFrame == frameCount) {
            currentFrame = 0;
        }
    }

    public abstract void frame(int currentFrame, final List<Player> receivers);
}
