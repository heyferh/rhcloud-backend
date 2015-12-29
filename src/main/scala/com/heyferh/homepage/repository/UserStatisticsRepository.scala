package com.heyferh.homepage.repository

import com.heyferh.homepage.model.{Message, UserStatistics}
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by ferh on 19/12/15.
 */
@Repository
trait UserStatisticsRepository extends MongoRepository[UserStatistics, String]
