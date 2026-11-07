/**
 * Factory class responsible for instantiating different types of {@link Player} implementations for the game.
 * Constructs player instances configured to operate on boards
 * (such as the default 4x4 dimensions) based on string type identifiers.
 */
public class PlayerFactory {

    /**
     * Creates and returns a {@link Player} instance corresponding to the specified type string.
     * Converts the string to lower case and returns a new {@code HumanPlayer},{@code WhateverPlayer},
     * {@code CleverPlayer}, or {@code GeniusPlayer}, or {@code null} if the type is unrecognized.
     *
     * @param type the player type identifier (e.g., "human", "whatever", "clever", "genius")
     * @return the constructed {@link Player} instance,
     * or {@code null} if the specified type does not match any supported implementation
     */
    public Player buildPlayer (String type) {
        type = type.toLowerCase();
        Player player = null;
        switch (type) {
            case "human":
                player = new HumanPlayer();
                break;
            case "whatever":
                player = new WhateverPlayer();
                break;
            case "clever":
                player = new CleverPlayer();
                break;
            case "genius":
                player = new GeniusPlayer();
                break;
        }
        return player;
    }
}
