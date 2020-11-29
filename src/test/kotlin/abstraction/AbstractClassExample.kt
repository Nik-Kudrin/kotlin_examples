package abstraction

import io.kotest.core.spec.style.FunSpec

abstract class AbstractClassExample(override var healthPoints: Int) : Fightable {
    abstract fun doStuff()
}

class RealClass : AbstractClassExample(10) {
    override fun doStuff() {
        TODO("Not yet implemented")
    }

    override fun attack(opponent: Fightable): Int {
        return -1
    }
}

class AbstractClassTests : FunSpec({
    test("Abstract class tests") {
        var instance = RealClass()
        instance.attack(Creature(30))
    }
})