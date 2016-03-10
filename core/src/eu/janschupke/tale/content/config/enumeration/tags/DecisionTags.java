package eu.janschupke.tale.content.config.enumeration.tags;

/**
 * Enumeration of tags for all interaction decisions in the game.
 *
 * @author jan.schupke@gmail.com
 */
public enum DecisionTags {
    // Global.
    GLOBAL_END,

    // Forest.
    FOREST_COIN_PICKUP,
    FOREST_COIN_IGNORE,
    FOREST_UKKO_DISCUSS,
    FOREST_UKKO_DELIVERY,

    // Outskirts.
    OUTSKIRTS_LUMBER_PICKUP,
    OUTSKIRTS_LUMBER_IGNORE,
    OUTSKIRTS_VARPUNEN_IGNORE,
    OUTSKIRTS_VARPUNEN_PICKUP,
    OUTSKIRTS_CRONE_VARPUNEN_SHOW,
    OUTSKIRTS_CRONE_VARPUNEN_GIVE,
    OUTSKIRTS_CAVE_ENTER,
    OUTSKIRTS_JACK_TALK_FOREST,
    OUTSKIRTS_JACK_DISPUTE_ACCEPT,
    OUTSKIRTS_JACK_LUMBER_ACCEPT,
    OUTSKIRTS_JACK_LUMBER_GIVE,
    OUTSKIRTS_JACK_TALK_CRONE,
    OUTSKIRTS_JACK_TALK_DISPUTE,
    OUTSKIRTS_JACK_TALK_BOOK_GIVE,
    OUTSKIRTS_JACK_TALK_FAIL,

    // Cave.
    CAVE_CORPSEC_INVESTIGATE_SEARCH,
    CAVE_CORPSEC_SEARCH_LOOT,
    CAVE_VILLE_TALK_INQUIRY,
    CAVE_VILLE_INQUIRY_AGGRO,
    CAVE_VILLE_INQUIRY_LEAVE,

    // Dungeon.
    // Nothing yet.
}
