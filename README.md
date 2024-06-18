# Projeto de Xadrez em Java

Este é um projeto desenvolvido em Java que implementa um jogo de xadrez com suporte para interação via terminal. O projeto é estruturado em várias pastas e classes para organizar e modularizar as funcionalidades do jogo.

## Estrutura de Pastas e Classes

- **Boardgame:**
  - **Board:** Classe responsável por representar o tabuleiro de xadrez.
  - **BoardException:** Exceção personalizada para erros relacionados ao tabuleiro.
  - **Piece:** Classe abstrata que representa uma peça no jogo de xadrez.
  - **Position:** Classe que representa uma posição no tabuleiro.
- **Chess:**
  - **ChessException:** Exceção personalizada para erros específicos do jogo de xadrez.
  - **ChessMath:** Classe auxiliar para cálculos matemáticos relacionados ao xadrez.
  - **ChessPiece:** Classe abstrata que estende Piece, representando uma peça de xadrez.
  - **ChessPosition:** Classe que representa uma posição no tabuleiro de xadrez usando notação alfanumérica (por exemplo, "a1", "h8").
  - **Color:** Enumeração que define as cores das peças de xadrez (Branco e Preto).
- **pieces:**
    - **Bishop:** Classe que representa a peça Bispo.
  - **King:** Classe que representa a peça Rei.
  - **Knight:** Classe que representa a peça Cavalo.
  - **Pawn:** Classe que representa a peça Peão.
  - **Queen:** Classe que representa a peça Rainha.
  - **Rook:** Classe que representa a peça Torre.
- **Application:**
  - **Main.java:** Arquivo principal que inicia o jogo de xadrez.
  - **UI:** Design do Xadrez no Terminal: Implementação para fornecer uma interface simples no terminal para interação com o jogo.

## Funcionalidades Implementadas

- **Movimentação de Peças:** Implementação das regras de movimentação para todas as peças do xadrez, respeitando as regras do jogo.

- **Verificação de Cheque e Xeque-Mate:** Lógica para verificar se o rei está em xeque e se há xeque-mate.

- **Promoção de Peão:** Implementação da regra que permite a promoção de um peão ao alcançar a última fileira do tabuleiro adversário.

- **Histórico de Jogadas:** Capacidade de registrar e exibir o histórico de jogadas realizadas durante a partida.

## Como Executar
1. **Clone o repositório:**
    - `git clone https://github.com/REALFSB/Projeto_xadrez.git` 
2. **Entre na pasta:**
    - `cd Projeto_xadrez`
3. **Compile as classes Java:**
    - `javac *.java`
4. **Execute o arquivo principal:**
    - `java Main`