// constant value
const val CONST_EXAMPLE: Long = 999_454_344;

class Variables {
    var intVar: Int = 3; // mutable
    var stringVar = ""; // type inference from String
    val READ_ONLY_VAR: Double = 23.3; // immutable

    init {
        println("Variables class init block")
    }

    fun doAction() {
        var var1 = "***";
        var var2 = var1;
        var1 = "XXX";
        println(var1)
        println(var2)

        println(READ_ONLY_VAR)
        println(CONST_EXAMPLE)
    }
}