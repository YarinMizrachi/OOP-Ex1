public class PlayerFactory {

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
