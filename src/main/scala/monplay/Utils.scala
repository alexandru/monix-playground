package monplay

import java.util.regex.Pattern

import scala.collection.mutable.ListBuffer

object Utils {
  def extractUserNames(text: String): List[String] = {
    val p = Pattern.compile("[@]\\w+")
    val m = p.matcher(text)

    var buffer = ListBuffer.empty[String]
    while (m.find()) buffer += m.group(0)
    buffer.toList
  }
}
