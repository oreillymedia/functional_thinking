package templates;

class CustomerBlocks {
    def plan, checkCredit, checkInventory, ship
    
    def CustomerBlocks() {
        plan = []
    }
    
    def process() {
        checkCredit()
        checkInventory()
        ship()
    }
}