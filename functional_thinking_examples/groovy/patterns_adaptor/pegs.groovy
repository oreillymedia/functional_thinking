package pegs;

// BEGIN groovy_pegs
class SquarePeg {
    def width
}

class RoundPeg {
    def radius
}

class RoundHole {
    def radius

    def pegFits(peg) {
        peg.radius <= radius
    }

    String toString() { "RoundHole with radius $radius" }
}

class SquarePegAdapter {
    def peg

    def getRadius() {
        Math.sqrt(((peg.width/2) ** 2)*2)
    }

    String toString() {
        "SquarePegAdapter with peg width $peg.width "+ 
        "(and notional radius $radius)"
    }
}
// END groovy_pegs

def roundPegOf(squarePeg) {
    { p -> [getRadius:{Math.sqrt(
                ((p.width/2) ** 2)*2)}] as RoundThing
    }
}


