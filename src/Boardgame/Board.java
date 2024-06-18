package Boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    // Construtor da classe Board que inicializa a matriz de peças com o tamanho fornecido
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    // Métodos getter para obter o número de linhas e colunas do tabuleiro
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    // Método para obter uma peça na posição especificada por linha e coluna
    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board.");
        }
        return pieces[row][column];
    }

    // Método para obter uma peça na posição especificada por um objeto Position
    public Piece piece(Position position) {
        if (position == null || !positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    // Método para colocar uma peça em uma posição especificada
    public void placePiece(Piece piece, Position position) {
        if (piece == null) {
            throw new IllegalArgumentException("Piece cannot be null.");
        }
        if (position == null || !positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    // Método para remover uma peça de uma posição especificada
    public Piece removePiece(Position position) {
        if (position == null || !positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        Piece removedPiece = piece(position);
        if (removedPiece == null) {
            return null;
        }
        pieces[position.getRow()][position.getColumn()] = null;
        removedPiece.position = null;
        return removedPiece;
    }

    // Método privado para verificar se uma posição (linha e coluna) existe no tabuleiro
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    // Método público para verificar se uma posição (objeto Position) existe no tabuleiro
    public boolean positionExists(Position position) {
        if (position == null) {
            return false;
        }
        return positionExists(position.getRow(), position.getColumn());
    }

    // Método para verificar se existe uma peça em uma posição especificada
    public boolean thereIsAPiece(Position position) {
        if (position == null || !positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        return piece(position) != null;
    }
}
