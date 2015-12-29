package com.heyferh.homepage.actors

import akka.actor.Actor
import com.heyferh.homepage.model.{Message, UserStatistics}
import com.heyferh.homepage.service.HomePageService

/**
 * Created by feku on 12/28/2015.
 */
class Saver(val homePageService: HomePageService) extends Actor {

  override def receive: Receive = {
    case stats: UserStatistics => homePageService saveUserStatistics stats
    case msg: Message => homePageService saveSentMessage msg
  }
}
