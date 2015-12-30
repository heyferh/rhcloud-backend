package com.heyferh.homepage.actors

import akka.actor.Actor
import com.heyferh.homepage.model.{Message, UserStatistics}
import com.heyferh.homepage.repository.{MessagesRepository, UserStatisticsRepository}

/**
 * Created by feku on 12/28/2015.
 */
class Saver(val messageRepository: MessagesRepository,
            val userStatisticsRepository: UserStatisticsRepository) extends Actor {

  override def receive: Receive = {
    case stats: UserStatistics => userStatisticsRepository save stats
    case msg: Message => messageRepository save msg
  }
}
