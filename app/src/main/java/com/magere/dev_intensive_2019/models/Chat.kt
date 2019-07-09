package com.magere.dev_intensive.models

import com.magere.dev_intensive_2019.models.BaseMessage
import com.magere.dev_intensive_2019.models.User

class Chat(
    val id: String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}