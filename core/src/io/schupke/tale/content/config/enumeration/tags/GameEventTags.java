package io.schupke.tale.content.config.enumeration.tags;

/**
 * Enumeration of tags for all game log entries.
 *
 * @author jan.schupke@gmail.com
 */
public enum GameEventTags {
    // Global.
    GLOBAL_NEW_GAME("Starting new game"),

    // Forest.
    FOREST_EXPLORATION_EAST("Exploring forest east"),
    FOREST_EXPLORATION_NORTH("Exploring forest north"),
    FOREST_EXPLORATION_SOUTH("Exploring forest south"),

    FOREST_GENERAL_INITIAL_WALL_CONTACT("Colliding with the initial wall"),
    FOREST_GENERAL_INTRO_CONTACT("Receiving introduction text"),
    FOREST_GENERAL_ITEM_INTRO_CONTACT("Receiving item introduction text"),
    FOREST_GENERAL_QUEST_WALL_CONTACT("Colliding with the quest wall"),
    FOREST_GENERAL_UNIT_INTRO_CONTACT("Receiving unit introduction text"),

    FOREST_INTERACTION_CARAVAN_INVESTIGATE("Interacting with caravan"),
    FOREST_INTERACTION_COIN_INVESTIGATE("Interacting with coin"),
    FOREST_INTERACTION_UKKO_TALK("Interacting with Ukko"),
    FOREST_INTERACTION_UKKO_DELIVERY("Giving coin to Ukko"),
    FOREST_INTERACTION_UKKO_DISCUSS("Asking Ukko about his purpose"),

    FOREST_PICKUP_COIN("Picking up the coin"),

    FOREST_TRANSITION_OUTSKIRTS("Transitioning from forest to outskirts"),

    // Outskirts.
    OUTSKIRTS_EXPLORATION_CAVE("Exploring cave area"),
    OUTSKIRTS_EXPLORATION_JACK("Exploring Jack area"),
    OUTSKIRTS_EXPLORATION_VARPUNEN("Exploring varpunen area"),

    OUTSKIRTS_INTERACTION_CAVE_INVESTIGATE("Interacting with the cave"),
    OUTSKIRTS_INTERACTION_CRONE_TALK("Talking to crone"),
    OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_SHOW("Showing varpunen note to the crone"),
    OUTSKIRTS_INTERACTION_CRONE_VARPUNEN_GIVE("Giving varpunen note to the crone"),
    OUTSKIRTS_INTERACTION_CRONE_SHACK_INVESTIGATE("Interacting with crone's shack"),
    OUTSKIRTS_INTERACTION_JACK_HOUSE_INVESTIGATE("Interacting with Jack's house"),
    OUTSKIRTS_INTERACTION_JACK_TALK("Talking to Jack"),
    OUTSKIRTS_INTERACTION_JACK_DISPUTE_ACCEPT("Accepting Jack's dispute quest"),
    OUTSKIRTS_INTERACTION_JACK_DISPUTE_SOLVE("Finishing Jack's dispute quest"),
    OUTSKIRTS_INTERACTION_JACK_LUMBER_ACCEPT("Accepting Jack's lumber quest"),
    OUTSKIRTS_INTERACTION_JACK_LUMBER_GIVE("Finishing Jack's lumber quest"),
    OUTSKIRTS_INTERACTION_JACK_CRONE("Asking Jack about the crone"),
    OUTSKIRTS_INTERACTION_JACK_DISPUTE_REQUEST("Asking Jack about his book"),
    OUTSKIRTS_INTERACTION_JACK_LUMBER_REQUEST("Asking Jack about the lumber"),
    OUTSKIRTS_INTERACTION_JACK_FAIL("Telling Jack about the cave failure"),
    OUTSKIRTS_INTERACTION_LUMBER_INVESTIGATE("Interacting with lumber"),
    OUTSKIRTS_INTERACTION_ROAD_SIGN_INVESTIGATE("Interacting with the road sign"),
    OUTSKIRTS_INTERACTION_VARPUNEN_INVESTIGATE("Interacting with the varpunen note"),

    OUTSKIRTS_PICKUP_LUMBER("Picking up lumber"),
    OUTSKIRTS_PICKUP_VARPUNEN("Picking up varpunen note"),

    OUTSKIRTS_TRANSITION_CAVE("Entering the cave"),
    OUTSKIRTS_TRANSITION_FOREST("Entering forest from outskirts"),
    OUTSKIRTS_TRANSITION_SETTLEMENT("Entering the settlement from outskirts"),

