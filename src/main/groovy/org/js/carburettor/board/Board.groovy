package org.js.carburettor.board

import org.js.carburettor.piece.*

@SuppressWarnings("GroovyAssignabilityCheck")
class Board {

    private static final Map<Character, Class<Piece>> PIECE_FOR_FEN = [
            'k':King.class,
            'q':Queen.class,
            'b':Bishop.class,
            'n':Knight.class,
            'r':Rook.class,
            'p':Pawn.class
    ]

    private List<Square> allSquares = []

    static Board create(String fen) {
        Board board = new Board()
        String[] fields = fen.split(' ')
        assert fields.length == 6

        String squareData = fields[0]
        String[] ranks = squareData.split('/')
        Integer currentRank = 8
        ranks.each {String rankData ->
            String currentFile = 'a'
            rankData.toCharArray().each {
                if (it.isLetter()) {
                    add(it, board, currentFile, currentRank)
                    currentFile++
                }
                if (it.isDigit()) {
                    Integer.valueOf(it.toString()).times {currentFile++}
                }
            }
            currentRank--
        }
        return board

    }

    private static def add(char it, Board board, String currentFile, int currentRank) {
        Piece piece = PIECE_FOR_FEN[it.toString().toLowerCase()].newInstance()
        piece.colour = it.isUpperCase() ? Colour.WHITE : Colour.BLACK
        board.addAt(currentFile + currentRank, piece)
    }


    static Board setupNewGame() {
        Board board = new Board()
        board.addAt(['a1', 'h1'], {new Rook(colour: Colour.WHITE)})
        board.addAt(['b1', 'g1'], {new Knight(colour: Colour.WHITE)})
        board.addAt(['c1', 'f1'], {new Bishop(colour: Colour.WHITE)})
        board.addAt(['d1'], {new Queen(colour: Colour.WHITE)})
        board.addAt(['e1'], {new King(colour: Colour.WHITE)})

        List allSquaresOnSecondRank = ('a'..'h').collect {it + '2'}
        board.addAt(allSquaresOnSecondRank, {new Pawn(colour: Colour.WHITE)})

        board.addAt(['a8', 'h8'], {new Rook(colour: Colour.BLACK)})
        board.addAt(['b8', 'g8'], {new Knight(colour: Colour.BLACK)})
        board.addAt(['c8', 'f8'], {new Bishop(colour: Colour.BLACK)})
        board.addAt(['d8'], {new Queen(colour: Colour.BLACK)})
        board.addAt(['e8'], {new King(colour: Colour.BLACK)})

        List allSquaresOnSeventhRank = ('a'..'h').collect {it + '7'}
        board.addAt(allSquaresOnSeventhRank, {new Pawn(colour: Colour.BLACK)})

        return board
    }

    private Board() {
        ('a'..'h').each {file ->
            (1..8).each {rank ->
                allSquares << new Square(file: file, rank: rank, board: this)
            }
        }
    }


    private Square get(String file, int rank) {
        return allSquares.find {
            it.rank == rank && it.file.equalsIgnoreCase(file)
        }
    }

    def getAt(String square) {
        assert square.length() == 2
        get(square[0], Integer.valueOf(square[1]))
    }

    def addAt(String square, Piece piece) {
        piece.position = this[square]
        piece.board = this
    }

    boolean isSquareControlledBy(Square square, Colour colour) {
        allSquares.find {
            !it.isEmpty() &&
                    (it.piece.colour == colour) &&
                    it.piece.sphereOfInfluence?.contains(square)
        }
    }

    def addAt(List<Square> squares, Closure pieceCreator) {
        squares.each {square ->
            this.addAt(square, pieceCreator.call())
        }
    }

    static Board createEmptyBoard() {
        return new Board()
    }
}
