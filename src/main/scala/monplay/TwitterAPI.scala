package monplay

import twitter4j.{Query, Status, Twitter, TwitterFactory}
import twitter4j.auth.AccessToken

import scala.collection.JavaConverters._
import scala.collection.mutable

object TwitterAPI {
  lazy val connectionSync: Twitter = {
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

  def search(query: String): mutable.Buffer[Status] = {
    val query = new Query("@monix")
    connectionSync.search(query).getTweets.asScala
  }
}
