package com.heyferh.homepage.model

import java.time.LocalDateTime

/**
 * Created by feku on 12/25/2015.
 */
case class Message(
                    senderName: String,
                    senderEmail: String,
                    text: String,
                    date: LocalDateTime = LocalDateTime now
                    )
  extends Serializable {
  override def toString =
    "Message from heyferh.com:\n" +
      "Name: " + senderName + "\n" +
      "Email: " + senderEmail + "\n" +
      "Message: " + text + "\n" +
      "Date: " + date
}