package com.heyferh.homepage.service

import akka.actor.ActorRef
import com.heyferh.homepage.model.{Message, UserStatistics}
import com.heyferh.homepage.repository.{MessagesRepository, UserStatisticsRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.collection.JavaConversions._

/**
 * Created by feku on 12/24/2015.
 */
@Service
class HomePageServiceImpl extends HomePageService {

  @Autowired
  val saverActor: ActorRef = null

  @Autowired
  val userStatisticsRepository: UserStatisticsRepository = null

  @Autowired
  val messagesRepository: MessagesRepository = null

  override def saveUserStatistics(stats: UserStatistics) = saverActor ! stats

  override def saveSentMessage(message: Message) = messagesRepository save message

  override def allUserStats() = userStatisticsRepository findAll

  override def allMessages() = messagesRepository findAll
}
