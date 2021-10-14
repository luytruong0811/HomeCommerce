package com.example.homecommerce.model

/**
 * Created by pvduc9773 on 4/15/21.
 */
class MessageRoom(
    val message: Message? = null,
    val roomId: String? = null
)

class MessagesRoom(
    val data: List<Message>? = null,
    val roomId: String? = null
)