fun main(args: Array<String>) {
    val variables = Variables()
    variables.doAction()

    checkIfElseConditions()
    println(checkInRange(19))

    switchExample("")
    switchExample("ololo")
    switchExample("=======")

    // string template
    var str = "Some string template ${checkInRange(8888)}"
    println(str)
}