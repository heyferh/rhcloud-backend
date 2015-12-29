package com.heyferh

import akka.actor.{ActorSystem, Props}
import com.heyferh.homepage.actors.Saver
import com.heyferh.homepage.service.HomePageService
import de.raysha.lib.telegram.bot.api.TelegramBot
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Configuration, Bean, DependsOn}

/**
 * Created by feku on 12/29/2015.
 */
@Configuration
class Main {

  @Value("${solyankaBot}")
  private val solyankaToken:String = null

  @Value("${notificationBot}")
  private val notificationToken:String = null

  @Autowired
  private val homePageService: HomePageService = null

  @Bean(name = Array("actorSystem"))
  def actorSystem() = ActorSystem("myApp")

  @Bean
  @DependsOn(Array("actorSystem"))
  def saverActor() = actorSystem actorOf Props(new Saver(homePageService))

  @Bean
  def solyankaBot() = new TelegramBot("171170089:AAFBCSDZS0X97zsh7K5iBPm7YstUxeO0ZUE")

  @Bean
  def notificationBot() = new TelegramBot("170883236:AAFuwdbCoz2ETT35Hgo89OYQ-xHYg_zzSvc")
}


