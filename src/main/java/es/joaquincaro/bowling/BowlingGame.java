package es.joaquincaro.bowling;

import java.util.ArrayList;
import java.util.List;


public class BowlingGame {
    private List<Round> rounds = new ArrayList<>();
    private int currentRound = 0;
    private int score;

    public void throwBalls(int firstThrow, int secondThrow) {
        validateInputs(firstThrow, secondThrow);

        Round round = new Round(firstThrow,secondThrow);
        if(wasPreviousRoundStrike()) {
            score = 10 + round.getScore() + round.getScore();
        }else if(wasPreviousRoundSpare()) {
            score = 10 + firstThrow + round.getScore();
        } else {
            score += round.getScore();
        }

        rounds.add(round);
        currentRound++;

    }
    private boolean wasPreviousRoundStrike() {
        return (rounds.size()>0
                && rounds.get(currentRound-1).isStrike());
    }

    private boolean wasPreviousRoundSpare() {
        return (rounds.size()>0
                && rounds.get(currentRound-1).isSpare());
    }

    private void validateInputs(int firstThrow, int secondThrow) {
        if(firstThrow + secondThrow > 10){
            throw new IllegalArgumentException();
        }
    }



    public int getScore() {
        return score;
    }

    private class Round {
        private final int firstThrow;
        private final int secondThrow;

        public Round(int firstThrow, int secondThrow) {
            this.firstThrow = firstThrow;
            this.secondThrow = secondThrow;
        }


        public int getScore() {
            return firstThrow + secondThrow;
        }

        public boolean isStrike() {
            return (firstThrow == 10 || secondThrow == 10);
        }

        public boolean isSpare() {
            return (score == 10);
        }
    }
}
