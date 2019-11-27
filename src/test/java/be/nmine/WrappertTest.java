package be.nmine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static be.nmine.Position.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WrappertTest {

    @Test
    void first_player_is_alway_x(){
        //Given
        Game game = new Game();
        //When
        game.play(TOP_LEFT);
        //Then
        assertThat(game.lastPlay()).isEqualTo(Player.X);
    }

    @Test
    void two_player_can_play(){
        //Given
        Game game = new Game();
        //When
        game.play(TOP_LEFT);
        game.play(TOP_RIGHT);
        //Then
        assertThat(game.lastPlay()).isEqualTo(Player.O);
    }

    @Test
    void player_cannot_play_on_played_position(){
        //Given
        Game game = new Game();
        //When
        game.play(TOP_LEFT);
        //Then
        Assertions.assertThrows(IllegalStateException.class, () -> game.play(TOP_LEFT));
    }

    @Test
    void can_find_player_position(){
        //Given
        Game game = new Game();
        //When
        playerXplay(game);
        //Then
        assertThat(game.getPlayerForPosition(TOP_LEFT)).isEqualTo(Player.X);
    }

    @Test
    void player_X_fill_top_row_should(){
        //Given
        Game game = new Game();
        //When
        playerXFillTopRow(game);
        //Then
        assertThat(game.getPlayerForPosition(TOP_LEFT)).isEqualTo(Player.X);
    }

    private void playerXplay(Game game) {
        game.play(TOP_LEFT);
    }

    @Test
    void player_X_play_to_left_should(){
        //Given
        Game game = new Game();
        //When
        playerXFillTopRow(game);
        //Then
        assertThat(game.isWon()).isEqualTo(true);
    }

    private void playerXFillTopRow(Game game) {
        game.play(TOP_LEFT);
        game.play(MIDDLE_LEFT);
        game.play(TOP_RIGHT);
        game.play(MIDDLE_RIGHT);
        game.play(TOP_MIDLLE);
    }

}
