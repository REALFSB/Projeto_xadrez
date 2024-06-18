package Boardgame;

public class Position {

    private int row;
    private int column;

    // Construtor que inicializa a posição com linha e coluna
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Métodos getter para obter os valores de linha e coluna
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    // Método para definir os valores de linha e coluna
    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // Sobrescrevendo o método toString para uma representação legível da posição
    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    // Método para comparar duas posições
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return row == position.row && column == position.column;
    }

    // Método para gerar o código hash da posição
    @Override
    public int hashCode() {
        int result = Integer.hashCode(row);
        result = 31 * result + Integer.hashCode(column);
        return result;
    }
}
