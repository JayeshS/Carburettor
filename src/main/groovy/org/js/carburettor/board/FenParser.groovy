package org.js.carburettor.board

import org.js.carburettor.piece.Colour
import org.js.carburettor.piece.Piece
import org.js.carburettor.piece.Pawn
import org.js.carburettor.piece.Rook
import org.js.carburettor.piece.Knight
import org.js.carburettor.piece.Bishop
import org.js.carburettor.piece.Queen
import org.js.carburettor.piece.King

class FenParser {

    private static final Map<String, Class<? extends Piece>> FEN_PIECE_SYMBOLS = [
            'k':King.class,
            'q':Queen.class,
            'b':Bishop.class,
            'n':Knight.class,
            'r':Rook.class,
            'p':Pawn.class
    ]

    FenParser(String fen, Board board) {
        String[] fields = fen.split(' ')
        assert fields.length == 6

        String squareData = fields[0]
        String[] ranks = squareData.split('/')
        assert ranks.length == 8

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
    }

    private def add(char pieceSymbol, Board board, String currentFile, int currentRank) {
        Piece piece = FEN_PIECE_SYMBOLS[pieceSymbol.toString().toLowerCase()].newInstance()
        piece.colour = pieceSymbol.isUpperCase() ? Colour.WHITE : Colour.BLACK
        board.addAt(currentFile + currentRank, piece)
    }

}
