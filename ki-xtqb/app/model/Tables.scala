package model
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = User.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table User
   *  @param id Database column ID SqlType(INT), PrimaryKey
   *  @param name Database column NAME SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param address Database column ADDRESS SqlType(VARCHAR), Length(100,true), Default(None) */
  case class UserRow(id: Int, name: Option[String] = None, address: Option[String] = None)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<?[String], <<?[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends Table[UserRow](_tableTag, "user") {
    def * = (id, name, address) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, address).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ID SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("ID", O.PrimaryKey)
    /** Database column NAME SqlType(VARCHAR), Length(50,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("NAME", O.Length(50,varying=true), O.Default(None))
    /** Database column ADDRESS SqlType(VARCHAR), Length(100,true), Default(None) */
    val address: Rep[Option[String]] = column[Option[String]]("ADDRESS", O.Length(100,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}
