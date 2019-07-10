package com.magere.dev_intensive.models

import com.magere.devintensive.models.BaseMessage
import com.magere.devintensive.models.User

class Chat(
    val id: String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}