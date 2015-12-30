package com.heyferh

import akka.actor.{ActorSystem, Props}
import com.heyferh.homepage.actors.Saver
import com.heyferh.homepage.repository.{MessagesRepository, UserStatisticsRepository}
import de.raysha.lib.telegram.bot.api.TelegramBot
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.context.annotation.{Bean, Configuration, DependsOn}

/**
 * Created by feku on 12/29/2015.
 */
@Configuration
class Main {

  @Value("${solyankaBot}")
  private val solyankaToken: String = null

  @Value("${notificationBot}")
  private val notificationToken: String = null

  @Autowired
  private val messageRepository: MessagesRepository = null

  @Autowired
  private val userStatisticsRepository: UserStatisticsRepository = null

  @Bean(name = Array("actorSystem"))
  def actorSystem() = ActorSystem("myApp")

  @Bean
  @DependsOn(Array("actorSystem"))
  def saverActor() = actorSystem actorOf Props(new Saver(messageRepository, userStatisticsRepository))

  @Bean
  def solyankaBot() = new TelegramBot(solyankaToken)

  @Bean
  def notificationBot() = new TelegramBot(notificationToken)
}


