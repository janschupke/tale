package eu.janschupke.buddy.content.stage.level.forest.unit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import eu.janschupke.buddy.content.stage.level.forest.ForestEventHandler;
import eu.janschupke.buddy.framework.base.entity.Triggerable;
import eu.janschupke.buddy.framework.base.entity.Unit;
import eu.janschupke.buddy.framework.base.event.InteractionSwitch;
import eu.janschupke.buddy.framework.base.exception.NoHudException;
import eu.janschupke.buddy.framework.base.interaction.Decision;
import eu.janschupke.buddy.framework.base.interaction.Interaction;
import eu.janschupke.buddy.framework.base.interaction.Situation;
import eu.janschupke.buddy.framework.base.screen.GameScreen;
import eu.janschupke.buddy.framework.base.world.BaseWorld;
import eu.janschupke.buddy.framework.config.Config;

/**
 * Ukko unit class.
 *
 * @author jan.schupke@gmail.com
 */
public class UkkoUnit extends Unit implements Triggerable {
    private Interaction interaction = new Interaction() {
        Situation talkSituation;
        Situation deliveryResultSituation;

        @Override
        protected void configure() {
            title = world.getScreen().getApp().getLang().get("level.forest.interaction.ukko.title");
            talkSituation = new TalkSituation();
            deliveryResultSituation = new DeliveryResultSituation();
            situations.add(talkSituation);
            situations.add(deliveryResultSituation);
            currentSituation = talkSituation;
            fallbackSituation = talkSituation;
        }

        @Override
        public void handle(Decision decision) {
            if (decision instanceof TalkSituation.DeliveryDecision) {
                ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getUkkoDeliveryEvent().trigger();
                transition(deliveryResultSituation, world.getScreen().getApp());
                talkSituation.getDecision(Config.Decisions.FOREST_UKKO_DELIVERY).setAvailable(false);
            } else {
                endInteraction(world.getScreen().getApp());
            }
        }
    };

    private class TalkSituation extends Situation {
        public TalkSituation() {
            super(world.getScreen().getApp().getLang().get("level.forest.interaction.ukko.talk.description"));
            decisions.add(new DeliveryDecision());
            decisions.add(new EndDecision());
        }

        private class DeliveryDecision extends Decision {
            public DeliveryDecision() {
                super(world.getScreen().getApp().getLang().get("level.forest.interaction.ukko.talk.decision.delivery"),
                        Config.Decisions.FOREST_UKKO_DELIVERY);
            }

            @Override
            protected void configureMetrics() {
                // Does not influence personality.
            }
        }

        private class EndDecision extends Decision {
            public EndDecision() {
                super(world.getScreen().getApp().getLang().get("level.forest.interaction.ukko.talk.decision.end"),
                        Config.Decisions.GLOBAL_END);
            }

            @Override
            protected void configureMetrics() {
                // Does not influence personality.
            }
        }
    }

    private class DeliveryResultSituation extends Situation {
        public DeliveryResultSituation() {
            super(world.getScreen().getApp().getLang().get("level.forest.interaction.ukko.delivery-result.description"));
            decisions.add(new EndDecision());
        }

        private class EndDecision extends Decision {
            public EndDecision() {
                super(world.getScreen().getApp().getLang().get("level.forest.interaction.ukko.delivery-result.decision.end"),
                        Config.Decisions.GLOBAL_END);
            }

            @Override
            protected void configureMetrics() {
                // Does not influence personality.
            }
        }
    }

    public UkkoUnit(BaseWorld world) {
        super(world, new Texture(Gdx.files.internal("textures/levels/forest/units/ukko.png")));
        animationTexture = new Texture(Gdx.files.internal("textures/levels/forest/units/ukko.png"));
        animationFrames = TextureRegion.split(animationTexture, 100, 100);
        initAnimations();
        initIdleSprites();
        interactionHint = world.getScreen().getApp().getLang().get("hint.global.talk");
    }

    @Override
    protected void initIdleSprites() {
        Texture t = sprite.getTexture();
        idleTextures.put(Direction.UP, new TextureRegion(t, 0, 100, 100, 100));
        idleTextures.put(Direction.DOWN, new TextureRegion(t, 0, 200, 100, 100));
        TextureRegion tr = new TextureRegion(t, 0, 0, 100, 100);
        tr.flip(true, false);
        idleTextures.put(Direction.RIGHT, tr);
        idleTextures.put(Direction.LEFT, new TextureRegion(t, 0, 0, 100, 100));
    }

    @Override
    public void engage() {
        InteractionSwitch.enable(this,
                ((ForestEventHandler) ((GameScreen) world.getScreen()).getLevelEventHandler()).getUkkoInteractionEvent(),
                world.getScreen().getApp());
    }

    @Override
    public void disengage() {
        try {
            endInteraction(world.getScreen().getApp());
            InteractionSwitch.disable(world.getScreen().getApp().getHud().getHintTable());
        } catch (NoHudException e) {
            Gdx.app.log("UkkoUnit#disengage", "No HUD problem");
        }
    }

    @Override
    public Interaction getInteraction() {
        return interaction;
    }
}
