# Jogo de Xadrez no Java
Este Projeto foi desenvolvido usando conceitos da orientação ao objeto para criar o jogo de xadrez.

## Como executar

Para executar é necessário ter o JDK instalado na máquina.
Basta baixar os arquivos do projeto e executá-lo no arquivo Program.java

` git clone https://github.com/TeuszMAN/xadrezProject-java.git `

Será iniciado a partida no terminal (necessário um terminal que suporte coloração para diferenciar peças e jogadas possíveis)

## Definição dos arquivos
 ### Pasta application: camada mais alta, carrega a inteface e chama os comandos do jogo.
- Program.java : Roda os comando e interação com o usuário.
- UI.java : Monta o tabuleiro graficamente no terminal

### Pasta boardgame: gerencia as regras do tabuleiro de maneira desconectada
- Board.java : Regras de criação do tabuleiro e suas limitações.
- BoardException.java : Classe de exceção caso seja infrigida alguma limitação.
- Piece : Classe que trata as peças de maneira abstrata se relacionando com o tabuleiro.
- Position : Objeto para definir onde a Piece se encontra no Board.

### Pasta chess : Onde são criadas classes que herdam o boardgame e realmente definem como xadrez o game.
- Pasta pieces : Carrega as classes das peças de xadrez (elas estendem da classe ChessPiece), com seus movimentos e regras de jogo.
- ChessMatch : Classe onde é atribuido todas as funções de uma partida específica de xadrez.
- ChessPiece : Classe que herda a classe Piece para transforma uma peça em uma peça de xadrez.
- ChessPosition : Converte as siglas de tabuleiro do xadrez para movimento, controlando a posição no board.
- ChessException : Classe de exceção de xadrez.
- Color : classe enum para definir jogador preto e branco.

__Esse projeto foi desenvolvido através do curso de Java Completo do professor Nélio Alves através da plataforma Udemy, deixo meu apreço por escrever linha por linha compreendendo a lógica incrível através das resoluções e desacoplamento dos itens como benefício de um bom projeto de POO__
