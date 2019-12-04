package be.nmine;

import static be.nmine.Position.*;
import static be.nmine.Position.MIDDLE_CENTER;
import static be.nmine.Position.TOP_MIDLLE;

public enum Position {
    TOP_LEFT,TOP_MIDLLE,TOP_RIGHT,
    MIDDLE_LEFT,MIDDLE_CENTER, MIDDLE_RIGHT,
    BOTTOM_LEFT,BOTTOM_CENTER,BOTTOM_RIGHT
}

enum WinningPosition {

    ROW_TOP(new Position[] {TOP_LEFT, TOP_MIDLLE, TOP_RIGHT}),
    ROW_CENTER(new Position[] { MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT}),
    ROW_BOTTOM(new Position[] {BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT}),

    COLUMN_LEFT(new Position[] {TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT}),
    COLUMN_CENTER(new Position[] { TOP_MIDLLE, MIDDLE_RIGHT, BOTTOM_CENTER}),
    COLUMN_RIGHT(new Position[] {TOP_RIGHT, MIDDLE_CENTER, BOTTOM_RIGHT}),

    DIAGONNAL_ONE(new Position[] {TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT}),
    DIAGONNAL_TWO(new Position[] {BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT});

    private Position[] positions;

    private WinningPosition(Position[] positions)
    {
        this.positions = positions;
    }

    public Position[] getPositions() {
        return positions;
    }
}
