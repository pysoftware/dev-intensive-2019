package com.magere.dev_intensive.models

import com.magere.dev_intensive_2019.models.BaseMessage
import com.magere.dev_intensive_2019.models.User
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {
    override fun formatMessage(): String {
        TODO()
    }
}