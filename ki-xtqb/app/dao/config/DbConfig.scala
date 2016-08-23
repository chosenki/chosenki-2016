package dao.config

import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

/**
  * Created by Wangxiang on 2016/8/23.
  */
object DbConfig {

  private lazy val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)

  def getDbConfig() ={
    dbConfig
  }

  def getDb() ={
    dbConfig.db
  }

}
