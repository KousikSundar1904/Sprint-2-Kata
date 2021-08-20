package entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Match {
    private Player player1;
    private Player player2;
    private Player winner;
    private boolean gameOver;
    private boolean isNewGame;
    private boolean tieBreakRule;


    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }


    public void addScore(Player player) {
        player.setScore(player.getScore() + 1);
        int score1 = this.player1.getScore();
        int score2 = this.player2.getScore();
        this.player1.getScoreList().add(score1);
        this.player2.getScoreList().add(score2);
        if (!tieBreakRule) {
            if (score1 >= 6 && score2 <= 4) {
                this.winner = this.player1;
            } else if (score2 >= 6 && score1 <= 4) {
                this.winner = this.player2;
            } else if ((score1 >= 6 || score2 >= 6) && (score1 - score2 == 1 || score2 - score1 == 1)) {
                isNewGame = true;
                this.player1.setScoreList(new ArrayList<>());
                this.player1.setScore(0);
                this.player2.setScoreList(new ArrayList<>());
                this.player2.setScore(0);
            } else if (score1 == 6 && score2 == 6) {
                this.tieBreakRule = true;
            }
        } else {
            if (score1 - 6 == 0 && score1 - score2 >= 2) {
                this.winner = this.player1;
            } else if (score2 - 6 == 0 && score2 - score1 >= 2) {
                this.winner = this.player2;
            }
        }
    }


    public void printPoint() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.player1.getPlayerName());
        builder.append("\t");
        this.player1.getScoreList().forEach(data -> {
            builder.append(data).append("\t");
        });
        builder.append("\n");

        builder.append(this.player2.getPlayerName());
        builder.append("\t");
        this.player2.getScoreList().forEach(data -> {
            builder.append(data).append("\t");
        });
        System.out.println(builder);
    }
}
