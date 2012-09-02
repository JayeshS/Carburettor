package org.js.carburettor.board

import org.junit.Test
import org.js.carburettor.piece.*
import static org.js.carburettor.piece.Colour.BLACK
import static org.js.carburettor.piece.Colour.WHITE

class BoardTest {

    @Test
    void getShouldReturnCorrectSquareForGivenRankAndFile() {
        Board board = Board.createEmptyBoard()
        Square x = board['b2']
        assert x.file == 'b'
        assert x.rank == 2
    }

    @Test
    void shouldDetectWhenASquareIsControlledByAPawn() {
        Board board = Board.createEmptyBoard()
        board.addAt 'a2', new Pawn(colour: WHITE)
        assert board['a2'].piece.sphereOfInfluence.contains(board['b3'])
        assert board.isSquareControlledBy(board['b3'], WHITE)
    }

    @Test
    void shouldDetectWhenASquareIsControlledByABishop() {
        Board board = Board.createEmptyBoard()
        board.addAt 'a2', new Bishop(colour: WHITE)
        assert board['a2'].piece.sphereOfInfluence.contains(board['c4'])
        assert board.isSquareControlledBy(board['c4'], WHITE)
    }

    @Test
    void shouldSetupBoardForNewGame() {
        Board board = Board.setupNewGame()
        assertIsInInitialPosition(board)
    }

    @Test
    void canSetupBoardForANewGameFromFenString() {
        Board board = Board.setup("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1")
        assertIsInInitialPosition(board)
    }

    @Test
    void canSetupBoardForAMiddleGamePositionFromFenString() {
        Board board = Board.setup("5rkr/1p2Qpbp/pq1P4/2nB4/5p2/2N5/PPP4P/1K1RR3 w - - 0 1")
        assertPieceAt('c3', WHITE, Knight.class, board)
        assertPieceAt('g7', BLACK, Bishop.class, board)
        assertPieceAt('e7', WHITE, Queen.class, board)
    }

    void assertIsInInitialPosition(Board board) {
        assertPieceAt('a1', WHITE, Rook.class, board)
        assertPieceAt('b1', WHITE, Knight.class, board)
        assertPieceAt('c1', WHITE, Bishop.class, board)
        assertPieceAt('d1', WHITE, Queen.class, board)
        assertPieceAt('e1', WHITE, King.class, board)
        assertPieceAt('f1', WHITE, Bishop.class, board)
        assertPieceAt('g1', WHITE, Knight.class, board)
        assertPieceAt('h1', WHITE, Rook.class, board)
        assertAllPawnsOnRank(2, WHITE, board)

        assertPieceAt('a8', BLACK, Rook.class, board)
        assertPieceAt('b8', BLACK, Knight.class, board)
        assertPieceAt('c8', BLACK, Bishop.class, board)
        assertPieceAt('d8', BLACK, Queen.class, board)
        assertPieceAt('e8', BLACK, King.class, board)
        assertPieceAt('f8', BLACK, Bishop.class, board)
        assertPieceAt('g8', BLACK, Knight.class, board)
        assertPieceAt('h8', BLACK, Rook.class, board)
        assertAllPawnsOnRank(7, BLACK, board)
    }


    void assertAllPawnsOnRank(Integer rank, Colour colour, Board board) {
        ('a'..'h').each {file ->
            assertPieceAt(file + rank.toString(), colour, Pawn.class, board)
        }
    }

    void assertPieceAt(String square, Colour colour, Class<? extends Piece> pieceClass, Board board) {
        Piece expectedPiece = pieceClass.newInstance()
        expectedPiece.position = new Square(file: square[0], rank: square[1].toInteger())
        expectedPiece.colour = colour
        assert board[square].piece == expectedPiece
    }

}
