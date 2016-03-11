package eu.janschupke.tale.base.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import eu.janschupke.tale.base.App;

/**
 * Resource handler for all texture.
 *
 * @author jan.schupke@gmail.com
 */
public class TextureHandler extends BaseResourceContainer {
    private Pixmap gameCursorPixmap;
    private Texture menuBackgroundTexture;
    private Texture hudBackgroundTexture;

    private Texture playerTexture;

    // Cave.
    private Texture caveBookItemTexture;
    private Texture caveJournalItemTexture;
    private Texture caveCorpsecUnitTexture;
    private Texture caveVilleUnitTexture;
    private Texture caveVilleSadTexture;

    // Dungeon.
    private Texture dungeonChestItemTexture;
    private Texture dungeonGateKeyItemTexture;
    private Texture dungeonGateObstacleTexture;
    private Texture dungeonGateOpenTexture;
    private Texture dungeonHarpsichordTexture;

    // Forest.
    private Texture forestCoinTexture;
    private Texture caravanObstacleTexture;
    private Texture ukkoUnitTexture;

    // Outskirts.
    private Texture outskirtsLumberItemTexture;
    private Texture outskirtsVarpunenItemTexture;
    private Texture outskirtsCaveTexture;
    private Texture outskirtsCroneShackTexture;
    private Texture outskirtsJackHouseTexture;
    private Texture outskirtsRoadSignTexture;
    private Texture outskirtsCroneUnitTexture;
    private Texture outskirtsJackUnitTexture;

    // Settlement.
    private Texture settlementHouseKeyTexture;
    private Texture settlementBlacksmithObstacleTexture;
    private Texture settlementChoboHouseTexture;
    private Texture settlementDungeonTexture;
    private Texture settlementFarmTexture;
    private Texture settlementFountainTexture;
    private Texture settlementRoadSignTexture;
    private Texture settlementTavernTexture;
    private Texture settlementChoboTexture;
    private Texture settlementSmithTexture;

    public TextureHandler(final App app) {
        super(app);
        gameCursorPixmap = new Pixmap(Gdx.files.internal("textures/gui/application-cursor.png"));
        menuBackgroundTexture = new Texture(Gdx.files.internal("textures/gui/menu-background.png"));
        hudBackgroundTexture = new Texture(Gdx.files.internal("textures/gui/hud-background.png"));

        playerTexture = new Texture(Gdx.files.internal("textures/sprites/player.png"));

        // Cave.
        caveBookItemTexture = new Texture(Gdx.files.internal("textures/levels/cave/items/book.png"));
        caveJournalItemTexture = new Texture(Gdx.files.internal("textures/levels/cave/items/journal.png"));
        caveCorpsecUnitTexture = new Texture(Gdx.files.internal("textures/levels/cave/units/corpsec.png"));
        caveVilleUnitTexture = new Texture(Gdx.files.internal("textures/levels/cave/units/ville.png"));
        caveVilleSadTexture = new Texture(Gdx.files.internal("textures/levels/cave/units/ville-sad.png"));

        // Dungeon.
        dungeonChestItemTexture = new Texture(Gdx.files.internal("textures/levels/dungeon/items/chest.png"));
        dungeonGateKeyItemTexture = new Texture(Gdx.files.internal("textures/levels/dungeon/items/key.png"));
        dungeonGateObstacleTexture = new Texture(Gdx.files.internal("textures/levels/dungeon/terrain/gate-closed.png"));
        dungeonGateOpenTexture = new Texture(Gdx.files.internal("textures/levels/dungeon/terrain/gate-open.png"));
        dungeonHarpsichordTexture = new Texture(Gdx.files.internal("textures/levels/dungeon/terrain/harpsichord.png"));

        // Forest.
        forestCoinTexture = new Texture(Gdx.files.internal("textures/levels/forest/items/coin.png"));
        caravanObstacleTexture = new Texture(Gdx.files.internal("textures/levels/forest/terrain/caravan.png"));
        ukkoUnitTexture = new Texture(Gdx.files.internal("textures/levels/forest/units/ukko.png"));

        // Outskirts.
        outskirtsLumberItemTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/items/lumber.png"));
        outskirtsVarpunenItemTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/items/varpunen.png"));
        outskirtsCaveTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/terrain/cave-entrance.png"));
        outskirtsCroneShackTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/terrain/crone-shack.png"));
        outskirtsJackHouseTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/terrain/jack-house.png"));
        outskirtsRoadSignTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/terrain/road-sign.png"));
        outskirtsCroneUnitTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/units/crone.png"));
        outskirtsJackUnitTexture = new Texture(Gdx.files.internal("textures/levels/outskirts/units/jack.png"));

        // Settlement.
        settlementHouseKeyTexture = new Texture(Gdx.files.internal("textures/levels/settlement/items/house-key.png"));
        settlementBlacksmithObstacleTexture = new Texture(Gdx.files.internal("textures/levels/settlement/terrain/blacksmith.png"));
        settlementChoboHouseTexture = new Texture(Gdx.files.internal("textures/levels/settlement/terrain/chobo-house.png"));
        settlementDungeonTexture = new Texture(Gdx.files.internal("textures/levels/settlement/terrain/dungeon.png"));
        settlementFarmTexture = new Texture(Gdx.files.internal("textures/levels/settlement/terrain/farm.png"));
        settlementFountainTexture = new Texture(Gdx.files.internal("textures/levels/settlement/terrain/fountain.png"));
        settlementRoadSignTexture = new Texture(Gdx.files.internal("textures/levels/settlement/terrain/road-sign.png"));
        settlementTavernTexture = new Texture(Gdx.files.internal("textures/levels/settlement/terrain/tavern.png"));
        settlementChoboTexture = new Texture(Gdx.files.internal("textures/levels/settlement/units/chobo.png"));
        settlementSmithTexture = new Texture(Gdx.files.internal("textures/levels/settlement/units/smith.png"));
    }

