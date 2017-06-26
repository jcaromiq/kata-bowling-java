import es.joaquincaro.bowling.BowlingGame;
import org.junit.Before;
import org.junit.Test;

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
        bowlingGame.throwBalls(0,0);

        assertThat(bowlingGame.getScore(),is(0));

    }

    @Test
    public void return_1_when_the_first_ball_drop_1_pin_and_second_ball_fails() throws Exception {
        bowlingGame.throwBalls(1,0);

        assertThat(bowlingGame.getScore(),is(1));
    }

    @Test
    public void return_2_when_the_first_ball_fails_and_the_second_ball_drop_2_pins() throws Exception {
        bowlingGame.throwBalls(0,2);

        assertThat(bowlingGame.getScore(),is(2));
    }

    @Test
    public void return_10_when_fhe_first_round_drop_4_and_second_drop_6() throws Exception {
        bowlingGame.throwBalls(1,3);
        bowlingGame.throwBalls(0,6);

        assertThat(bowlingGame.getScore(),is(10));
    }

    
}
