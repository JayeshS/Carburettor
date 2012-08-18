package org.js.carburettor.piece

import org.js.carburettor.board.Board
import org.junit.Before
import org.junit.Test
import static org.js.carburettor.piece.Colour.BLACK
import static org.js.carburettor.piece.Colour.WHITE

class BishopTest {

    private Board board
    private Bishop bishop;

    @Before
    void createBoard() {
        board = Board.createEmptyBoard()
    }

    @Test
    void canCreateNewBishop() {
        bishop = new Bishop(colour: WHITE)
        board.addAt 'b3', bishop
        assert bishop.position == board['B3']
    }

    @Test
    void shouldMoveDiagonally() {
        bishop = new Bishop(colour: WHITE)
        board.addAt 'b3', bishop
        List possibleMoves = bishop.getPossibleMoves()
        assert possibleMoves.containsAll([board['C4'], board['D5'], board['E6'], board['F7'], board['G8']])
        assert possibleMoves.containsAll([board['A2'], board['A4']])
        assert possibleMoves.containsAll([board['C2'], board['D1']])
        assert possibleMoves.size() == 9
    }

    @Test
    void shouldNotJumpOverAPiece() {
        bishop = new Bishop(colour: WHITE)
        board.addAt 'b3', bishop
        Pawn aPawn = new Pawn(colour: WHITE)
        board.addAt 'c4', aPawn
        List possibleMoves = bishop.getPossibleMoves()
        assert !possibleMoves.contains(board['C4'])
        assert !possibleMoves.contains(board['D5'])
        assert possibleMoves.containsAll([board['A2'], board['A4']])
        assert possibleMoves.containsAll([board['C2'], board['D1']])
        assert possibleMoves.size() == 4
    }

    @Test
    void shouldCaptureOpponentsPiece() {
        bishop = new Bishop(colour: WHITE)
        board.addAt 'b3', bishop
        Pawn opponentsPawn = new Pawn(colour: BLACK)
        board.addAt 'c4', opponentsPawn
        List possibleMoves = bishop.getPossibleMoves()
        assert possibleMoves.contains(board['C4'])
    }
}
