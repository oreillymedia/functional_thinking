package com.nealford.ft.adaptor;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdaptorTest {

// BEGIN java_square_peg_test
@Test
public void square_pegs_in_round_holes() {
    RoundHole hole = new RoundHole(4.0);
    Circularity peg;
    for (int i = 3; i <= 10; i++) {
        peg = new SquarePegAdaptor(new SquarePeg(i));
        if (i < 6)
            assertTrue(hole.pegFits(peg));
        else
            assertFalse(hole.pegFits(peg));
    }
}
// END java_square_peg_test
}
