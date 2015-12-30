package com.heyferh.homepage.service

import com.heyferh.homepage.model.Message

/**
 * Created by feku on 12/30/2015.
 */
trait NotificationService {
  def sendMessage(msg: Message)
}