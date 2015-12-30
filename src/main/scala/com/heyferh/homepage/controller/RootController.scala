package com.heyferh.homepage.controller

import java.time._

import com.heyferh.homepage.model.{Message, UserStatistics}
import com.heyferh.homepage.service.{HomePageService, NotificationService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

/**
 * Created by feku on 12/4/2015.
 */
@Controller
@RequestMapping(Array("/"))
class RootController {

  @Autowired
  private val notificationService: NotificationService = null

  @Autowired
  private val homePageService: HomePageService = null

  @CrossOrigin(origins = Array("http://heyferh.com"))
  @ResponseBody
  @RequestMapping(value = Array("heyferh/message"), method = Array(RequestMethod.POST))
  def sendMessage(@RequestParam(value = "messageText", required = false) text: String,
                  @RequestParam(value = "name", required = false) name: String,
                  @RequestParam(value = "email", required = false) email: String) = {
    notificationService sendMessage Message(name, email, text)
    "success"
  }

  @CrossOrigin(origins = Array("http://heyferh.com"))
  @RequestMapping(value = Array("heyferh/storeStats"), method = Array(RequestMethod.POST))
  def saveStatistics(@RequestParam(value = "actions[]", required = false) actions: Array[String],
                     @RequestParam(value = "startTimeStamp") startTimeStamp: Long) = {
    homePageService saveUserStatistics UserStatistics(
      actions,
      LocalDateTime.ofInstant(Instant.ofEpochMilli(startTimeStamp), ZoneId.systemDefault()),
      LocalDateTime now
    )
  }

  @ResponseBody
  @RequestMapping(method = Array(RequestMethod.GET))
  def ping() = {
    "pong"
  }
}