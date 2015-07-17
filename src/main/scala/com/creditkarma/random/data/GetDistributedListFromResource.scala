package com.creditkarma.random.data

import scala.io.Source
import spray.json._
import spray.json.DefaultJsonProtocol._

case class GetDistributedListFromResource(file: String) extends DistributedList {
  val stream = getClass.getResourceAsStream(file)
  val text = Source.fromInputStream(stream).mkString
  val json = text.parseJson
  val list = json.convertTo[Map[String,Double]]
}
