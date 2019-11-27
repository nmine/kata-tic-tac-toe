package be.nmine;

import java.util.HashMap;
import java.util.Map;

public class Game {

    Player currentPlayer;
    Map<Position,Player> positions = new HashMap<>();

    public Game() {
        this.currentPlayer = Player.O;
    }

    public void play(Position position) {
        if(isPositionAlreadyTaken(position))
            throw new IllegalStateException();
        this.currentPlayer = this.currentPlayer.equals(Player.X) ? Player.O : Player.X;
        positions.put(position,currentPlayer);
    }

    private boolean isPositionAlreadyTaken(Position position) {
        return positions.keySet().stream().filter(position1 -> position1 == position).findFirst().isPresent();
    }

    public Player lastPlay() {
        return currentPlayer;
    }

    public boolean isWon() {
        return true;
    }

    public Player getPlayerForPosition(Position position) {
        return positions.entrySet().stream()
                .filter(positionStringEntry -> positionStringEntry.getKey() == position)
                .findFirst()
                .get().getValue();
    }

    public boolean isTopRowFillByXPlayer() {
        return false;
    }
}
