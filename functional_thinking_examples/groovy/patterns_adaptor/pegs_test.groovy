import org.junit.Test
import org.junit.runner.JUnitCore
import static org.junit.Assert.*
import static junit.framework.Assert.*;
import static org.hamcrest.CoreMatchers.*
import static org.junit.matchers.JUnitMatchers.*
import pegs.*;

class PegsTest {
// BEGIN groovy_pegs_test  
@Test void pegs_and_holes() {
  def hole = new RoundHole(radius:4.0)
  (4..7).each { w ->
    def peg = new SquarePegAdapter(peg:new SquarePeg(width:w))
  if (w < 6 )
    assertTrue hole.pegFits(peg)
  else
    assertFalse hole.pegFits(peg)
  }        
}
// END groovy_pegs_test
    
    @Test void pegs_with_inherited_adaptor() {
        def hole = new RoundHole(radius:4.0)
        (4..7).each { w ->
            def peg = new SquarePegAdapterUsingInheritance(width:w)
            if (w < 6)
                assertTrue hole.pegFits(peg)
            else
                assertFalse hole.pegFits(peg)
        }
    }
}

JUnitCore.main('PegsTest')
