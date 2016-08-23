import com.typesafe.config.ConfigFactory

name := "ki-xtqb"

version := "1.0"

lazy val `ki-xtqb` = (project in file(".")).enablePlugins(PlayScala)

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
scalacOptions += "-target:jvm-1.8"

scalaVersion := "2.11.8"

routesGenerator := InjectedRoutesGenerator

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/maven-releases/"
resolvers += "Typesafe Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  cache , ws ,
  "com.typesafe.slick" %% "slick" % "3.1.1" % "provided",
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.0",
  "com.typesafe.slick" % "slick-codegen_2.11" % "3.1.1",
  "com.zaxxer" % "HikariCP" % "2.4.7" % "provided",
  "com.zaxxer" % "HikariCP-java6" % "2.3.13" % "provided",
  "org.slf4j" % "slf4j-api" % "1.7.21",
  "org.slf4j" % "slf4j-nop" % "1.7.21",
  "mysql" % "mysql-connector-java" % "5.1.37"

)


unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

// Slick code generator
slickCodeGen <<= slickCodeGenTask // register sbt command

lazy val config = ConfigFactory.parseFile(new File("./conf/application.conf"))
lazy val slickCodeGen = taskKey[Seq[File]]("slick-codegen")
lazy val slickCodeGenTask = (sourceManaged, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
  val slickDriver = config.getString("slick.dbs.default.driver").init
  val jdbcDriver = config.getString("slick.dbs.default.db.driver")
  val url = config.getString("slick.dbs.default.db.url")
  val username = config.getString("slick.dbs.default.db.username")
  val password = config.getString("slick.dbs.default.db.password")
  val outputDir = "app/"
  val pkg = "model"
  toError(r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg,username,password), s.log))
  val fname = outputDir + "/Tables.scala"
  Seq(file(fname))
}