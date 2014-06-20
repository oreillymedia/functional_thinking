// BEGIN scala_letter_grades
val VALID_GRADES = Set("A", "B", "C", "D", "F")

def letterGrade(value: Any) : String = value match {
  case x:Int if (90 to 100).contains(x) => "A"
  case x:Int if (80 to 90).contains(x) => "B"
  case x:Int if (70 to 80).contains(x) => "C"
  case x:Int if (60 to 70).contains(x) => "D"
  case x:Int if (0 to 60).contains(x) => "F"
  case x:String if VALID_GRADES(x.toUpperCase) => x.toUpperCase
}
// END scala_letter_grades

// BEGIN scala_letter_grade_test
printf("Amy scores %d and receives %s\n", 91, letterGrade(91))
printf("Bob scores %d and receives %s\n", 72, letterGrade(72))
printf("Sam never attened class, scored %d, and received %s\n", 
    44, letterGrade(44))
printf("Roy transfered and already had %s, which translated as %s\n", 
    "B", letterGrade("B"))
// END scala_letter_grade_test
