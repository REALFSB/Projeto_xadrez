package Chess;

public enum Color {
    BLACK("Black"),
    WHITE("White");

    private final String displayName;

    // Construtor privado para associar um nome legível a cada cor
    private Color(String displayName) {
        this.displayName = displayName;
    }

    // Método para obter o nome legível da cor
    public String getDisplayName() {
        return displayName;
    }

    // Método para obter a cor oposta
    public Color getOpposite() {
        return this == BLACK ? WHITE : BLACK;
    }
}
