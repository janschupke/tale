package eu.janschupke.tale.content.config.enumeration.tags;

/**
 * Enumeration of tags for all game log entries.
 *
 * @author jan.schupke@gmail.com
 */
public enum GameEventTags {
    // Global.
    GLOBAL_NEW_GAME,

    // Forest.
    FOREST_EXPLORATION_EAST,
    FOREST_EXPLORATION_NORTH,
    FOREST_EXPLORATION_SOUTH,

    FOREST_GENERAL_INITIAL_WALL_CONTACT,
    FOREST_GENERAL_INTRO_CONTACT,
    FOREST_GENERAL_ITEM_INTRO_CONTACT,
    FOREST_GENERAL_QUEST_WALL_CONTACT,
    FOREST_GENERAL_UNIT_INTRO_CONTACT,

    FOREST_INTERACTION_CARAVAN_INVESTIGATE,
    FOREST_INTERACTION_COIN_INVESTIGATE,
    FOREST_INTERACTION_UKKO_TALK,
    FOREST_INTERACTION_UKKO_DELIVERY,

    FOREST_PICKUP_COIN,

    FOREST_TRANSITION_OUTSKIRTS,

    // Outskirts.
    OUTSKIRTS_EXPLORATION_CAVE,
    OUTSKIRTS_EXPLORATION_JACK,
    OUTSKIRTS_EXPLORATION_VARPUNEN,

    OUTSKIRTS_INTERACTION_CAVE_INVESTIGATE,
    OUTSKIRTS_INTERACTION_CRONE_TALK,
    OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_SHOW,
    OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_GIVE,
    OUTSKIRTS_INTERACTION_CRONE_SHACK_INVESTIGATE,
    OUTSKIRTS_INTERACTION_JACK_HOUSE_INVESTIGATE,
    OUTSKIRTS_INTERACTION_JACK_TALK,
    OUTSKIRTS_INTERACTION_JACK_DISPUTE_ACCEPT,
    OUTSKIRTS_INTERACTION_JACK_DISPUTE_SOLVE,
    OUTSKIRTS_INTERACTION_JACK_LUMBER_ACCEPT,
    OUTSKIRTS_INTERACTION_JACK_LUMBER_GIVE,
    OUTSKIRTS_INTERACTION_JACK_CRONE,
    OUTSKIRTS_INTERACTION_JACK_DISPUTE_REQUEST,
    OUTSKIRTS_INTERACTION_JACK_LUMBER_REQUEST,
    OUTSKIRTS_INTERACTION_JACK_FAIL,
    OUTSKIRTS_INTERACTION_LUMBER_INVESTIGATE,
    OUTSKIRTS_INTERACTION_ROAD_SIGN_INVESTIGATE,
    OUTSKIRTS_INTERACTION_VARPUNEN_INVESTIGATE,

    OUTSKIRTS_PICKUP_LUMBER,
    OUTSKIRTS_PICKUP_VARPUNEN,

    OUTSKIRTS_TRANSITION_CAVE,
    OUTSKIRTS_TRANSITION_FOREST,
    OUTSKIRTS_TRANSITION_SETTLEMENT,

    // Cave.
    CAVE_EXPLORATION_CORPSEC,

    CAVE_INTERACTION_CORPSEC_INVESTIGATE,
    CAVE_INTERACTION_CORPSEC_LOOT,
    CAVE_INTERACTION_CORPSEC_SEARCH,

    CAVE_INTERACTION_VILLE_TALK,
    CAVE_INTERACTION_VILLE_AGGRO,
    CAVE_INTERACTION_VILLE_INQUIRY,
    CAVE_INTERACTION_VILLE_LEAVE,

    CAVE_TRANSITION_OUTSKIRTS,

    // Settlement.
    SETTLEMENT_EXPLORATION_CHOBO,
    SETTLEMENT_EXPLORATION_DUNGEON,

    SETTLEMENT_INTERACTION_CHOBO_HOUSE_INVESTIGATE,
    SETTLEMENT_INTERACTION_CHOBO_TALK,
    SETTLEMENT_INTERACTION_CHOBO_HOUSE,
    SETTLEMENT_INTERACTION_CHOBO_JOURNAL_GIVE,
    SETTLEMENT_INTERACTION_CHOBO_JOURNAL,
    SETTLEMENT_INTERACTION_CHOBO_KEY,
    SETTLEMENT_INTERACTION_CHOBO_DUNGEON,
    SETTLEMENT_INTERACTION_DUNGEON_INVESTIGATE,
    SETTLEMENT_INTERACTION_FARM_INVESTIGATE,
    SETTLEMENT_INTERACTION_FOUNTAIN_INVESTIGATE,
    SETTLEMENT_INTERACTION_ROAD_SIGN_INVESTIGATE,
    SETTLEMENT_INTERACTION_SMITH_HOUSE_INVESTIGATE,
    SETTLEMENT_INTERACTION_SMITH_TALK,
    SETTLEMENT_INTERACTION_SMITH_ASSISTANCE,
    SETTLEMENT_INTERACTION_SMITH_ACCEPT,
    SETTLEMENT_INTERACTION_SMITH_RAMBLING,
    SETTLEMENT_INTERACTION_TAVERN_INVESTIGATE,

    SETTLEMENT_TRANSITION_DUNGEON,
    SETTLEMENT_TRANSITION_OUTSKIRTS,

    // Dungeon.
    DUNGEON_EXPLORATION_STUDY,

    DUNGEON_INTERACTION_CHEST_INVESTIGATE,
    DUNGEON_INTERACTION_CHEST_COLLECT,
    DUNGEON_INTERACTION_CHEST_SEARCH,
    DUNGEON_INTERACTION_GATE_INVESTIGATE,
    DUNGEON_INTERACTION_GATE_OPEN,
    DUNGEON_INTERACTION_HARPSICHORD_INVESTIGATE,
    DUNGEON_INTERACTION_HARPSICHORD_PLAY,

    DUNGEON_TRANSITION_EXIT,
    DUNGEON_TRANSITION_SETTLEMENT,
}
