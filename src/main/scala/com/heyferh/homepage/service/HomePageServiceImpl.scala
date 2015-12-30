package com.heyferh.homepage.service

import akka.actor.ActorRef
import com.heyferh.homepage.model.UserStatistics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by feku on 12/24/2015.
 */
@Service
class HomePageServiceImpl @Autowired()(saverActor: ActorRef) extends HomePageService {

  override def saveUserStatistics(stats: UserStatistics) = saverActor ! stats
}
