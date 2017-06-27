package es.joaquincaro.kata.bowling;

import java.util.ArrayList;
import java.util.List;


public class BowlingGame {
    private List<Round> rounds = new ArrayList<>();
    private int currentRound;
    private int score;

    public void throwBalls(int firstThrow, int secondThrow) {
        Round round = Round.aNew(firstThrow,secondThrow);
        if(wasPreviousRoundStrike()) {
            score = 10 + round.getPinsThrowed() + round.getPinsThrowed();
        }else if(wasPreviousRoundSpare()) {
            score = 10 + firstThrow + round.getPinsThrowed();
        } else {
            score += round.getPinsThrowed();
        }
        saveRound(round);
    }

    private void saveRound(Round round) {
        rounds.add(round);
        currentRound++;
    }

    public int getScore() {
        return score;
    }

    private boolean wasPreviousRoundStrike() {
        return (!rounds.isEmpty()
                && rounds.get(currentRound-1).isStrike());
    }

    private boolean wasPreviousRoundSpare() {
        return (!rounds.isEmpty()
                && rounds.get(currentRound-1).isSpare());
    }
    

    private static class Round {
        private final int firstThrow;
        private final int secondThrow;

        private Round(int firstThrow, int secondThrow) {
            this.firstThrow = firstThrow;
            this.secondThrow = secondThrow;
        }


        public int getPinsThrowed() {
            return firstThrow + secondThrow;
        }

        public boolean isStrike() {
            return (firstThrow == 10 || secondThrow == 10);
        }

        public boolean isSpare() {
            return (getPinsThrowed() == 10 && !isStrike());
        }

        public static Round aNew(int firstThrow, int secondThrow) {
            Round round = new Round(firstThrow, secondThrow);
            round.validate();
            return round;
        }

        private void validate() {
            if(getPinsThrowed() > 10){
                throw new IllegalArgumentException();
            }
        }
    }
}
