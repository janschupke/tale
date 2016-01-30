package eu.janschupke.buddy.framework.util;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;

/**
 * Helper class for particle effects.
 */
public class ParticleEffectContainer {
    ParticleEffect particleEffect;
    ParticleEffectPool particleEffectPool;

    public ParticleEffect getParticleEffect() {
        return particleEffect;
    }

    public void setParticleEffect(ParticleEffect particleEffect) {
        this.particleEffect = particleEffect;
    }

    public ParticleEffectPool getParticleEffectPool() {
        return particleEffectPool;
    }

    public void setParticleEffectPool(ParticleEffectPool particleEffectPool) {
        this.particleEffectPool = particleEffectPool;
    }
}
