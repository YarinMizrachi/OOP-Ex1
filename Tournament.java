/**
 * Manages and executes a multi-round Tic-Tac-Toe tournament between two specified players.
 * Tracks the number of wins for each player and ties,
 * alternating the starting player (who plays as Mark.X) each round.
 */
public class Tournament {
    private int rounds;
    private Renderer renderer;
    private Player player1;
    private Player player2;

    /**
     * Constructs a Tournament instance with the specified number of rounds, display method, and competitors.
     *
     * @param rounds the total number of game rounds to be played
     * @param renderer the {@link Renderer} used to display the board state
     * @param player1 the first {@link Player} participating in the tournament
     * @param player2 the second {@link Player} participating in the tournament
     */
    public Tournament (int rounds, Renderer renderer, Player player1, Player player2)
    {
        this.rounds = rounds;
        this.renderer = renderer;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Runs the tournament for the predefined number of rounds and prints the final statistics to the console.
     * Alternates the starting player each round (even rounds: player 1 starts, odd rounds: player 2 starts).
     *
     * @param size the grid dimension (size x size) for the game boards
     * @param winStreak the number of consecutive marks required to win a single game
     * @param playerName1 the display name of the first player for the final results output
     * @param playerName2 the display name of the second player for the final results output
     */
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
        System.out.println("Player 1, " +playerName1 +
                " won: " +wins[0] + " rounds");
        System.out.println("Player 2, " +playerName2 +
                " won: " +wins[1] + " rounds");
        System.out.println("Ties: " + ties);
    }

    /**
     * The main entry point of the program that parses 6 command-line arguments
     * to set up and run the tournament.
     * Expects arguments in the exact order: rounds, board size, win streak,
     * renderer type, player 1 type, player 2 type.
     *
     * @param args command-line arguments used to configure the tournament parameters and factories
     */
    public static void main (String[] args) {
        int rounds = Integer.parseInt(args[0]);
        int size = Integer.parseInt((args[1]));
        int winStreak = Integer.parseInt(args[2]);
        Renderer renderer = new RendererFactory().buildRenderer(args[3], size);
        Player player1 = new PlayerFactory().buildPlayer(args[4]);
        Player player2 = new PlayerFactory().buildPlayer(args[5]);
        Tournament tournament = new Tournament(rounds, renderer, player1, player2);
        tournament.playTournament(size, winStreak, args[4], args[5]);
    }
}
