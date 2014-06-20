// BEGIN simple_closure_intro
class Employee {
  def name, salary
}

def paidMore(amount) {
  return {Employee e -> e.salary > amount}
}

isHighPaid = paidMore(100000)
// END simple_closure_intro

// BEGIN simple_closure_demo
def Smithers = new Employee(name:"Fred", salary:120000)
def Homer = new Employee(name:"Homer", salary:80000)
println isHighPaid(Smithers)
println isHighPaid(Homer)
// true, false
// END simple_closure_demo

// BEGIN simple_closure_addition
isHigherPaid = paidMore(200000)
println isHigherPaid(Smithers)
println isHigherPaid(Homer)
def Burns = new Employee(name:"Monty", salary:1000000)
println isHigherPaid(Burns)
// false, false, true
// END simple_closure_addition


def paidCorrectly() {
  return {emp, policy -> emp.salary <= policy.maxSalary}
}

class Policy {
  def maxSalary
}

def review = paidCorrectly()
def p = new Policy(maxSalary: 90_000)
println("policy\n================")
println review(Smithers, p)
