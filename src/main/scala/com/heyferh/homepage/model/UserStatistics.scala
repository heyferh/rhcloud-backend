package com.heyferh.homepage.model

import java.time.LocalDateTime

/**
 * Created by ferh on 19/12/15.
 */
case class UserStatistics(
                           actions: Array[String],
                           startDate: LocalDateTime,
                           endDate: LocalDateTime
                           )
  extends java.io.Serializable
