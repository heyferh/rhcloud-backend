package com.heyferh.homepage.model

/**
 * Created by feku on 12/25/2015.
 */
case class Message(
                    senderName: String = "Empty name field",
                    senderEmail: String = "Empty email field",
                    text: String = "Empty text field"
                    )
  extends Serializable {
  override def toString = "Message from heyferh.com:\n" +
    "Name: " + senderName + "\n" +
    "Email: " + senderEmail + "\n" +
    "Message: " + text
}