    // Cave.
    CAVE_EXPLORATION_CORPSEC("Exploring Corpsec area"),

    CAVE_INTERACTION_CORPSEC_INVESTIGATE("Interacting with Corpsec"),
    CAVE_INTERACTION_CORPSEC_LOOT("Looting Corpsec"),
    CAVE_INTERACTION_CORPSEC_SEARCH("Searching Corpsec"),

    CAVE_INTERACTION_VILLE_TALK("Talking to Ville"),
    CAVE_INTERACTION_VILLE_AGGRO("Taking the book from Ville"),
    CAVE_INTERACTION_VILLE_INQUIRY("Asking Ville about the book"),
    CAVE_INTERACTION_VILLE_LEAVE("Leaving the book with Ville"),

    CAVE_TRANSITION_OUTSKIRTS("Exiting the cave"),

    // Settlement.
    SETTLEMENT_EXPLORATION_CHOBO("Exploring chobo area"),
    SETTLEMENT_EXPLORATION_DUNGEON("Exploring dungeon area"),

    SETTLEMENT_INTERACTION_CHOBO_HOUSE_INVESTIGATE("Interacting with Chobo house"),
    SETTLEMENT_INTERACTION_CHOBO_TALK("Talking to Chobo"),
    SETTLEMENT_INTERACTION_CHOBO_HOUSE("Asking Chobo about his house"),
    SETTLEMENT_INTERACTION_CHOBO_JOURNAL_GIVE("Giving journal to Chobo"),
    SETTLEMENT_INTERACTION_CHOBO_JOURNAL("Asking Chobo about the Journal"),
    SETTLEMENT_INTERACTION_CHOBO_KEY("Giving key to Chobo"),
    SETTLEMENT_INTERACTION_CHOBO_DUNGEON("Engaging in smalltalk with Chobo"),
    SETTLEMENT_INTERACTION_DUNGEON_INVESTIGATE("Interacting with the dungeon"),
    SETTLEMENT_INTERACTION_FARM_INVESTIGATE("Interacting with the farm"),
    SETTLEMENT_INTERACTION_FOUNTAIN_INVESTIGATE("Interacting with the fountain"),
    SETTLEMENT_INTERACTION_ROAD_SIGN_INVESTIGATE("Interacting with the road sign"),
    SETTLEMENT_INTERACTION_SMITH_HOUSE_INVESTIGATE("Interacting with smith's house"),
    SETTLEMENT_INTERACTION_SMITH_TALK("Talking to Pedro"),
    SETTLEMENT_INTERACTION_SMITH_ASSISTANCE("Offering assistance to Pedro"),
    SETTLEMENT_INTERACTION_SMITH_ACCEPT("Accepting the key quest from Pedro"),
    SETTLEMENT_INTERACTION_SMITH_RAMBLING("Engaging in smalltalk with Pedro"),
    SETTLEMENT_INTERACTION_TAVERN_INVESTIGATE("Interacting with tavern"),

    SETTLEMENT_TRANSITION_DUNGEON("Entering the dungeon"),
    SETTLEMENT_TRANSITION_OUTSKIRTS("Entering outskirts from the settlement"),

    // Dungeon.
    DUNGEON_EXPLORATION_STUDY("Exploring dungeon study room"),

    DUNGEON_INTERACTION_CHEST_INVESTIGATE("Interacting with the chest"),
    DUNGEON_INTERACTION_CHEST_COLLECT("Picking up the key from the chest"),
    DUNGEON_INTERACTION_CHEST_SEARCH("Searching the chest"),
    DUNGEON_INTERACTION_GATE_INVESTIGATE("Interacting with the gate"),
    DUNGEON_INTERACTION_GATE_OPEN("Unlocking the gate"),
    DUNGEON_INTERACTION_HARPSICHORD_INVESTIGATE("Interacting with the harpsichord"),
    DUNGEON_INTERACTION_HARPSICHORD_PLAY("Playing the harpsichord"),

    DUNGEON_TRANSITION_EXIT("Triggering the game exit"),
    DUNGEON_TRANSITION_SETTLEMENT("Entering the settlement from the dungeon"),

    DUNGEON_GENERAL_EXIT_WARNING("Receiving exit warning");

    private final String value;
    GameEventTags(String value) { this.value = value; }
    public String getValue() { return value; }
}
