import scala.compat.Platform;

// BEGIN scala_process
val employees = List("neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan", 
         "liam", "mason", "noah", "lucas", "jacob", "jayden", "jack")

val result = employees
  .filter(_.length() > 1)
  .map(_.capitalize)
  .reduce(_ + "," + _)
// END scala_process
println("Process:" + result)

// BEGIN scala_process_parallel
val parallelResult = employees
  .par
  .filter(_.length() > 1)
  .map(_.capitalize)
  .reduce(_ + "," + _)
// END scala_process_parallel
println("Parallel:" + parallelResult)

println("\nBoundary:\n================")
val bresult = List("")
   .filter(_.length() > 1)
   .map(_.capitalize)

println("Boundary:" + bresult)


