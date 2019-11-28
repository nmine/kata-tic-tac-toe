package be.nmine;

public class Game {

    Player currentPlayer;
    final Board board;

    public Game() {
        this.board = new Board();
        this.currentPlayer = Player.O;
    }

    public void play(Position position) {
        if(isPositionAlreadyTaken(position))
            throw new IllegalStateException();
        this.currentPlayer = this.currentPlayer.equals(Player.X) ? Player.O : Player.X;
        board.setPosition(position,currentPlayer);
    }

    private boolean isPositionAlreadyTaken(Position position) {
        return board.isPositionAlreadyTaken(position);
    }

    public Player lastPlay() {
        return currentPlayer;
    }

    public boolean isWon() {
        return board.isTopRowFill(currentPlayer) || board.isColumnMiddleFill(currentPlayer);
    }

    public Player getPlayerForPosition(Position position) {
        return board.getPlayerForPosition(position);

    }

}
