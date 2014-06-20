package templates;

abstract class Customer {
    def plan
    
    def Customer() {
        plan = []
    }
    
    def abstract checkCredit()
    def abstract checkInventory()
    def abstract ship()
    
    def process() {
        checkCredit()
        checkInventory()
        ship()
    }
}