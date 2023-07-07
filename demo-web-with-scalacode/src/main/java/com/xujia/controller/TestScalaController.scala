package com.xujia.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RequestMethod, RestController}

/**
 * Scala版本的controller方法
 */
@RestController
class TestScalaController {

  @GetMapping(value = Array("/helloscala"))
  def hello():String = {
    "hello scala"
  }
}
