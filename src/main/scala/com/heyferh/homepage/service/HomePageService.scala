package com.heyferh.homepage.service

import com.heyferh.homepage.model.{Message, UserStatistics}

/**
 * Created by ferh on 19/12/15.
 */

trait HomePageService {
  def saveUserStatistics(stats: UserStatistics)

  def saveSentMessage(message: Message)

  def allUserStats(): Seq[UserStatistics]

  def allMessages(): Seq[Message]
}