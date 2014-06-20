import groovy.util.GroovyTestCase

// BEGIN groovy_camelize
class TestStringCategory extends GroovyTestCase {
    static {
        String.metaClass.camelize = { ->
            def newName = delegate.split("_").collect() { 
                it.substring(0, 1).toUpperCase() +  
                it.substring(1, it.length())
            }.join()
            newName.substring(0, 1).toLowerCase() + 
                newName.substring(1, newName.length())      
        }
    }
    
    def expected = [event_map : "eventMap", 
            name : "name", test_date : "testDate", 
            test_string_with_breaks : "testStringWithBreaks" ]

    void test_Camelize() {
        expected.each { key, value ->
            assertEquals value, key.camelize()
        }
    }    
}
// END groovy_camelize
