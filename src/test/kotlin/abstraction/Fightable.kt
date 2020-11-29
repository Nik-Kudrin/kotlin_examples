package abstraction

import io.kotest.core.spec.style.FunSpec

interface Fightable {
    var healthPoints: Int

    fun attack(opponent: Fightable): Int
    fun default() {
        println("Default realization")
    }
}

class Creature(override var healthPoints: Int) : Fightable {
    override fun attack(opponent: Fightable): Int {
        return healthPoints - 1
    }
}

class InterfacesTest : FunSpec({
    test("Check interface features") {
        val creature = Creature(10)
        creature.healthPoints
        creature.attack(creature)
        creature.default()
    }
})