public class Tournament {
    private int rounds;
    private Renderer renderer;
    private Player player1;
    private Player player2;

    public Tournament (int rounds, Renderer renderer, Player player1, Player player2)
    {
        this.rounds = rounds;
        this.renderer = renderer;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playTournament (int size, int winStreak, String playerName1, String playerName2) {
        Player[] players = {this.player1, this.player2};
        int[] wins = {0, 0};
        int ties = 0;
        for (int i = 0; i < this.rounds; i++) {
            Game game = new Game(players[i % 2], players[(i + 1) % 2], size, winStreak, this.renderer);
            Mark mark = game.run();
            if (mark == Mark.BLANK) {
                ties++;
            }
            else if (mark == Mark.X) {
                    wins[i % 2]++;
            }
            else {
                wins[(i + 1) % 2]++;
            }
        }
        System.out.println("######### Results #########");
        System.out.println("Player 1, " +playerName1 + " won: " +wins[0] + " rounds");
        System.out.println("Player 2, " +playerName2 + " won: " +wins[1] + " rounds");
        System.out.println("Ties: " + ties);
    }

    public static void main (String[] args) {
        int rounds = Integer.parseInt(args[0]);
        int size = Integer.parseInt((args[1]));
        int winStreak = Integer.parseInt(args[2]);
        Renderer renderer;
        if (args[3].equalsIgnoreCase("console")) {
            renderer = new ConsoleRenderer(size);
        } else {
            renderer = new VoidRenderer();
        }
        Player player1 = new HumanPlayer();
        Player player2 = new HumanPlayer();
        if (args[4].equalsIgnoreCase("human")) {
            player1 = new HumanPlayer();
        }
        else if (args[4].equalsIgnoreCase("whatever")) {
            player1 = new WhateverPlayer();
        }
        else if (args[4].equalsIgnoreCase("clever")) {
            player1 = new CleverPlayer();
        }
        else if (args[4].equalsIgnoreCase("genius")) {
            player1 = new GeniusPlayer();
        }
        if (args[5].equalsIgnoreCase("human")) {
            player2 = new HumanPlayer();
        }
        else if (args[5].equalsIgnoreCase("whatever")) {
            player2 = new WhateverPlayer();
        }
        else if (args[5].equalsIgnoreCase("clever")) {
            player2 = new CleverPlayer();
        }
        else if (args[5].equalsIgnoreCase("genius")) {
            player2 = new GeniusPlayer();
        }
        Tournament tournament = new Tournament(rounds, renderer, player1, player2);
        tournament.playTournament(size, winStreak, args[4], args[5]);
    }
}
