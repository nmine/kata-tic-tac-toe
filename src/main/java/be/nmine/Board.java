package be.nmine;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class Board {

    final Map<Position,Player> positions;

    public Board() {
        this.positions = new EnumMap<>(Position.class);
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
        return Arrays.stream(WinningPosition.ROW_TOP.getPositions()).allMatch(
               position ->  getPlayerForPosition(position) == player
        );
    }

    public boolean isColumnMiddleFill(Player player) {
        return getPlayerForPosition(Position.MIDDLE_LEFT) == player &&
                getPlayerForPosition(Position.MIDDLE_CENTER) == player &&
                getPlayerForPosition(Position.MIDDLE_RIGHT) == player;
    }
}
