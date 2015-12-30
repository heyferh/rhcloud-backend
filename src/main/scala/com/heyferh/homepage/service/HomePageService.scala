package com.heyferh.homepage.service

import com.heyferh.homepage.model.UserStatistics

/**
 * Created by ferh on 19/12/15.
 */

trait HomePageService {
  def saveUserStatistics(stats: UserStatistics)
}