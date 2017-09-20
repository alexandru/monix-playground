package monplay

import twitter4j.{Query, Twitter, TwitterFactory}
import twitter4j.auth.AccessToken

import scala.collection.JavaConverters._

object TwitterAPI {
  lazy val connection: Twitter = {
    val ref = TwitterFactory.getSingleton
    ref.setOAuthConsumer(
      "euuAbKrpZ3aktrUZuYr2ZtHV3",
      "EgkHHtqIHTJwCygE12LWai45lKkpkq8mNizRyoDpAsHr1Gmv52"
    )
    ref.setOAuthAccessToken(new AccessToken(
      "15406736-QOZy4jhBagGpKUMcYMKtlp2yAiuzORC2Z1ggepjzv",
      "4d8Khuvy5QHm6NsrsNx6rtF1inyRfbxTyvvsUnHjuwNC6"
    ))
    ref
  }

  def sample(): Unit = {
    val query = new Query("@monix")
    val result = connection.search(query)

    result.getTweets.asScala.foreach(x => {
      println(s"${x.getUser.getScreenName}: ${x.getText}")
    })
  }
}
