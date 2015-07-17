import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.twitter._
import org.apache.spark.SparkConf

object TwitterPopular {
  def main(args: Array[String]){

    val consumerKey = "VOJ6qo61HhyySya8n6VGuA"
    val consumerSecret = "5iod1q0YP0Ew0k9XPaVo96TL3dzKiSSzESJC08AS1sc"
    val accessToken = "1429258818-fRXhEGBHcaiWAOesUMXsLDPJW3HZRhLBiNfkeLM"
    val accessTokenSecret = "5FiOguEjwFJJ2o4O5brZWei2xcD5FWxsiBS"

    System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
    System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)

    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("a59347_twitter")
    val ssc = new StreamingContext(sparkConf, Seconds(2))

    val stream = TwitterUtils.createStream(ssc, None)
    val words = stream.flatMap(status => status.getText.split(" "))
    
    println(words)

    ssc.start()
    ssc.awaitTermination()
    println("Hell World")

  }
}
