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

  def slick = Action {
    val dbConfig = DbConfig.getDbConfig
    println(dbConfig)
    val db = DbConfig.getDb
    println(db)
    val action = User.filter(_.name === "wx").result
    db.run(action).map {
      result =>
        result.foreach(u=>{
          println(u.address)
        })
    }
    Ok(views.html.main())
  }

}