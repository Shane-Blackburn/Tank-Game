class Tank(val name: String, var health: Int = 60, var ammo: Int = 5, var isAlive: Boolean = true) {

    // Current tank
    fun currentTank() {
        if (isAlive == true) {
            println("$name is alive and has $health HP and $ammo Shells.")
        } else {
            print("$name is dead.")
        }
    }


    // Fire Projectile
    fun fireAt(enemy: Tank) {
        if (ammo >= 1) {
            ammo --
            println("$name fires on ${enemy.name}.")
        } else
            println("$name has no ammo.")
    }


    // Take a hit
    fun getHit() {
        health -= 20
        if (health <= 0) {
            explode()
        } else {
            println("$name takes a direct hit and now has $health HP")
        }
    }


    // Explode
    fun explode() {
        isAlive = false
        println("$name explodes.")
    }

}

