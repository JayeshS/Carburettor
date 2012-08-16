package org.js.carburettor.board

class BoardTraversal {

    def nextFile() {
        return {it.next()}
    }

    def previousFile() {
        return {it.previous()}
    }

    def nextRank() {
        return {it + 1}
    }

    def previousRank() {
        return {it - 1}
    }
}
