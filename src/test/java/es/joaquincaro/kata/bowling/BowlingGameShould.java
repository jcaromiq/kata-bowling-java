package es.joaquincaro.kata.bowling;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameShould {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame();
     }

    @Test
    public void return_0_when_no_pins_touched_in_a_row() throws Exception {
        playRound(0, 0);

        scoreIs(0);
    }

    @Test
    public void return_1_when_the_first_ball_drop_1_pin_and_second_ball_fails() throws Exception {
        playRound(1, 0);

        scoreIs(1);
    }

    @Test
    public void return_2_when_the_first_ball_fails_and_the_second_ball_drop_2_pins() throws Exception {
        playRound(0, 2);

        scoreIs(2);
    }

    @Test
    public void return_10_when_fhe_first_round_drop_4_and_second_drop_6() throws Exception {
        playRound(1, 3);
        playRound(0, 6);

        scoreIs(10);
    }

    @Test(expected =IllegalArgumentException.class)
    public void throw_exception_if_round_score_is_greater_than_ten() throws Exception {
        playRound(10, 1);
    }

    @Test
    public void return_22_when_strike_and_drop_6_in_next_round() throws Exception {
        playRound(10, 0);
        playRound(6, 0);

        scoreIs(22);
    }

    @Test
    public void return_20_when_spare_and_drop_6_in_next_round() throws Exception {
        playRound(7, 3);
        playRound(4, 2);

        scoreIs(20);
    }

    @Test
    @Ignore
    public void return_300_in_a_perfect_game() throws Exception {
        IntStream.range(1,12)
                .forEach(x-> bowlingGame.throwBalls(10,0));

        scoreIs(300);
    }

    private void playRound(int firstThrow, int secondThrow) {
        bowlingGame.throwBalls(firstThrow, secondThrow);
    }

    private void scoreIs(int score) {
        assertThat(bowlingGame.getScore(),is(score));
    }
}
