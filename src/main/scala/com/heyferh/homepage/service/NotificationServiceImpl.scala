package com.heyferh.homepage.service

import akka.actor.ActorRef
import com.heyferh.homepage.model.Message
import de.raysha.lib.telegram.bot.api.BotAPI
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.stereotype.Service

/**
 * Created by feku on 12/30/2015.
 */
@Service
class NotificationServiceImpl extends NotificationService {

  @Autowired
  private val saverActor: ActorRef = null

  @Value("${myTelegramID}")
  private val myTelegramID: Integer = null

  @Autowired
  private val notificationBot: BotAPI = null

  override def sendMessage(msg: Message) = {
    saverActor ! msg
    notificationBot.sendMessage(myTelegramID, msg toString)
  }
}
