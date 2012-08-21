package org.js.carburettor.piece

import org.js.carburettor.board.Board
import org.junit.Before
import org.junit.Test

class KnightTest {

    private Board board
    private Knight knight

    @Before
    void setupBoard() {
        board = Board.createEmptyBoard()
    }

    @Test
    void canCreateAKnight() {
        knight = new Knight(colour: Colour.WHITE)
        board.addAt 'e4', knight
        assert knight.position == board['e4']
        assert knight.position.piece == knight
    }

    @Test
    void shouldMoveInAnLShape() {
        knight = new Knight(colour: Colour.WHITE)
        board.addAt 'e4', knight
        assert knight.possibleMoves.size() == 8
        assert knight.possibleMoves.containsAll([board['f6'], board['d6'], board['c5'], board['c3'], board['d2'],
                board['f2'], board['g5'], board['g3']])
    }

    @Test
    void shouldCaptureOpponentsPiece() {
        knight = new Knight(colour: Colour.WHITE)
        board.addAt 'e4', knight

        Pawn blackPawn = new Pawn(colour: Colour.BLACK)
        board.addAt 'g5', blackPawn

        assert knight.possibleMoves.contains(board['g5'])
    }

    @Test
    void canNotCaptureOwnPiece() {
        knight = new Knight(colour: Colour.WHITE)
        board.addAt 'e4', knight

        Pawn ownPawn = new Pawn(colour: Colour.WHITE)
        board.addAt 'g5', ownPawn

        assert !knight.possibleMoves.contains(board['g5'])
    }
}
