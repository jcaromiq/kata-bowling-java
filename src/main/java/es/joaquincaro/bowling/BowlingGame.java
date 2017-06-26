package es.joaquincaro.bowling;

/**
 * Created by joaco on 26/6/17.
 */
public class BowlingGame {
    private int score;

    public void throwBalls(int firstThrow, int secondThrow) {
        score = score + firstThrow + secondThrow;
    }

    public int getScore() {
        return score;
    }
}
