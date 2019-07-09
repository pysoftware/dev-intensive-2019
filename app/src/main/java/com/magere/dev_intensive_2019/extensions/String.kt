package com.magere.dev_intensive_2019.extensions

fun String.stripHtml(): String {
   return this.replace(Regex("[&<.*>'\"/]"), "")
}

fun String.truncate(): String {
   return ""
}