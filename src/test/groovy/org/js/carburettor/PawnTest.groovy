package org.js.carburettor

import org.junit.Test
import org.js.carburettor.piece.Pawn
import static org.js.carburettor.Colour.*
import org.js.carburettor.piece.IllegalMoveException

class PawnTest {

    private Pawn whitePawn;

    @Test
    void canCreateNewPawn() {
        whitePawn = new Pawn(WHITE, Squares.A2);

        assert whitePawn.position == Squares.A2
        assert whitePawn.colour == WHITE
    }

    @Test
    void canMovePawnFromA2ToA3() {
        whitePawn = new Pawn(WHITE, Squares.A2);
        whitePawn.move(Squares.A3)
        assert whitePawn.position == Squares.A3
    }

    @Test
    void canMovePawnFromA2ToA4() {
        whitePawn = new Pawn(WHITE, Squares.A2);
        whitePawn.move(Squares.A4)
        assert whitePawn.position == Squares.A4
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnFromA3ToA5() {
        whitePawn = new Pawn(WHITE, Squares.A3);
        whitePawn.move(Squares.A5)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnBackwards() {
        whitePawn = new Pawn(WHITE, Squares.A3);
        whitePawn.move(Squares.A2)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotTakeOnTheSameFile() {
        whitePawn = new Pawn(WHITE, Squares.A2);
        Pawn blackPawn = new Pawn(BLACK, Squares.A3);
        whitePawn.move(Squares.A3)
    }
}
