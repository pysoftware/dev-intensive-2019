package com.magere.dev_intensive.models

import com.magere.devintensive.models.BaseMessage
import com.magere.devintensive.models.User
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