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
        int player1Wins = 0;
        int player2Wins = 0;
        int ties = 0;
        for (int i = 0; i < this.rounds; i++) {
            Game game;
            if (i % 2 == 0) {
                game = new Game(this.player1, this.player2, size, winStreak, this.renderer);
            }
            else {
                game = new Game(this.player2, this.player1, size, winStreak, this.renderer);
            }
            Mark mark = game.run();
            if (mark == Mark.BLANK) {
                ties++;
            }
            else if (mark == Mark.X) {
                if (i % 2 == 0) {
                    player1Wins++;
                }
                else {
                    player2Wins++;
                }
            }
            else {
                if (i % 2 == 0) {
                    player2Wins++;
                }
                else {
                    player1Wins++;
                }
            }
        }
        System.out.println("######### Results #########");
        System.out.println("Player 1, " +playerName1 + " won: " +player1Wins + " rounds");
        System.out.println("Player 2, " +playerName2 + " won: " +player2Wins + " rounds");
        System.out.println("Ties: " + ties);
    }

    public static void main (String[] args) {

    }

}