    public Texture getSettlementSmithTexture() {
        return settlementSmithTexture;
    }

    public Texture getSettlementChoboTexture() {
        return settlementChoboTexture;
    }

    public Texture getSettlementTavernTexture() {
        return settlementTavernTexture;
    }

    public Texture getSettlementRoadSignTexture() {
        return settlementRoadSignTexture;
    }

    public Texture getSettlementFountainTexture() {
        return settlementFountainTexture;
    }

    public Texture getSettlementFarmTexture() {
        return settlementFarmTexture;
    }

    public Texture getSettlementDungeonTexture() {
        return settlementDungeonTexture;
    }

    public Texture getSettlementChoboHouseTexture() {
        return settlementChoboHouseTexture;
    }

    public Texture getSettlementBlacksmithObstacleTexture() {
        return settlementBlacksmithObstacleTexture;
    }

    public Texture getSettlementHouseKeyTexture() {
        return settlementHouseKeyTexture;
    }

    public Texture getOutskirtsJackUnitTexture() {
        return outskirtsJackUnitTexture;
    }

    public Texture getOutskirtsCroneUnitTexture() {
        return outskirtsCroneUnitTexture;
    }

    public Texture getOutskirtsRoadSignTexture() {
        return outskirtsRoadSignTexture;
    }

    public Texture getOutskirtsJackHouseTexture() {
        return outskirtsJackHouseTexture;
    }

    public Texture getOutskirtsCroneShackTexture() {
        return outskirtsCroneShackTexture;
    }

    public Texture getOutskirtsCaveTexture() {
        return outskirtsCaveTexture;
    }

    public Texture getOutskirtsVarpunenItemTexture() {
        return outskirtsVarpunenItemTexture;
    }

    public Texture getOutskirtsLumberItemTexture() {
        return outskirtsLumberItemTexture;
    }

    public Texture getUkkoUnitTexture() {
        return ukkoUnitTexture;
    }

    public Texture getCaravanObstacleTexture() {
        return caravanObstacleTexture;
    }

    public Texture getForestCoinTexture() {
        return forestCoinTexture;
    }

    public Texture getCaveVilleSadTexture() {
        return caveVilleSadTexture;
    }

    public Texture getDungeonGateOpenTexture() {
        return dungeonGateOpenTexture;
    }

    public Texture getDungeonHarpsichordTexture() {
        return dungeonHarpsichordTexture;
    }

    public Texture getDungeonGateObstacleTexture() {
        return dungeonGateObstacleTexture;
    }

    public Texture getDungeonGateKeyItemTexture() {
        return dungeonGateKeyItemTexture;
    }

    public Texture getDungeonChestItemTexture() {
        return dungeonChestItemTexture;
    }

    public Texture getCaveVilleUnitTexture() {
        return caveVilleUnitTexture;
    }

    public Texture getCaveCorpsecUnitTexture() {
        return caveCorpsecUnitTexture;
    }

    public Texture getCaveJournalItemTexture() {
        return caveJournalItemTexture;
    }

    public Texture getCaveBookItemTexture() {
        return caveBookItemTexture;
    }

    public Texture getPlayerTexture() {
        return playerTexture;
    }

    public Pixmap getGameCursorPixmap() {
        return gameCursorPixmap;
    }

    public Drawable getMenuBackgroundDrawable() {
        TextureRegion backgroundRegion = new TextureRegion(menuBackgroundTexture);
        return new TextureRegionDrawable(backgroundRegion);
    }

    public Drawable getHudBackgroundDrawable() {
        TextureRegion backgroundRegion = new TextureRegion(hudBackgroundTexture);
        return new TextureRegionDrawable(backgroundRegion);
    }

    @Override
    public void dispose() {
        gameCursorPixmap.dispose();
        menuBackgroundTexture.dispose();
        hudBackgroundTexture.dispose();
        playerTexture.dispose();
        caveBookItemTexture.dispose();
        caveJournalItemTexture.dispose();
        caveCorpsecUnitTexture.dispose();
        caveVilleUnitTexture.dispose();
        caveVilleSadTexture.dispose();
        dungeonChestItemTexture.dispose();
        dungeonGateKeyItemTexture.dispose();
        dungeonGateObstacleTexture.dispose();
        dungeonGateOpenTexture.dispose();
        dungeonHarpsichordTexture.dispose();
        forestCoinTexture.dispose();
        caravanObstacleTexture.dispose();
        ukkoUnitTexture.dispose();
        outskirtsLumberItemTexture.dispose();
        outskirtsVarpunenItemTexture.dispose();
        outskirtsCaveTexture.dispose();
        outskirtsCroneShackTexture.dispose();
        outskirtsJackHouseTexture.dispose();
        outskirtsRoadSignTexture.dispose();
        outskirtsCroneUnitTexture.dispose();
        outskirtsJackUnitTexture.dispose();
        settlementHouseKeyTexture.dispose();
        settlementBlacksmithObstacleTexture.dispose();
        settlementChoboHouseTexture.dispose();
        settlementDungeonTexture.dispose();
        settlementFarmTexture.dispose();
        settlementFountainTexture.dispose();
        settlementRoadSignTexture.dispose();
        settlementTavernTexture.dispose();
        settlementChoboTexture.dispose();
        settlementSmithTexture.dispose();
    }
}
