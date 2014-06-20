package com.nealford.ft.errorhandling;

public class RomanNumeral {

    private static final String NUMERAL_MUST_BE_POSITIVE =
            "Value of RomanNumeral must be positive.";
    private static final String NUMERAL_MUST_BE_3999_OR_LESS =
            "Value of RomanNumeral must be 3999 or less.";
    private static final String DOES_NOT_DEFINE_A_ROMAN_NUMERAL =
            "An empty string does not define a Roman numeral.";
    private static final String NO_NEGATIVE_ROMAN_NUMERALS =
            "Negative numbers not allowed";
    private static final String NUMBER_FORMAT_EXCEPTION =
            "Illegal character in Roman numeral.";

    private final int num;

    private static int[] numbers = {1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1};
    private static String[] letters = {"M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"};


    public RomanNumeral(int arabic) {
        if (arabic < 1)
            throw new NumberFormatException(NUMERAL_MUST_BE_POSITIVE);
        if (arabic > 3999)
            throw new NumberFormatException(NUMERAL_MUST_BE_3999_OR_LESS);
        num = arabic;
    }


    public RomanNumeral(String roman) {
        if (roman.length() == 0)
            throw new NumberFormatException(DOES_NOT_DEFINE_A_ROMAN_NUMERAL);
        if (roman.charAt(0) == '-')
            throw new NumberFormatException(NO_NEGATIVE_ROMAN_NUMERALS);

        roman = roman.toUpperCase();

        int positionInString = 0;
        int arabicEquivalent = 0;

        while (positionInString < roman.length()) {
            char letter = roman.charAt(positionInString);
            int number = letterToNumber(letter);
            if (number < 0)
                throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION);
            positionInString++;
            if (positionInString == roman.length())
                arabicEquivalent += number;
            else {
                int nextNumber = letterToNumber(roman.charAt(positionInString));
                if (nextNumber > number) {
                    arabicEquivalent += (nextNumber - number);
                    positionInString++;
                } else
                    arabicEquivalent += number;
            }
        }

        if (arabicEquivalent > 3999)
            throw new NumberFormatException(NUMERAL_MUST_BE_3999_OR_LESS);
        num = arabicEquivalent;
    }

    private int letterToNumber(char letter) {
        switch (letter) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    public String toString() {
        String romanNumeral = "";
        int remainingPartToConvert = num;
        for (int i = 0; i < numbers.length; i++) {
            while (remainingPartToConvert >= numbers[i]) {
                romanNumeral += letters[i];
                remainingPartToConvert -= numbers[i];
            }
        }
        return romanNumeral;
    }

    public int toInt() {
        return num;
    }
}