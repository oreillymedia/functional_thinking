import com.nealford.ft.allaboutlists.NumberClassification
import com.nealford.ft.allaboutlists.NumberClassifier
import org.junit.Test
import com.nealford.ft.allaboutlists.LazyList
import static junit.framework.Assert.assertEquals
import static com.nealford.ft.allaboutlists.NumberClassifier.nextPerfectNumberAfter
import static org.junit.Assert.assertTrue

/**
 * (probably) Copyright 2011 by Neal Ford. All rights reserved.
 */
class AllAboutListsTest {
// BEGIN groovy_lazy_list
def prepend(val, closure) { new LazyList(val, closure) }

def integers(n) { prepend(n, { integers(n + 1) }) }

@Test
public void lazy_list_acts_like_a_list() {
    def naturalNumbers = integers(1)
    assertEquals('1 2 3 4 5 6 7 8 9 10', naturalNumbers.getHead(10).join(' '))
    def evenNumbers = naturalNumbers.filter { it % 2 == 0 }
    assertEquals('2 4 6 8 10 12 14 16 18 20', evenNumbers.getHead(10).join(' '))
}
// END groovy_lazy_list

    @Test
    public void can_find_next_perfect_number() {
        assertTrue 6 == nextPerfectNumberAfter(1)
        assertTrue 28 == nextPerfectNumberAfter(6+1)
        assertTrue 496 == nextPerfectNumberAfter(28+1)
    }

// BEGIN groovy_infinite_perfect
   def perfectNumbers(n) { prepend(n, 
      { perfectNumbers(nextPerfectNumberAfter(n)) }) };

    @Test
    public void infinite_perfect_number_sequence() {
        def perfectNumbers = perfectNumbers(nextPerfectNumberAfter(1))
        assertEquals([6, 28, 496], perfectNumbers.getHead(3))
    }
// END groovy_infinite_perfect

  @Test
  public void terse_classify() {
    [1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 
              16, 17, 19, 21, 22, 23, 25, 26, 27].each {i ->
      assertTrue(NumberClassifier.classify(i) == NumberClassification.DEFICIENT)
    }
    [
    12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60, 66, 70, 72, 78, 80, 84, 88, 90, 96, 100, 102].each {i ->
      assertTrue(NumberClassifier.classify(i) == NumberClassification.ABUNDANT)
    }
    [6, 28, 496].each {i ->
      assertTrue(NumberClassifier.classify(i) == NumberClassification.PERFECT)
    }
  }
}
