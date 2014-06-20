package com.nealford.ft.errorhandling;

import fj.P1;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class EitherTest {
    private static final String INVALID_ROMAN_NUMERAL = "Invalid Roman numeral";

// BEGIN java_divide_test
@Test
public void maps_success() {
    Map<String, Object> result = RomanNumeralParser.divide(4, 2);
    assertEquals(2.0, (Double) result.get("answer"), 0.1);
}

@Test
public void maps_failure() {
    Map<String, Object> result = RomanNumeralParser.divide(4, 0);
    assertEquals("div by zero", ((Exception) result.get("exception")).getMessage());
}
// END java_divide_test


    @Test
    public void either_left() {
        final String[] result = new String[1];
        Either<String,Integer> e = Either.left("foo");
        e.fold(
                new F<String>() {
                    public void f(String x) {
                        result[0] = x;
                    }
                },
                new F<Integer>() {
                    public void f(Integer x) {
                        result[0] = "Integer: " + x;
                    }
                });
        assertEquals(result[0], "foo");
    }

    @Test
    public void either_right() {
        final String[] result = new String[1];
        Either<String,Integer> e = Either.right(4);
        e.fold(
                new F<String>() {
                    public void f(String x) {
                        result[0] = x;
                    }
                },
                new F<Integer>() {
                    public void f(Integer x) {
                        result[0] = "Integer: " + x;
                    }
                });
        assertEquals(result[0], "Integer: 4");
    }

// BEGIN java_romans_parsing_test
@Test
public void parsing_success() {
    Either<Exception, Integer> result = RomanNumeralParser.parseNumber("XLII");
    assertEquals(Integer.valueOf(42), result.right());
}

@Test
public void parsing_failure() {
    Either<Exception, Integer> result = RomanNumeralParser.parseNumber("FOO");
    assertEquals(INVALID_ROMAN_NUMERAL, result.left().getMessage());
}
// END java_romans_parsing_test

// BEGIN java_romans_parse_lazy_test
@Test
public void parse_lazy() {
    P1<Either<Exception, Integer>> result = 
            RomanNumeralParser.parseNumberLazy("XLII");
    assertEquals(42, result._1().right().intValue());
}

@Test
public void parse_lazy_exception() {
    P1<Either<Exception, Integer>> result = 
            RomanNumeralParser.parseNumberLazy("FOO");
    assertTrue(result._1().isLeft());
    assertEquals(INVALID_ROMAN_NUMERAL, result._1().left().getMessage());
}
// END java_romans_parse_lazy_test

// BEGIN java_romans_defaults_test
@Test
public void parse_defaults_normal() {
    Either<Exception, Integer> result = 
        RomanNumeralParser.parseNumberDefaults("XLII");
    assertEquals(42, result.right().intValue());
}
@Test
public void parse_defaults_triggered() {
    Either<Exception, Integer> result = 
        RomanNumeralParser.parseNumberDefaults("MM");
    assertEquals(1000, result.right().intValue());
}
// END java_romans_defaults_test
}
