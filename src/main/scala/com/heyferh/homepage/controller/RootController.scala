package com.heyferh.homepage.controller

import java.time._

import akka.actor.ActorRef
import com.heyferh.homepage.model.{Message, UserStatistics}
import de.raysha.lib.telegram.bot.api.BotAPI
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

/**
 * Created by feku on 12/4/2015.
 */
@Controller
@RequestMapping(Array("/"))
class RootController {

  @Value("${myTelegramID}")
  private val myTelegramID: Integer = null

  @Autowired
  private val saverActor: ActorRef = null

  @Autowired
  private val notificationBot: BotAPI = null

  @CrossOrigin(origins = Array("http://heyferh.com"))
  @ResponseBody
  @RequestMapping(value = Array("heyferh/message"), method = Array(RequestMethod.POST))
  def sendMessage(@RequestParam(value = "messageText", required = false) text: String,
                  @RequestParam(value = "name", required = false) name: String,
                  @RequestParam(value = "email", required = false) email: String) = {
    saverActor ! Message(name, email, text)
    notificationBot.sendMessage(myTelegramID, Message(name, email, text).toString)
    "success"
  }

  @CrossOrigin(origins = Array("http://heyferh.com"))
  @RequestMapping(value = Array("heyferh/storeStats"), method = Array(RequestMethod.POST))
  def saveStatistics(@RequestParam(value = "actions[]", required = false) actions: Array[String],
                     @RequestParam(value = "startTimeStamp") startTimeStamp: Long) = {
    saverActor ! UserStatistics
    (
      actions,
      LocalDateTime.ofInstant(Instant.ofEpochMilli(startTimeStamp), ZoneId.of("Europe/Moscow")),
      LocalDateTime.now(ZoneId.of("Europe/Moscow"))
      )
  }

  @ResponseBody
  @RequestMapping(method = Array(RequestMethod.GET))
  def ping() = {
    "pong"
  }
}