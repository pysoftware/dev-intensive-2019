package com.magere.devintensive.models

import com.magere.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {
    companion object {
        var lastId = -1
        fun makeUser(fullName: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(
                id = "$lastId",
                firstName = firstName,
                lastName = lastName,
                avatar = "",
                rating = 1,
                respect = 1,
                lastVisit = Date(),
                isOnline = true
            )
        }
    }
}