package Chess.pieces;

import Boardgame.Board;
import Boardgame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            // Movimento simples para frente
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;

                // Movimento duplo inicial
                p.setValues(position.getRow() - 2, position.getColumn());
                Position p2 = new Position(position.getRow() - 1, position.getColumn());
                if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)
                        && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)
                        && getMoveCount() == 0) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }

            // Movimento diagonal esquerda (captura)
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Movimento diagonal direita (captura)
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Movimento especial: en passant
            if (position.getRow() == 3) {
                checkEnPassantLeft(mat, p);
                checkEnPassantRight(mat, p);
            }
        } else {
            // Para peões pretos
            // Movimento simples para frente
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;

                // Movimento duplo inicial
                p.setValues(position.getRow() + 2, position.getColumn());
                Position p2 = new Position(position.getRow() + 1, position.getColumn());
                if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)
                        && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)
                        && getMoveCount() == 0) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }

            // Movimento diagonal esquerda (captura)
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Movimento diagonal direita (captura)
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            // Movimento especial: en passant
            if (position.getRow() == 4) {
                checkEnPassantLeft(mat, p);
                checkEnPassantRight(mat, p);
            }
        }

        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }

    // Método auxiliar para verificar e marcar o movimento en passant à esquerda
    private void checkEnPassantLeft(boolean[][] mat, Position p) {
        Position left = new Position(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(left)
                && isThereOpponentPiece(left)
                && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
            mat[left.getRow() - 1][left.getColumn()] = true;
        }
    }

    // Método auxiliar para verificar e marcar o movimento en passant à direita
    private void checkEnPassantRight(boolean[][] mat, Position p) {
        Position right = new Position(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(right)
                && isThereOpponentPiece(right)
                && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
            mat[right.getRow() - 1][right.getColumn()] = true;
        }
    }

    // Método auxiliar para verificar se há uma peça adversária na posição especificada
    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != getColor();
    }
}
