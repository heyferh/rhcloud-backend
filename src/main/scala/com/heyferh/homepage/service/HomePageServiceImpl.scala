package com.heyferh.homepage.service

import com.heyferh.homepage.model.{Message, UserStatistics}
import com.heyferh.homepage.repository.{MessagesRepository, UserStatisticsRepository}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by feku on 12/24/2015.
 */
@Service
class HomePageServiceImpl extends HomePageService {
  @Autowired
  val userStatisticsRepository: UserStatisticsRepository = null

  @Autowired
  val messagesRepository: MessagesRepository = null

  def saveUserStatistics(stats: UserStatistics) = userStatisticsRepository save stats

  override def saveSentMessage(message: Message) = messagesRepository save message
}
