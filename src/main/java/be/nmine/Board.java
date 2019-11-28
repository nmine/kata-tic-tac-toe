package be.nmine;

import java.util.HashMap;
import java.util.Map;

public class Board {

    final Map<Position,Player> positions;

    public Board() {
        this.positions = new HashMap<>();
    }

    protected boolean isPositionAlreadyTaken(Position position) {
        return positions.keySet().stream().filter(position1 -> position1 == position).findFirst().isPresent();
    }

    public void setPosition(Position position, Player player) {
        positions.put(position,player);
    }

    public Player getPlayerForPosition(Position position) {
        return positions.entrySet().stream()
                .filter(positionStringEntry -> positionStringEntry.getKey() == position)
                .findFirst()
                .get().getValue();
    }

    public boolean isTopRowFill(Player player) {
        return getPlayerForPosition(Position.TOP_LEFT) == player &&
                getPlayerForPosition(Position.TOP_MIDLLE) == player &&
                getPlayerForPosition(Position.TOP_RIGHT) == player;
    }

    public boolean isColumnMiddleFill(Player player) {
        return getPlayerForPosition(Position.MIDDLE_LEFT) == player &&
                getPlayerForPosition(Position.MIDDLE_CENTER) == player &&
                getPlayerForPosition(Position.MIDDLE_RIGHT) == player;
    }
}
