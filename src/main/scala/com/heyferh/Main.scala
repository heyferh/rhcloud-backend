package com.heyferh

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.{RestController, RequestMapping}

/**
 * Created by feku on 12/29/2015.
 */
@RestController
@SpringBootApplication
class Main {
  @RequestMapping(value = Array("", "/")) def index: String = {
    "Running ..."
  }
}

object Main extends App {
  SpringApplication.run(classOf[Main])
}
