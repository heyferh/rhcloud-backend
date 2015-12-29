package com.heyferh.obed.scheduler

import com.heyferh.obed.model.Meal
import de.raysha.lib.telegram.bot.api.BotAPI
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

import scala.util.Random

/**
 * Created by feku on 12/3/2015.
 */
@Component
class ObedScheduler {

  @Value("${freeMeeTeamChatID}")
  private val freeMeeTeamChatID: Integer = null

  @Autowired
  val solyankaBot: BotAPI = null

  @Scheduled(cron = "0 50 13 * * MON-FRI", zone = "Europe/Moscow")
  def obedReminder(): Unit = {
    val randomMealIndex = Random.nextInt(Meal.values.size)
    solyankaBot.sendMessage(freeMeeTeamChatID, "Ну что? Как насчет " + Meal(randomMealIndex) + "?")
  }
}
