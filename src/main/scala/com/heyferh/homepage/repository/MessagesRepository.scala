package com.heyferh.homepage.repository

import com.heyferh.homepage.model.Message
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Created by feku on 12/25/2015.
 */
@Repository
trait MessagesRepository extends MongoRepository[Message, String]