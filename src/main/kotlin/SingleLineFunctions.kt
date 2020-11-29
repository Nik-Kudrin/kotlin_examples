import java.lang.reflect.Type

public fun singleLineFunction() = (Math.PI * 33).toString();

public fun notImplementedFunction(): String {
    TODO("Implement bla bla")
}

public fun notImplementedFunction(another: String): Nothing = throw NotImplementedError("Implement with parameter")