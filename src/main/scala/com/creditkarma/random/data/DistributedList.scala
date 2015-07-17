package com.creditkarma.random.data

trait DistributedList {
  val list: Map[String,Double]
  lazy val maxValue: Double = list.maxBy(_._2)._2

  final def getRandom: String = {
    val p = scala.util.Random.nextDouble * maxValue
    val it = list.toSeq.sortBy(_._2).iterator
    while (it.hasNext) {
      val (item, cumProb) = it.next()
      if (cumProb >= p)
        return item
    }
    sys.error(f"this should never happen")  // needed so it will compile
  }
}
