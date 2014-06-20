import org.junit.Test
import org.junit.runner.JUnitCore
import static org.junit.Assert.*
import static junit.framework.Assert.*;
import static org.hamcrest.CoreMatchers.*
import static org.junit.matchers.JUnitMatchers.*
import pegs.*;

// BEGIN groovy_cubething
class CubeThing {
    def x, y, z
}
// END groovy_cubething

class PegsClosuresTest {

// BEGIN groovy_pegs_closure_test
static {
  SquarePeg.metaClass.getRadius = { -> 
    Math.sqrt(((delegate.width/2) ** 2)*2)
  }
}

@Test void expando_adapter() {
  def hole = new RoundHole(radius:4.0)
  (4..7).each { w ->
    def peg = new SquarePeg(width:w)
    if (w < 6)
      assertTrue hole.pegFits(peg)
    else
      assertFalse hole.pegFits(peg)
    }        
}
// END groovy_pegs_closure_test

// BEGIN groovy_dyn_adaptor    
def roundPegOf(squarePeg) {
  [getRadius:{Math.sqrt(
        ((squarePeg.width/2) ** 2)*2)}] as RoundThing
    
}

@Test void functional_adaptor() {
  def hole = new RoundHole(radius:4.0)
  (4..7).each { w ->
    def peg = roundPegOf(new SquarePeg(width:w))
    if (w < 6)
      assertTrue hole.pegFits(peg)
    else
      assertFalse hole.pegFits(peg)
  }
}
// END groovy_dyn_adaptor

// BEGIN groovy_all_functional
def pegFits(peg, hole) {
    Math.sqrt(((peg.width/2) ** 2)*2) <= hole.radius
}

@Test void functional_all_the_way() {
    def hole = new RoundHole(radius:4.0)
    (4..7).each { w ->
        def peg = new SquarePeg(width:w)
         if (w < 6)
            assertTrue pegFits(peg, hole)
        else
            assertFalse pegFits(peg, hole)
    }
}
// END groovy_all_functional    

// BEGIN groovy_func_comp
def asSquare(peg) {
  [getWidth:{peg.x}] as SquarePeg
}

def asRound(peg) {
  [getRadius:{Math.sqrt(
       ((peg.width/2) ** 2)*2)}] as RoundThing
}
// END groovy_func_comp    

    @Test void functional_composition() {
        def hole = new RoundHole(radius:4.0)
        (4..7).each { w ->
            def cube = new CubeThing(x:w)
             if (w < 6)
                assertTrue pegFits(asSquare(cube), hole)
            else
                assertFalse pegFits(asSquare(cube), hole)
        }
    }

// BEGIN groovy_func_comp_test
@Test 
void mixed_functional_composition() {
    def hole = new RoundHole(radius:4.0)
    (4..7).each { w ->
        def cube = new CubeThing(x:w)
         if (w < 6)
            assertTrue hole.pegFits(asRound(asSquare(cube)))
        else
            assertFalse hole.pegFits(asRound(asSquare(cube)))
    }

}
// END groovy_func_comp_test

}

JUnitCore.main('PegsClosuresTest')
