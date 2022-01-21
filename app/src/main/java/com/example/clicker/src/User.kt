package com.example.clicker.src

import android.widget.Toast
import java.lang.Exception

class User {
    var power: Int = 1
    var gold: Int = 0
    var increaser: Int = 10
    var sourcePicture: String = "https://avatars.githubusercontent.com/u/56396954?v=4"

    public fun increaseGold() {
        gold += power
    }

    public fun increasePower():Boolean {
        if (gold > 1 * increaser) {
            power += 1
            gold -= 1 * increaser
            increaser += 1
            return true
        } else{
            return false
        }
    }
}