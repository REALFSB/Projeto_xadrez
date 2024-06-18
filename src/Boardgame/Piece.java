package Boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    // Construtor da classe Piece que inicializa a peça com um tabuleiro associado
    public Piece(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null.");
        }
        this.board = board;
        this.position = null; // posição inicial é nula
    }

    // Método protegido para obter o tabuleiro associado à peça
    protected Board getBoard() {
        return board;
    }

    // Método abstrato que deve ser implementado pelas subclasses para definir os movimentos possíveis da peça
    public abstract boolean[][] possibleMoves();

    // Método para verificar se um movimento específico é possível
    public boolean possibleMove(Position position) {
        if (position == null || !board.positionExists(position)) {
            throw new IllegalArgumentException("Position is invalid.");
        }
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    // Método para verificar se existe pelo menos um movimento possível para a peça
    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
