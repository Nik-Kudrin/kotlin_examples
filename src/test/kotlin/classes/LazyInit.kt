package classes

class LazyInitExample {
    lateinit var someLazyInitializedVariable: String
    val town = lazy { lazyInit() }

    fun funWithInitialization() {
        someLazyInitializedVariable = "Some value"
    }

    fun checkInitializedVar() {
        if (::someLazyInitializedVariable.isInitialized) println(someLazyInitializedVariable)
    }

    fun lazyInit(): String {
        return ""
    }

}