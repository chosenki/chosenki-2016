package controllers

import javax.inject.{Inject, Singleton}

import dao.config.DbConfig
import model.Tables._
import model.Tables.profile.api._
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class Application @Inject() (environment: play.api.Environment, configuration: play.api.Configuration) extends Controller {

  def index = Action {


    Ok(views.html.index())
  }

  def main = Action {
    Ok(views.html.main())
  }

  def config = Action {
    Ok(configuration.underlying.getString("logger.application"))
  }

  def count = Action {
    val num = environment.resource("application.conf").toSeq.size
    Ok(num.toString)
  }

  def redirect = Action {
    Redirect("/main", MOVED_PERMANENTLY)
  }

  def json = Action {
    val json = "{\"status\":\"OK\",\"message\":\"Place 'Nuthanger Farm' saved.\"}";
    Ok(Json.toJson(json))
  }

  def host = Action {
    val dbConfig = DbConfig.getDbConfig
    println(dbConfig)
    val db = DbConfig.getDb
    println(db)
    //implicit val HostFormat = Json.format[Host]
    val h = Host.filter(_.ipv4 === "192.168.55.10").drop(0).result.head
    val h1 = Host.filter(_.ipv4 === "192.168.55.11").result
    db.run(h).map {
      result =>
      println(result)
      println(result.hostname)
      //Ok(Json.toJson(result.hostname))
    }

    //Ok(Json.toJson(db.run(h1)))
    Ok(views.html.index())
  }

}