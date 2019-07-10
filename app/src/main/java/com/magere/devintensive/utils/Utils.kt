package com.magere.devintensive.utils

object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val pairs = fullName?.split(" ")
        if (fullName?.trim() == "")
            return null to null
        return (pairs?.getOrNull(0) ?: "null") to (pairs?.getOrNull(1) ?: "null")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if (firstName?.trim() == "" && lastName?.trim() == "" ||
            firstName.equals(null) && lastName.equals(null)
        )
            return null
        val a = firstName?.getOrNull(0) ?: ""
        val b = lastName?.getOrNull(0) ?: ""

        return "$a$b".toUpperCase()
    }

    fun transliteration(fullName: String?, devider: String? = ""): String? {

        return ""
    }

}