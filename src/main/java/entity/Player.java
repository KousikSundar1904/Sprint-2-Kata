package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {


    String playerName;
    int score;
    List<Integer> scoreList = new ArrayList<>();

    public Player(String playerName) {
        this.playerName = playerName;
        this.scoreList.add(0);
    }

}
