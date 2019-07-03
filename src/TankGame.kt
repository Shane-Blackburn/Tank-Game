import kotlin.random.Random

fun main(args: Array<String>) {
    val alice = Tank(name = "Alice")
    val bill = Tank(name = "Bill")
    val charlie = Tank(name = "Charlie")

    var userTank: Tank? = alice
    var enemyTank: Tank? = bill
    var tanks = arrayListOf(alice, bill, charlie)
    var tanksAlive = 3

    loop@ while (tanksAlive > 1) {
        for (tank in tanks) {
            tank.currentTank()
        }

        println("Pick your tank:")
        val userInput = readLine()?.capitalize()

        when (userInput) {
            "Alice" -> userTank = alice
            "Bill" -> userTank = bill
            "Charlie" -> userTank = charlie
            else -> userTank = null
        }

        if (userTank == null) {
            println("That tank does not exist.")
            continue@loop
        }

        println("Fire at:")
        val enemyInput = readLine()?.capitalize()

        when (enemyInput) {
            "Alice" -> enemyTank = alice
            "Bill" -> enemyTank = bill
            "Charlie" -> enemyTank = charlie
            else -> enemyTank = null
        }

        if (enemyTank == null) {
            println("That tank does not exist.")
            continue@loop
        }

        if (userTank == enemyTank || userTank.ammo == 0) {
            println("You cannot do that.")
            continue@loop
        } else {
            userTank.fireAt(enemyTank)
        }

        var randomInt = Random.nextInt(0, 10)
        if (randomInt <= 6) {
            enemyTank.getHit()
        } else {
            println("That shot is a miss.")
            continue
        }

        if (! enemyTank.isAlive) {
            tanks.remove(enemyTank)
            tanksAlive --
        }

    }

}