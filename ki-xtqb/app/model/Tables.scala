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
  lazy val schema: profile.SchemaDescription = Array(AccessTokens.schema, AnalyzeMapDetail.schema, AnalyzeMapInfo.schema, Applications.schema, AuthCodes.schema, ChartInfo.schema, ChartItemJoinLink.schema, ChartScope.schema, ChartUsedColInfo.schema, ClientGrantTypes.schema, Clients.schema, Cluster.schema, ConfirmationTokens.schema, DashboardChart.schema, DashboardInfo.schema, DrillPath.schema, GrantTypes.schema, Host.schema, PathNode.schema, PlayEvolutions.schema, SchemaVersion.schema, Task.schema, Users.schema, Workflow.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table AccessTokens
   *  @param accessToken Database column access_token SqlType(VARCHAR), PrimaryKey, Length(254,true)
   *  @param refreshToken Database column refresh_token SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param userGuid Database column user_guid SqlType(VARCHAR), Length(36,true)
   *  @param scope Database column scope SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param expiresIn Database column expires_in SqlType(BIGINT), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param clientId Database column client_id SqlType(VARCHAR), Length(254,true), Default(None) */
  case class AccessTokensRow(accessToken: String, refreshToken: Option[String] = None, userGuid: String, scope: Option[String] = None, expiresIn: Option[Long] = None, createdAt: java.sql.Timestamp, clientId: Option[String] = None)
  /** GetResult implicit for fetching AccessTokensRow objects using plain SQL queries */
  implicit def GetResultAccessTokensRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Long]], e3: GR[java.sql.Timestamp]): GR[AccessTokensRow] = GR{
    prs => import prs._
    AccessTokensRow.tupled((<<[String], <<?[String], <<[String], <<?[String], <<?[Long], <<[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table access_tokens. Objects of this class serve as prototypes for rows in queries. */
  class AccessTokens(_tableTag: Tag) extends Table[AccessTokensRow](_tableTag, "access_tokens") {
    def * = (accessToken, refreshToken, userGuid, scope, expiresIn, createdAt, clientId) <> (AccessTokensRow.tupled, AccessTokensRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(accessToken), refreshToken, Rep.Some(userGuid), scope, expiresIn, Rep.Some(createdAt), clientId).shaped.<>({r=>import r._; _1.map(_=> AccessTokensRow.tupled((_1.get, _2, _3.get, _4, _5, _6.get, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column access_token SqlType(VARCHAR), PrimaryKey, Length(254,true) */
    val accessToken: Rep[String] = column[String]("access_token", O.PrimaryKey, O.Length(254,varying=true))
    /** Database column refresh_token SqlType(VARCHAR), Length(254,true), Default(None) */
    val refreshToken: Rep[Option[String]] = column[Option[String]]("refresh_token", O.Length(254,varying=true), O.Default(None))
    /** Database column user_guid SqlType(VARCHAR), Length(36,true) */
    val userGuid: Rep[String] = column[String]("user_guid", O.Length(36,varying=true))
    /** Database column scope SqlType(VARCHAR), Length(254,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(254,varying=true), O.Default(None))
    /** Database column expires_in SqlType(BIGINT), Default(None) */
    val expiresIn: Rep[Option[Long]] = column[Option[Long]]("expires_in", O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column client_id SqlType(VARCHAR), Length(254,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("client_id", O.Length(254,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table AccessTokens */
  lazy val AccessTokens = new TableQuery(tag => new AccessTokens(tag))

  /** Entity class storing rows of table AnalyzeMapDetail
   *  @param analyzeMapId Database column analyze_map_id SqlType(INT), AutoInc, PrimaryKey
   *  @param analyzeMapInfoUuid Database column analyze_map_info_uuid SqlType(VARCHAR), Length(36,true)
   *  @param colName Database column col_name SqlType(VARCHAR), Length(45,true)
   *  @param colAnalyzeType Database column col_analyze_type SqlType(INT)
   *  @param colDisplayName Database column col_display_name SqlType(VARCHAR), Length(45,true)
   *  @param colExp Database column col_exp SqlType(VARCHAR), Length(200,true)
   *  @param colDataType Database column col_data_type SqlType(INT)
   *  @param colFeature Database column col_feature SqlType(INT), Default(None) */
  case class AnalyzeMapDetailRow(analyzeMapId: Int, analyzeMapInfoUuid: String, colName: String, colAnalyzeType: Int, colDisplayName: String, colExp: String, colDataType: Int, colFeature: Option[Int] = None)
  /** GetResult implicit for fetching AnalyzeMapDetailRow objects using plain SQL queries */
  implicit def GetResultAnalyzeMapDetailRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]]): GR[AnalyzeMapDetailRow] = GR{
    prs => import prs._
    AnalyzeMapDetailRow.tupled((<<[Int], <<[String], <<[String], <<[Int], <<[String], <<[String], <<[Int], <<?[Int]))
  }
  /** Table description of table analyze_map_detail. Objects of this class serve as prototypes for rows in queries. */
  class AnalyzeMapDetail(_tableTag: Tag) extends Table[AnalyzeMapDetailRow](_tableTag, "analyze_map_detail") {
    def * = (analyzeMapId, analyzeMapInfoUuid, colName, colAnalyzeType, colDisplayName, colExp, colDataType, colFeature) <> (AnalyzeMapDetailRow.tupled, AnalyzeMapDetailRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(analyzeMapId), Rep.Some(analyzeMapInfoUuid), Rep.Some(colName), Rep.Some(colAnalyzeType), Rep.Some(colDisplayName), Rep.Some(colExp), Rep.Some(colDataType), colFeature).shaped.<>({r=>import r._; _1.map(_=> AnalyzeMapDetailRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column analyze_map_id SqlType(INT), AutoInc, PrimaryKey */
    val analyzeMapId: Rep[Int] = column[Int]("analyze_map_id", O.AutoInc, O.PrimaryKey)
    /** Database column analyze_map_info_uuid SqlType(VARCHAR), Length(36,true) */
    val analyzeMapInfoUuid: Rep[String] = column[String]("analyze_map_info_uuid", O.Length(36,varying=true))
    /** Database column col_name SqlType(VARCHAR), Length(45,true) */
    val colName: Rep[String] = column[String]("col_name", O.Length(45,varying=true))
    /** Database column col_analyze_type SqlType(INT) */
    val colAnalyzeType: Rep[Int] = column[Int]("col_analyze_type")
    /** Database column col_display_name SqlType(VARCHAR), Length(45,true) */
    val colDisplayName: Rep[String] = column[String]("col_display_name", O.Length(45,varying=true))
    /** Database column col_exp SqlType(VARCHAR), Length(200,true) */
    val colExp: Rep[String] = column[String]("col_exp", O.Length(200,varying=true))
    /** Database column col_data_type SqlType(INT) */
    val colDataType: Rep[Int] = column[Int]("col_data_type")
    /** Database column col_feature SqlType(INT), Default(None) */
    val colFeature: Rep[Option[Int]] = column[Option[Int]]("col_feature", O.Default(None))

    /** Foreign key referencing AnalyzeMapInfo (database name analyze_map_detail_ibfk_1) */
    lazy val analyzeMapInfoFk = foreignKey("analyze_map_detail_ibfk_1", analyzeMapInfoUuid, AnalyzeMapInfo)(r => r.analyzeMapInfoUuid, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table AnalyzeMapDetail */
  lazy val AnalyzeMapDetail = new TableQuery(tag => new AnalyzeMapDetail(tag))

  /** Entity class storing rows of table AnalyzeMapInfo
   *  @param analyzeMapInfoUuid Database column analyze_map_info_uuid SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param scope Database column scope SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param tableNameX Database column table_name SqlType(VARCHAR), Length(45,true)
   *  @param displayName Database column display_name SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param createdUuid Database column created_uuid SqlType(VARCHAR), Length(36,true) */
  case class AnalyzeMapInfoRow(analyzeMapInfoUuid: String, scope: Option[String] = None, tableNameX: String, displayName: Option[String] = None, createdUuid: String)
  /** GetResult implicit for fetching AnalyzeMapInfoRow objects using plain SQL queries */
  implicit def GetResultAnalyzeMapInfoRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[AnalyzeMapInfoRow] = GR{
    prs => import prs._
    AnalyzeMapInfoRow.tupled((<<[String], <<?[String], <<[String], <<?[String], <<[String]))
  }
  /** Table description of table analyze_map_info. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala method names and were disambiguated: tableName */
  class AnalyzeMapInfo(_tableTag: Tag) extends Table[AnalyzeMapInfoRow](_tableTag, "analyze_map_info") {
    def * = (analyzeMapInfoUuid, scope, tableNameX, displayName, createdUuid) <> (AnalyzeMapInfoRow.tupled, AnalyzeMapInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(analyzeMapInfoUuid), scope, Rep.Some(tableNameX), displayName, Rep.Some(createdUuid)).shaped.<>({r=>import r._; _1.map(_=> AnalyzeMapInfoRow.tupled((_1.get, _2, _3.get, _4, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column analyze_map_info_uuid SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val analyzeMapInfoUuid: Rep[String] = column[String]("analyze_map_info_uuid", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column scope SqlType(VARCHAR), Length(45,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(45,varying=true), O.Default(None))
    /** Database column table_name SqlType(VARCHAR), Length(45,true)
     *  NOTE: The name was disambiguated because it collided with Slick's method Table#tableName. */
    val tableNameX: Rep[String] = column[String]("table_name", O.Length(45,varying=true))
    /** Database column display_name SqlType(VARCHAR), Length(45,true), Default(None) */
    val displayName: Rep[Option[String]] = column[Option[String]]("display_name", O.Length(45,varying=true), O.Default(None))
    /** Database column created_uuid SqlType(VARCHAR), Length(36,true) */
    val createdUuid: Rep[String] = column[String]("created_uuid", O.Length(36,varying=true))
  }
  /** Collection-like TableQuery object for table AnalyzeMapInfo */
  lazy val AnalyzeMapInfo = new TableQuery(tag => new AnalyzeMapInfo(tag))

  /** Entity class storing rows of table Applications
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(40,true)
   *  @param name Database column name SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param status Database column status SqlType(VARCHAR), Length(100,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(500,true), Default(None) */
  case class ApplicationsRow(id: String, name: Option[String] = None, status: Option[String] = None, description: Option[String] = None)
  /** GetResult implicit for fetching ApplicationsRow objects using plain SQL queries */
  implicit def GetResultApplicationsRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ApplicationsRow] = GR{
    prs => import prs._
    ApplicationsRow.tupled((<<[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table applications. Objects of this class serve as prototypes for rows in queries. */
  class Applications(_tableTag: Tag) extends Table[ApplicationsRow](_tableTag, "applications") {
    def * = (id, name, status, description) <> (ApplicationsRow.tupled, ApplicationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, status, description).shaped.<>({r=>import r._; _1.map(_=> ApplicationsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(40,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(40,varying=true))
    /** Database column name SqlType(VARCHAR), Length(200,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(200,varying=true), O.Default(None))
    /** Database column status SqlType(VARCHAR), Length(100,true), Default(None) */
    val status: Rep[Option[String]] = column[Option[String]]("status", O.Length(100,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(500,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(500,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Applications */
  lazy val Applications = new TableQuery(tag => new Applications(tag))

  /** Entity class storing rows of table AuthCodes
   *  @param authorizationCode Database column authorization_code SqlType(VARCHAR), PrimaryKey, Length(254,true)
   *  @param userGuid Database column user_guid SqlType(VARCHAR), Length(36,true)
   *  @param redirectUri Database column redirect_uri SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param scope Database column scope SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param clientId Database column client_id SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param expiresIn Database column expires_in SqlType(INT) */
  case class AuthCodesRow(authorizationCode: String, userGuid: String, redirectUri: Option[String] = None, createdAt: java.sql.Timestamp, scope: Option[String] = None, clientId: Option[String] = None, expiresIn: Int)
  /** GetResult implicit for fetching AuthCodesRow objects using plain SQL queries */
  implicit def GetResultAuthCodesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp], e3: GR[Int]): GR[AuthCodesRow] = GR{
    prs => import prs._
    AuthCodesRow.tupled((<<[String], <<[String], <<?[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<[Int]))
  }
  /** Table description of table auth_codes. Objects of this class serve as prototypes for rows in queries. */
  class AuthCodes(_tableTag: Tag) extends Table[AuthCodesRow](_tableTag, "auth_codes") {
    def * = (authorizationCode, userGuid, redirectUri, createdAt, scope, clientId, expiresIn) <> (AuthCodesRow.tupled, AuthCodesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(authorizationCode), Rep.Some(userGuid), redirectUri, Rep.Some(createdAt), scope, clientId, Rep.Some(expiresIn)).shaped.<>({r=>import r._; _1.map(_=> AuthCodesRow.tupled((_1.get, _2.get, _3, _4.get, _5, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column authorization_code SqlType(VARCHAR), PrimaryKey, Length(254,true) */
    val authorizationCode: Rep[String] = column[String]("authorization_code", O.PrimaryKey, O.Length(254,varying=true))
    /** Database column user_guid SqlType(VARCHAR), Length(36,true) */
    val userGuid: Rep[String] = column[String]("user_guid", O.Length(36,varying=true))
    /** Database column redirect_uri SqlType(VARCHAR), Length(254,true), Default(None) */
    val redirectUri: Rep[Option[String]] = column[Option[String]]("redirect_uri", O.Length(254,varying=true), O.Default(None))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column scope SqlType(VARCHAR), Length(254,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(254,varying=true), O.Default(None))
    /** Database column client_id SqlType(VARCHAR), Length(254,true), Default(None) */
    val clientId: Rep[Option[String]] = column[Option[String]]("client_id", O.Length(254,varying=true), O.Default(None))
    /** Database column expires_in SqlType(INT) */
    val expiresIn: Rep[Int] = column[Int]("expires_in")
  }
  /** Collection-like TableQuery object for table AuthCodes */
  lazy val AuthCodes = new TableQuery(tag => new AuthCodes(tag))

  /** Entity class storing rows of table ChartInfo
   *  @param chartUuid Database column chart_uuid SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param chartName Database column chart_name SqlType(VARCHAR), Length(45,true)
   *  @param chartDescription Database column chart_description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param chartType Database column chart_type SqlType(VARCHAR), Length(45,true)
   *  @param imageUrl Database column image_url SqlType(VARCHAR), Length(200,true)
   *  @param limit Database column limit SqlType(INT)
   *  @param scope Database column scope SqlType(VARCHAR), Length(200,true)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param createdByGuid Database column created_by_guid SqlType(VARCHAR), Length(36,true)
   *  @param updatedAt Database column updated_at SqlType(TIMESTAMP), Default(None)
   *  @param updatedByGuid Database column updated_by_guid SqlType(VARCHAR), Length(36,true), Default(None) */
  case class ChartInfoRow(chartUuid: String, chartName: String, chartDescription: Option[String] = None, chartType: String, imageUrl: String, limit: Int, scope: String, createdAt: java.sql.Timestamp, createdByGuid: String, updatedAt: Option[java.sql.Timestamp] = None, updatedByGuid: Option[String] = None)
  /** GetResult implicit for fetching ChartInfoRow objects using plain SQL queries */
  implicit def GetResultChartInfoRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Int], e3: GR[java.sql.Timestamp], e4: GR[Option[java.sql.Timestamp]]): GR[ChartInfoRow] = GR{
    prs => import prs._
    ChartInfoRow.tupled((<<[String], <<[String], <<?[String], <<[String], <<[String], <<[Int], <<[String], <<[java.sql.Timestamp], <<[String], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table chart_info. Objects of this class serve as prototypes for rows in queries. */
  class ChartInfo(_tableTag: Tag) extends Table[ChartInfoRow](_tableTag, "chart_info") {
    def * = (chartUuid, chartName, chartDescription, chartType, imageUrl, limit, scope, createdAt, createdByGuid, updatedAt, updatedByGuid) <> (ChartInfoRow.tupled, ChartInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(chartUuid), Rep.Some(chartName), chartDescription, Rep.Some(chartType), Rep.Some(imageUrl), Rep.Some(limit), Rep.Some(scope), Rep.Some(createdAt), Rep.Some(createdByGuid), updatedAt, updatedByGuid).shaped.<>({r=>import r._; _1.map(_=> ChartInfoRow.tupled((_1.get, _2.get, _3, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column chart_uuid SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val chartUuid: Rep[String] = column[String]("chart_uuid", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column chart_name SqlType(VARCHAR), Length(45,true) */
    val chartName: Rep[String] = column[String]("chart_name", O.Length(45,varying=true))
    /** Database column chart_description SqlType(VARCHAR), Length(200,true), Default(None) */
    val chartDescription: Rep[Option[String]] = column[Option[String]]("chart_description", O.Length(200,varying=true), O.Default(None))
    /** Database column chart_type SqlType(VARCHAR), Length(45,true) */
    val chartType: Rep[String] = column[String]("chart_type", O.Length(45,varying=true))
    /** Database column image_url SqlType(VARCHAR), Length(200,true) */
    val imageUrl: Rep[String] = column[String]("image_url", O.Length(200,varying=true))
    /** Database column limit SqlType(INT) */
    val limit: Rep[Int] = column[Int]("limit")
    /** Database column scope SqlType(VARCHAR), Length(200,true) */
    val scope: Rep[String] = column[String]("scope", O.Length(200,varying=true))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column created_by_guid SqlType(VARCHAR), Length(36,true) */
    val createdByGuid: Rep[String] = column[String]("created_by_guid", O.Length(36,varying=true))
    /** Database column updated_at SqlType(TIMESTAMP), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column updated_by_guid SqlType(VARCHAR), Length(36,true), Default(None) */
    val updatedByGuid: Rep[Option[String]] = column[Option[String]]("updated_by_guid", O.Length(36,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table ChartInfo */
  lazy val ChartInfo = new TableQuery(tag => new ChartInfo(tag))

  /** Entity class storing rows of table ChartItemJoinLink
   *  @param joinLinkId Database column join_link_id SqlType(INT), AutoInc, PrimaryKey
   *  @param relatedChartUuid Database column related_chart_uuid SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param leftAnalyzeTableId Database column left_analyze_table_id SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param leftAnalyzeColId Database column left_analyze_col_id SqlType(INT), Default(None)
   *  @param joinLinkType Database column join_link_type SqlType(INT), Default(None)
   *  @param rightAnalyzeTableId Database column right_analyze_table_id SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param rightAnalyzeColId Database column right_analyze_col_id SqlType(INT), Default(None) */
  case class ChartItemJoinLinkRow(joinLinkId: Int, relatedChartUuid: Option[String] = None, leftAnalyzeTableId: Option[String] = None, leftAnalyzeColId: Option[Int] = None, joinLinkType: Option[Int] = None, rightAnalyzeTableId: Option[String] = None, rightAnalyzeColId: Option[Int] = None)
  /** GetResult implicit for fetching ChartItemJoinLinkRow objects using plain SQL queries */
  implicit def GetResultChartItemJoinLinkRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ChartItemJoinLinkRow] = GR{
    prs => import prs._
    ChartItemJoinLinkRow.tupled((<<[Int], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[String], <<?[Int]))
  }
  /** Table description of table chart_item_join_link. Objects of this class serve as prototypes for rows in queries. */
  class ChartItemJoinLink(_tableTag: Tag) extends Table[ChartItemJoinLinkRow](_tableTag, "chart_item_join_link") {
    def * = (joinLinkId, relatedChartUuid, leftAnalyzeTableId, leftAnalyzeColId, joinLinkType, rightAnalyzeTableId, rightAnalyzeColId) <> (ChartItemJoinLinkRow.tupled, ChartItemJoinLinkRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(joinLinkId), relatedChartUuid, leftAnalyzeTableId, leftAnalyzeColId, joinLinkType, rightAnalyzeTableId, rightAnalyzeColId).shaped.<>({r=>import r._; _1.map(_=> ChartItemJoinLinkRow.tupled((_1.get, _2, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column join_link_id SqlType(INT), AutoInc, PrimaryKey */
    val joinLinkId: Rep[Int] = column[Int]("join_link_id", O.AutoInc, O.PrimaryKey)
    /** Database column related_chart_uuid SqlType(VARCHAR), Length(36,true), Default(None) */
    val relatedChartUuid: Rep[Option[String]] = column[Option[String]]("related_chart_uuid", O.Length(36,varying=true), O.Default(None))
    /** Database column left_analyze_table_id SqlType(VARCHAR), Length(36,true), Default(None) */
    val leftAnalyzeTableId: Rep[Option[String]] = column[Option[String]]("left_analyze_table_id", O.Length(36,varying=true), O.Default(None))
    /** Database column left_analyze_col_id SqlType(INT), Default(None) */
    val leftAnalyzeColId: Rep[Option[Int]] = column[Option[Int]]("left_analyze_col_id", O.Default(None))
    /** Database column join_link_type SqlType(INT), Default(None) */
    val joinLinkType: Rep[Option[Int]] = column[Option[Int]]("join_link_type", O.Default(None))
    /** Database column right_analyze_table_id SqlType(VARCHAR), Length(36,true), Default(None) */
    val rightAnalyzeTableId: Rep[Option[String]] = column[Option[String]]("right_analyze_table_id", O.Length(36,varying=true), O.Default(None))
    /** Database column right_analyze_col_id SqlType(INT), Default(None) */
    val rightAnalyzeColId: Rep[Option[Int]] = column[Option[Int]]("right_analyze_col_id", O.Default(None))

    /** Foreign key referencing AnalyzeMapDetail (database name chart_item_join_link_ibfk_2) */
    lazy val analyzeMapDetailFk1 = foreignKey("chart_item_join_link_ibfk_2", leftAnalyzeColId, AnalyzeMapDetail)(r => Rep.Some(r.analyzeMapId), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing AnalyzeMapDetail (database name chart_item_join_link_ibfk_4) */
    lazy val analyzeMapDetailFk2 = foreignKey("chart_item_join_link_ibfk_4", rightAnalyzeColId, AnalyzeMapDetail)(r => Rep.Some(r.analyzeMapId), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing AnalyzeMapInfo (database name chart_item_join_link_ibfk_1) */
    lazy val analyzeMapInfoFk3 = foreignKey("chart_item_join_link_ibfk_1", leftAnalyzeTableId, AnalyzeMapInfo)(r => Rep.Some(r.analyzeMapInfoUuid), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing AnalyzeMapInfo (database name chart_item_join_link_ibfk_3) */
    lazy val analyzeMapInfoFk4 = foreignKey("chart_item_join_link_ibfk_3", rightAnalyzeTableId, AnalyzeMapInfo)(r => Rep.Some(r.analyzeMapInfoUuid), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ChartInfo (database name chart_item_join_link_ibfk_5) */
    lazy val chartInfoFk = foreignKey("chart_item_join_link_ibfk_5", relatedChartUuid, ChartInfo)(r => Rep.Some(r.chartUuid), onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ChartItemJoinLink */
  lazy val ChartItemJoinLink = new TableQuery(tag => new ChartItemJoinLink(tag))

  /** Entity class storing rows of table ChartScope
   *  @param chartScopeId Database column chart_scope_id SqlType(INT), PrimaryKey
   *  @param chartId Database column chart_id SqlType(INT), Default(None)
   *  @param scope Database column scope SqlType(VARCHAR), Length(200,true), Default(None) */
  case class ChartScopeRow(chartScopeId: Int, chartId: Option[Int] = None, scope: Option[String] = None)
  /** GetResult implicit for fetching ChartScopeRow objects using plain SQL queries */
  implicit def GetResultChartScopeRow(implicit e0: GR[Int], e1: GR[Option[Int]], e2: GR[Option[String]]): GR[ChartScopeRow] = GR{
    prs => import prs._
    ChartScopeRow.tupled((<<[Int], <<?[Int], <<?[String]))
  }
  /** Table description of table chart_scope. Objects of this class serve as prototypes for rows in queries. */
  class ChartScope(_tableTag: Tag) extends Table[ChartScopeRow](_tableTag, "chart_scope") {
    def * = (chartScopeId, chartId, scope) <> (ChartScopeRow.tupled, ChartScopeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(chartScopeId), chartId, scope).shaped.<>({r=>import r._; _1.map(_=> ChartScopeRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column chart_scope_id SqlType(INT), PrimaryKey */
    val chartScopeId: Rep[Int] = column[Int]("chart_scope_id", O.PrimaryKey)
    /** Database column chart_id SqlType(INT), Default(None) */
    val chartId: Rep[Option[Int]] = column[Option[Int]]("chart_id", O.Default(None))
    /** Database column scope SqlType(VARCHAR), Length(200,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table ChartScope */
  lazy val ChartScope = new TableQuery(tag => new ChartScope(tag))

  /** Entity class storing rows of table ChartUsedColInfo
   *  @param chartUsedColId Database column chart_used_col_id SqlType(INT), AutoInc, PrimaryKey
   *  @param chartUuid Database column chart_uuid SqlType(VARCHAR), Length(36,true)
   *  @param analyzeMapId Database column analyze_map_id SqlType(INT)
   *  @param coltype Database column colType SqlType(INT)
   *  @param member Database column member SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param operatorType Database column operator_type SqlType(INT), Default(None)
   *  @param colExp Database column col_exp SqlType(VARCHAR), Length(200,true), Default(None) */
  case class ChartUsedColInfoRow(chartUsedColId: Int, chartUuid: String, analyzeMapId: Int, coltype: Int, member: Option[String] = None, operatorType: Option[Int] = None, colExp: Option[String] = None)
  /** GetResult implicit for fetching ChartUsedColInfoRow objects using plain SQL queries */
  implicit def GetResultChartUsedColInfoRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]], e3: GR[Option[Int]]): GR[ChartUsedColInfoRow] = GR{
    prs => import prs._
    ChartUsedColInfoRow.tupled((<<[Int], <<[String], <<[Int], <<[Int], <<?[String], <<?[Int], <<?[String]))
  }
  /** Table description of table chart_used_col_info. Objects of this class serve as prototypes for rows in queries. */
  class ChartUsedColInfo(_tableTag: Tag) extends Table[ChartUsedColInfoRow](_tableTag, "chart_used_col_info") {
    def * = (chartUsedColId, chartUuid, analyzeMapId, coltype, member, operatorType, colExp) <> (ChartUsedColInfoRow.tupled, ChartUsedColInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(chartUsedColId), Rep.Some(chartUuid), Rep.Some(analyzeMapId), Rep.Some(coltype), member, operatorType, colExp).shaped.<>({r=>import r._; _1.map(_=> ChartUsedColInfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column chart_used_col_id SqlType(INT), AutoInc, PrimaryKey */
    val chartUsedColId: Rep[Int] = column[Int]("chart_used_col_id", O.AutoInc, O.PrimaryKey)
    /** Database column chart_uuid SqlType(VARCHAR), Length(36,true) */
    val chartUuid: Rep[String] = column[String]("chart_uuid", O.Length(36,varying=true))
    /** Database column analyze_map_id SqlType(INT) */
    val analyzeMapId: Rep[Int] = column[Int]("analyze_map_id")
    /** Database column colType SqlType(INT) */
    val coltype: Rep[Int] = column[Int]("colType")
    /** Database column member SqlType(VARCHAR), Length(200,true), Default(None) */
    val member: Rep[Option[String]] = column[Option[String]]("member", O.Length(200,varying=true), O.Default(None))
    /** Database column operator_type SqlType(INT), Default(None) */
    val operatorType: Rep[Option[Int]] = column[Option[Int]]("operator_type", O.Default(None))
    /** Database column col_exp SqlType(VARCHAR), Length(200,true), Default(None) */
    val colExp: Rep[Option[String]] = column[Option[String]]("col_exp", O.Length(200,varying=true), O.Default(None))

    /** Foreign key referencing AnalyzeMapDetail (database name chart_used_col_info_ibfk_1) */
    lazy val analyzeMapDetailFk = foreignKey("chart_used_col_info_ibfk_1", analyzeMapId, AnalyzeMapDetail)(r => r.analyzeMapId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing ChartInfo (database name chart_used_col_info_ibfk_2) */
    lazy val chartInfoFk = foreignKey("chart_used_col_info_ibfk_2", chartUuid, ChartInfo)(r => r.chartUuid, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table ChartUsedColInfo */
  lazy val ChartUsedColInfo = new TableQuery(tag => new ChartUsedColInfo(tag))

  /** Entity class storing rows of table ClientGrantTypes
   *  @param clientGrantId Database column client_grant_id SqlType(INT), PrimaryKey
   *  @param clientId Database column client_id SqlType(VARCHAR), Length(254,true)
   *  @param grantTypeId Database column grant_type_id SqlType(INT) */
  case class ClientGrantTypesRow(clientGrantId: Int, clientId: String, grantTypeId: Int)
  /** GetResult implicit for fetching ClientGrantTypesRow objects using plain SQL queries */
  implicit def GetResultClientGrantTypesRow(implicit e0: GR[Int], e1: GR[String]): GR[ClientGrantTypesRow] = GR{
    prs => import prs._
    ClientGrantTypesRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table client_grant_types. Objects of this class serve as prototypes for rows in queries. */
  class ClientGrantTypes(_tableTag: Tag) extends Table[ClientGrantTypesRow](_tableTag, "client_grant_types") {
    def * = (clientGrantId, clientId, grantTypeId) <> (ClientGrantTypesRow.tupled, ClientGrantTypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(clientGrantId), Rep.Some(clientId), Rep.Some(grantTypeId)).shaped.<>({r=>import r._; _1.map(_=> ClientGrantTypesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column client_grant_id SqlType(INT), PrimaryKey */
    val clientGrantId: Rep[Int] = column[Int]("client_grant_id", O.PrimaryKey)
    /** Database column client_id SqlType(VARCHAR), Length(254,true) */
    val clientId: Rep[String] = column[String]("client_id", O.Length(254,varying=true))
    /** Database column grant_type_id SqlType(INT) */
    val grantTypeId: Rep[Int] = column[Int]("grant_type_id")
  }
  /** Collection-like TableQuery object for table ClientGrantTypes */
  lazy val ClientGrantTypes = new TableQuery(tag => new ClientGrantTypes(tag))

  /** Entity class storing rows of table Clients
   *  @param id Database column id SqlType(VARCHAR), PrimaryKey, Length(254,true)
   *  @param secret Database column secret SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param redirectUri Database column redirect_uri SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param scope Database column scope SqlType(VARCHAR), Length(254,true), Default(None) */
  case class ClientsRow(id: String, secret: Option[String] = None, redirectUri: Option[String] = None, scope: Option[String] = None)
  /** GetResult implicit for fetching ClientsRow objects using plain SQL queries */
  implicit def GetResultClientsRow(implicit e0: GR[String], e1: GR[Option[String]]): GR[ClientsRow] = GR{
    prs => import prs._
    ClientsRow.tupled((<<[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table clients. Objects of this class serve as prototypes for rows in queries. */
  class Clients(_tableTag: Tag) extends Table[ClientsRow](_tableTag, "clients") {
    def * = (id, secret, redirectUri, scope) <> (ClientsRow.tupled, ClientsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), secret, redirectUri, scope).shaped.<>({r=>import r._; _1.map(_=> ClientsRow.tupled((_1.get, _2, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(VARCHAR), PrimaryKey, Length(254,true) */
    val id: Rep[String] = column[String]("id", O.PrimaryKey, O.Length(254,varying=true))
    /** Database column secret SqlType(VARCHAR), Length(254,true), Default(None) */
    val secret: Rep[Option[String]] = column[Option[String]]("secret", O.Length(254,varying=true), O.Default(None))
    /** Database column redirect_uri SqlType(VARCHAR), Length(254,true), Default(None) */
    val redirectUri: Rep[Option[String]] = column[Option[String]]("redirect_uri", O.Length(254,varying=true), O.Default(None))
    /** Database column scope SqlType(VARCHAR), Length(254,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(254,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Clients */
  lazy val Clients = new TableQuery(tag => new Clients(tag))

  /** Entity class storing rows of table Cluster
   *  @param clusterId Database column cluster_id SqlType(INT), AutoInc, PrimaryKey
   *  @param clusterName Database column cluster_name SqlType(VARCHAR), Length(45,true)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param zookeeper Database column zookeeper SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param master Database column master SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param monitor Database column monitor SqlType(VARCHAR), Length(45,true), Default(None) */
  case class ClusterRow(clusterId: Int, clusterName: String, description: Option[String] = None, zookeeper: Option[String] = None, master: Option[String] = None, monitor: Option[String] = None)
  /** GetResult implicit for fetching ClusterRow objects using plain SQL queries */
  implicit def GetResultClusterRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[ClusterRow] = GR{
    prs => import prs._
    ClusterRow.tupled((<<[Int], <<[String], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table cluster. Objects of this class serve as prototypes for rows in queries. */
  class Cluster(_tableTag: Tag) extends Table[ClusterRow](_tableTag, "cluster") {
    def * = (clusterId, clusterName, description, zookeeper, master, monitor) <> (ClusterRow.tupled, ClusterRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(clusterId), Rep.Some(clusterName), description, zookeeper, master, monitor).shaped.<>({r=>import r._; _1.map(_=> ClusterRow.tupled((_1.get, _2.get, _3, _4, _5, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column cluster_id SqlType(INT), AutoInc, PrimaryKey */
    val clusterId: Rep[Int] = column[Int]("cluster_id", O.AutoInc, O.PrimaryKey)
    /** Database column cluster_name SqlType(VARCHAR), Length(45,true) */
    val clusterName: Rep[String] = column[String]("cluster_name", O.Length(45,varying=true))
    /** Database column description SqlType(VARCHAR), Length(200,true), Default(None) */
    val description: Rep[Option[String]] = column[Option[String]]("description", O.Length(200,varying=true), O.Default(None))
    /** Database column zookeeper SqlType(VARCHAR), Length(200,true), Default(None) */
    val zookeeper: Rep[Option[String]] = column[Option[String]]("zookeeper", O.Length(200,varying=true), O.Default(None))
    /** Database column master SqlType(VARCHAR), Length(45,true), Default(None) */
    val master: Rep[Option[String]] = column[Option[String]]("master", O.Length(45,varying=true), O.Default(None))
    /** Database column monitor SqlType(VARCHAR), Length(45,true), Default(None) */
    val monitor: Rep[Option[String]] = column[Option[String]]("monitor", O.Length(45,varying=true), O.Default(None))

    /** Uniqueness Index over (clusterName) (database name cluster_name_UNIQUE) */
    val index1 = index("cluster_name_UNIQUE", clusterName, unique=true)
  }
  /** Collection-like TableQuery object for table Cluster */
  lazy val Cluster = new TableQuery(tag => new Cluster(tag))

  /** Entity class storing rows of table ConfirmationTokens
   *  @param id Database column id SqlType(BIGINT), AutoInc, PrimaryKey
   *  @param uuid Database column uuid SqlType(VARCHAR), Length(36,true)
   *  @param email Database column email SqlType(VARCHAR), Length(254,true)
   *  @param creationTime Database column creation_time SqlType(TIMESTAMP)
   *  @param expirationTime Database column expiration_time SqlType(TIMESTAMP), Default(None)
   *  @param isSignUp Database column is_sign_up SqlType(BIT) */
  case class ConfirmationTokensRow(id: Long, uuid: String, email: String, creationTime: java.sql.Timestamp, expirationTime: Option[java.sql.Timestamp] = None, isSignUp: Boolean)
  /** GetResult implicit for fetching ConfirmationTokensRow objects using plain SQL queries */
  implicit def GetResultConfirmationTokensRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[java.sql.Timestamp]], e4: GR[Boolean]): GR[ConfirmationTokensRow] = GR{
    prs => import prs._
    ConfirmationTokensRow.tupled((<<[Long], <<[String], <<[String], <<[java.sql.Timestamp], <<?[java.sql.Timestamp], <<[Boolean]))
  }
  /** Table description of table confirmation_tokens. Objects of this class serve as prototypes for rows in queries. */
  class ConfirmationTokens(_tableTag: Tag) extends Table[ConfirmationTokensRow](_tableTag, "confirmation_tokens") {
    def * = (id, uuid, email, creationTime, expirationTime, isSignUp) <> (ConfirmationTokensRow.tupled, ConfirmationTokensRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(uuid), Rep.Some(email), Rep.Some(creationTime), expirationTime, Rep.Some(isSignUp)).shaped.<>({r=>import r._; _1.map(_=> ConfirmationTokensRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(BIGINT), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column uuid SqlType(VARCHAR), Length(36,true) */
    val uuid: Rep[String] = column[String]("uuid", O.Length(36,varying=true))
    /** Database column email SqlType(VARCHAR), Length(254,true) */
    val email: Rep[String] = column[String]("email", O.Length(254,varying=true))
    /** Database column creation_time SqlType(TIMESTAMP) */
    val creationTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("creation_time")
    /** Database column expiration_time SqlType(TIMESTAMP), Default(None) */
    val expirationTime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("expiration_time", O.Default(None))
    /** Database column is_sign_up SqlType(BIT) */
    val isSignUp: Rep[Boolean] = column[Boolean]("is_sign_up")
  }
  /** Collection-like TableQuery object for table ConfirmationTokens */
  lazy val ConfirmationTokens = new TableQuery(tag => new ConfirmationTokens(tag))

  /** Entity class storing rows of table DashboardChart
   *  @param dashboardChartId Database column dashboard_chart_id SqlType(INT), AutoInc, PrimaryKey
   *  @param dashboardUuid Database column dashboard_uuid SqlType(VARCHAR), Length(36,true)
   *  @param chartUuid Database column chart_uuid SqlType(VARCHAR), Length(36,true)
   *  @param idx Database column idx SqlType(INT)
   *  @param row Database column row SqlType(INT)
   *  @param col Database column col SqlType(INT)
   *  @param sizeX Database column size_x SqlType(INT)
   *  @param sizeY Database column size_y SqlType(INT) */
  case class DashboardChartRow(dashboardChartId: Int, dashboardUuid: String, chartUuid: String, idx: Int, row: Int, col: Int, sizeX: Int, sizeY: Int)
  /** GetResult implicit for fetching DashboardChartRow objects using plain SQL queries */
  implicit def GetResultDashboardChartRow(implicit e0: GR[Int], e1: GR[String]): GR[DashboardChartRow] = GR{
    prs => import prs._
    DashboardChartRow.tupled((<<[Int], <<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table dashboard_chart. Objects of this class serve as prototypes for rows in queries. */
  class DashboardChart(_tableTag: Tag) extends Table[DashboardChartRow](_tableTag, "dashboard_chart") {
    def * = (dashboardChartId, dashboardUuid, chartUuid, idx, row, col, sizeX, sizeY) <> (DashboardChartRow.tupled, DashboardChartRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(dashboardChartId), Rep.Some(dashboardUuid), Rep.Some(chartUuid), Rep.Some(idx), Rep.Some(row), Rep.Some(col), Rep.Some(sizeX), Rep.Some(sizeY)).shaped.<>({r=>import r._; _1.map(_=> DashboardChartRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column dashboard_chart_id SqlType(INT), AutoInc, PrimaryKey */
    val dashboardChartId: Rep[Int] = column[Int]("dashboard_chart_id", O.AutoInc, O.PrimaryKey)
    /** Database column dashboard_uuid SqlType(VARCHAR), Length(36,true) */
    val dashboardUuid: Rep[String] = column[String]("dashboard_uuid", O.Length(36,varying=true))
    /** Database column chart_uuid SqlType(VARCHAR), Length(36,true) */
    val chartUuid: Rep[String] = column[String]("chart_uuid", O.Length(36,varying=true))
    /** Database column idx SqlType(INT) */
    val idx: Rep[Int] = column[Int]("idx")
    /** Database column row SqlType(INT) */
    val row: Rep[Int] = column[Int]("row")
    /** Database column col SqlType(INT) */
    val col: Rep[Int] = column[Int]("col")
    /** Database column size_x SqlType(INT) */
    val sizeX: Rep[Int] = column[Int]("size_x")
    /** Database column size_y SqlType(INT) */
    val sizeY: Rep[Int] = column[Int]("size_y")

    /** Foreign key referencing DashboardInfo (database name dashboard_chart_ibfk_1) */
    lazy val dashboardInfoFk = foreignKey("dashboard_chart_ibfk_1", dashboardUuid, DashboardInfo)(r => r.dashboardUuid, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table DashboardChart */
  lazy val DashboardChart = new TableQuery(tag => new DashboardChart(tag))

  /** Entity class storing rows of table DashboardInfo
   *  @param dashboardUuid Database column dashboard_uuid SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param dashboardTitle Database column dashboard_title SqlType(VARCHAR), Length(45,true)
   *  @param createdByGuid Database column created_by_guid SqlType(VARCHAR), Length(36,true)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param updatedByGuid Database column updated_by_guid SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param updatedAt Database column updated_at SqlType(TIMESTAMP), Default(None)
   *  @param scope Database column scope SqlType(VARCHAR), Length(200,true), Default(None) */
  case class DashboardInfoRow(dashboardUuid: String, dashboardTitle: String, createdByGuid: String, createdAt: java.sql.Timestamp, updatedByGuid: Option[String] = None, updatedAt: Option[java.sql.Timestamp] = None, scope: Option[String] = None)
  /** GetResult implicit for fetching DashboardInfoRow objects using plain SQL queries */
  implicit def GetResultDashboardInfoRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp], e2: GR[Option[String]], e3: GR[Option[java.sql.Timestamp]]): GR[DashboardInfoRow] = GR{
    prs => import prs._
    DashboardInfoRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table dashboard_info. Objects of this class serve as prototypes for rows in queries. */
  class DashboardInfo(_tableTag: Tag) extends Table[DashboardInfoRow](_tableTag, "dashboard_info") {
    def * = (dashboardUuid, dashboardTitle, createdByGuid, createdAt, updatedByGuid, updatedAt, scope) <> (DashboardInfoRow.tupled, DashboardInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(dashboardUuid), Rep.Some(dashboardTitle), Rep.Some(createdByGuid), Rep.Some(createdAt), updatedByGuid, updatedAt, scope).shaped.<>({r=>import r._; _1.map(_=> DashboardInfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column dashboard_uuid SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val dashboardUuid: Rep[String] = column[String]("dashboard_uuid", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column dashboard_title SqlType(VARCHAR), Length(45,true) */
    val dashboardTitle: Rep[String] = column[String]("dashboard_title", O.Length(45,varying=true))
    /** Database column created_by_guid SqlType(VARCHAR), Length(36,true) */
    val createdByGuid: Rep[String] = column[String]("created_by_guid", O.Length(36,varying=true))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column updated_by_guid SqlType(VARCHAR), Length(36,true), Default(None) */
    val updatedByGuid: Rep[Option[String]] = column[Option[String]]("updated_by_guid", O.Length(36,varying=true), O.Default(None))
    /** Database column updated_at SqlType(TIMESTAMP), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column scope SqlType(VARCHAR), Length(200,true), Default(None) */
    val scope: Rep[Option[String]] = column[Option[String]]("scope", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table DashboardInfo */
  lazy val DashboardInfo = new TableQuery(tag => new DashboardInfo(tag))

  /** Entity class storing rows of table DrillPath
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param isDefault Database column is_default SqlType(BIT)
   *  @param analyzeMapDetailId Database column analyze_map_detail_id SqlType(INT) */
  case class DrillPathRow(id: Int, name: Option[String] = None, isDefault: Boolean, analyzeMapDetailId: Int)
  /** GetResult implicit for fetching DrillPathRow objects using plain SQL queries */
  implicit def GetResultDrillPathRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[Boolean]): GR[DrillPathRow] = GR{
    prs => import prs._
    DrillPathRow.tupled((<<[Int], <<?[String], <<[Boolean], <<[Int]))
  }
  /** Table description of table drill_path. Objects of this class serve as prototypes for rows in queries. */
  class DrillPath(_tableTag: Tag) extends Table[DrillPathRow](_tableTag, "drill_path") {
    def * = (id, name, isDefault, analyzeMapDetailId) <> (DrillPathRow.tupled, DrillPathRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, Rep.Some(isDefault), Rep.Some(analyzeMapDetailId)).shaped.<>({r=>import r._; _1.map(_=> DrillPathRow.tupled((_1.get, _2, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(45,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(45,varying=true), O.Default(None))
    /** Database column is_default SqlType(BIT) */
    val isDefault: Rep[Boolean] = column[Boolean]("is_default")
    /** Database column analyze_map_detail_id SqlType(INT) */
    val analyzeMapDetailId: Rep[Int] = column[Int]("analyze_map_detail_id")
  }
  /** Collection-like TableQuery object for table DrillPath */
  lazy val DrillPath = new TableQuery(tag => new DrillPath(tag))

  /** Entity class storing rows of table GrantTypes
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param grantType Database column grant_type SqlType(VARCHAR), Length(254,true) */
  case class GrantTypesRow(id: Int, grantType: String)
  /** GetResult implicit for fetching GrantTypesRow objects using plain SQL queries */
  implicit def GetResultGrantTypesRow(implicit e0: GR[Int], e1: GR[String]): GR[GrantTypesRow] = GR{
    prs => import prs._
    GrantTypesRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table grant_types. Objects of this class serve as prototypes for rows in queries. */
  class GrantTypes(_tableTag: Tag) extends Table[GrantTypesRow](_tableTag, "grant_types") {
    def * = (id, grantType) <> (GrantTypesRow.tupled, GrantTypesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(grantType)).shaped.<>({r=>import r._; _1.map(_=> GrantTypesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column grant_type SqlType(VARCHAR), Length(254,true) */
    val grantType: Rep[String] = column[String]("grant_type", O.Length(254,varying=true))
  }
  /** Collection-like TableQuery object for table GrantTypes */
  lazy val GrantTypes = new TableQuery(tag => new GrantTypes(tag))

  /** Entity class storing rows of table Host
   *  @param hostId Database column host_id SqlType(INT), AutoInc, PrimaryKey
   *  @param tag Database column tag SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param hostname Database column hostname SqlType(VARCHAR), Length(45,true)
   *  @param ipv4 Database column ipv4 SqlType(VARCHAR), Length(45,true)
   *  @param enable Database column enable SqlType(BIT)
   *  @param clusterId Database column cluster_id SqlType(INT)
   *  @param roleType Database column role_type SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param components Database column components SqlType(VARCHAR), Length(200,true), Default(None)
   *  @param cores Database column cores SqlType(INT), Default(None)
   *  @param memory Database column memory SqlType(INT), Default(None)
   *  @param disk Database column disk SqlType(INT), Default(None) */
  case class HostRow(hostId: Int, tag: Option[String] = None, hostname: String, ipv4: String, enable: Boolean, clusterId: Int, roleType: Option[String] = None, components: Option[String] = None, cores: Option[Int] = None, memory: Option[Int] = None, disk: Option[Int] = None)
  /** GetResult implicit for fetching HostRow objects using plain SQL queries */
  implicit def GetResultHostRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[String], e3: GR[Boolean], e4: GR[Option[Int]]): GR[HostRow] = GR{
    prs => import prs._
    HostRow.tupled((<<[Int], <<?[String], <<[String], <<[String], <<[Boolean], <<[Int], <<?[String], <<?[String], <<?[Int], <<?[Int], <<?[Int]))
  }
  /** Table description of table host. Objects of this class serve as prototypes for rows in queries. */
  class Host(_tableTag: Tag) extends Table[HostRow](_tableTag, "host") {
    def * = (hostId, tag, hostname, ipv4, enable, clusterId, roleType, components, cores, memory, disk) <> (HostRow.tupled, HostRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(hostId), tag, Rep.Some(hostname), Rep.Some(ipv4), Rep.Some(enable), Rep.Some(clusterId), roleType, components, cores, memory, disk).shaped.<>({r=>import r._; _1.map(_=> HostRow.tupled((_1.get, _2, _3.get, _4.get, _5.get, _6.get, _7, _8, _9, _10, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column host_id SqlType(INT), AutoInc, PrimaryKey */
    val hostId: Rep[Int] = column[Int]("host_id", O.AutoInc, O.PrimaryKey)
    /** Database column tag SqlType(VARCHAR), Length(45,true), Default(None) */
    val tag: Rep[Option[String]] = column[Option[String]]("tag", O.Length(45,varying=true), O.Default(None))
    /** Database column hostname SqlType(VARCHAR), Length(45,true) */
    val hostname: Rep[String] = column[String]("hostname", O.Length(45,varying=true))
    /** Database column ipv4 SqlType(VARCHAR), Length(45,true) */
    val ipv4: Rep[String] = column[String]("ipv4", O.Length(45,varying=true))
    /** Database column enable SqlType(BIT) */
    val enable: Rep[Boolean] = column[Boolean]("enable")
    /** Database column cluster_id SqlType(INT) */
    val clusterId: Rep[Int] = column[Int]("cluster_id")
    /** Database column role_type SqlType(VARCHAR), Length(200,true), Default(None) */
    val roleType: Rep[Option[String]] = column[Option[String]]("role_type", O.Length(200,varying=true), O.Default(None))
    /** Database column components SqlType(VARCHAR), Length(200,true), Default(None) */
    val components: Rep[Option[String]] = column[Option[String]]("components", O.Length(200,varying=true), O.Default(None))
    /** Database column cores SqlType(INT), Default(None) */
    val cores: Rep[Option[Int]] = column[Option[Int]]("cores", O.Default(None))
    /** Database column memory SqlType(INT), Default(None) */
    val memory: Rep[Option[Int]] = column[Option[Int]]("memory", O.Default(None))
    /** Database column disk SqlType(INT), Default(None) */
    val disk: Rep[Option[Int]] = column[Option[Int]]("disk", O.Default(None))

    /** Foreign key referencing Cluster (database name host_ibfk_1) */
    lazy val clusterFk = foreignKey("host_ibfk_1", clusterId, Cluster)(r => r.clusterId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Uniqueness Index over (hostname) (database name name_UNIQUE) */
    val index1 = index("name_UNIQUE", hostname, unique=true)
  }
  /** Collection-like TableQuery object for table Host */
  lazy val Host = new TableQuery(tag => new Host(tag))

  /** Entity class storing rows of table PathNode
   *  @param id Database column id SqlType(INT), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(45,true), Default(None)
   *  @param seq Database column seq SqlType(INT)
   *  @param rule Database column rule SqlType(VARCHAR), Length(1000,true)
   *  @param drillPathId Database column drill_path_id SqlType(INT) */
  case class PathNodeRow(id: Int, name: Option[String] = None, seq: Int, rule: String, drillPathId: Int)
  /** GetResult implicit for fetching PathNodeRow objects using plain SQL queries */
  implicit def GetResultPathNodeRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[String]): GR[PathNodeRow] = GR{
    prs => import prs._
    PathNodeRow.tupled((<<[Int], <<?[String], <<[Int], <<[String], <<[Int]))
  }
  /** Table description of table path_node. Objects of this class serve as prototypes for rows in queries. */
  class PathNode(_tableTag: Tag) extends Table[PathNodeRow](_tableTag, "path_node") {
    def * = (id, name, seq, rule, drillPathId) <> (PathNodeRow.tupled, PathNodeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, Rep.Some(seq), Rep.Some(rule), Rep.Some(drillPathId)).shaped.<>({r=>import r._; _1.map(_=> PathNodeRow.tupled((_1.get, _2, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(45,true), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(45,varying=true), O.Default(None))
    /** Database column seq SqlType(INT) */
    val seq: Rep[Int] = column[Int]("seq")
    /** Database column rule SqlType(VARCHAR), Length(1000,true) */
    val rule: Rep[String] = column[String]("rule", O.Length(1000,varying=true))
    /** Database column drill_path_id SqlType(INT) */
    val drillPathId: Rep[Int] = column[Int]("drill_path_id")
  }
  /** Collection-like TableQuery object for table PathNode */
  lazy val PathNode = new TableQuery(tag => new PathNode(tag))

  /** Entity class storing rows of table PlayEvolutions
   *  @param id Database column id SqlType(INT), PrimaryKey
   *  @param hash Database column hash SqlType(VARCHAR), Length(255,true)
   *  @param appliedAt Database column applied_at SqlType(TIMESTAMP)
   *  @param applyScript Database column apply_script SqlType(TEXT), Default(None)
   *  @param revertScript Database column revert_script SqlType(TEXT), Default(None)
   *  @param state Database column state SqlType(VARCHAR), Length(255,true), Default(None)
   *  @param lastProblem Database column last_problem SqlType(TEXT), Default(None) */
  case class PlayEvolutionsRow(id: Int, hash: String, appliedAt: java.sql.Timestamp, applyScript: Option[String] = None, revertScript: Option[String] = None, state: Option[String] = None, lastProblem: Option[String] = None)
  /** GetResult implicit for fetching PlayEvolutionsRow objects using plain SQL queries */
  implicit def GetResultPlayEvolutionsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]]): GR[PlayEvolutionsRow] = GR{
    prs => import prs._
    PlayEvolutionsRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table play_evolutions. Objects of this class serve as prototypes for rows in queries. */
  class PlayEvolutions(_tableTag: Tag) extends Table[PlayEvolutionsRow](_tableTag, "play_evolutions") {
    def * = (id, hash, appliedAt, applyScript, revertScript, state, lastProblem) <> (PlayEvolutionsRow.tupled, PlayEvolutionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(hash), Rep.Some(appliedAt), applyScript, revertScript, state, lastProblem).shaped.<>({r=>import r._; _1.map(_=> PlayEvolutionsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column hash SqlType(VARCHAR), Length(255,true) */
    val hash: Rep[String] = column[String]("hash", O.Length(255,varying=true))
    /** Database column applied_at SqlType(TIMESTAMP) */
    val appliedAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("applied_at")
    /** Database column apply_script SqlType(TEXT), Default(None) */
    val applyScript: Rep[Option[String]] = column[Option[String]]("apply_script", O.Default(None))
    /** Database column revert_script SqlType(TEXT), Default(None) */
    val revertScript: Rep[Option[String]] = column[Option[String]]("revert_script", O.Default(None))
    /** Database column state SqlType(VARCHAR), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column last_problem SqlType(TEXT), Default(None) */
    val lastProblem: Rep[Option[String]] = column[Option[String]]("last_problem", O.Default(None))
  }
  /** Collection-like TableQuery object for table PlayEvolutions */
  lazy val PlayEvolutions = new TableQuery(tag => new PlayEvolutions(tag))

  /** Entity class storing rows of table SchemaVersion
   *  @param installedRank Database column installed_rank SqlType(INT), PrimaryKey
   *  @param version Database column version SqlType(VARCHAR), Length(50,true), Default(None)
   *  @param description Database column description SqlType(VARCHAR), Length(200,true)
   *  @param `type` Database column type SqlType(VARCHAR), Length(20,true)
   *  @param script Database column script SqlType(VARCHAR), Length(1000,true)
   *  @param checksum Database column checksum SqlType(INT), Default(None)
   *  @param installedBy Database column installed_by SqlType(VARCHAR), Length(100,true)
   *  @param installedOn Database column installed_on SqlType(TIMESTAMP)
   *  @param executionTime Database column execution_time SqlType(INT)
   *  @param success Database column success SqlType(BIT) */
  case class SchemaVersionRow(installedRank: Int, version: Option[String] = None, description: String, `type`: String, script: String, checksum: Option[Int] = None, installedBy: String, installedOn: java.sql.Timestamp, executionTime: Int, success: Boolean)
  /** GetResult implicit for fetching SchemaVersionRow objects using plain SQL queries */
  implicit def GetResultSchemaVersionRow(implicit e0: GR[Int], e1: GR[Option[String]], e2: GR[String], e3: GR[Option[Int]], e4: GR[java.sql.Timestamp], e5: GR[Boolean]): GR[SchemaVersionRow] = GR{
    prs => import prs._
    SchemaVersionRow.tupled((<<[Int], <<?[String], <<[String], <<[String], <<[String], <<?[Int], <<[String], <<[java.sql.Timestamp], <<[Int], <<[Boolean]))
  }
  /** Table description of table schema_version. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class SchemaVersion(_tableTag: Tag) extends Table[SchemaVersionRow](_tableTag, "schema_version") {
    def * = (installedRank, version, description, `type`, script, checksum, installedBy, installedOn, executionTime, success) <> (SchemaVersionRow.tupled, SchemaVersionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(installedRank), version, Rep.Some(description), Rep.Some(`type`), Rep.Some(script), checksum, Rep.Some(installedBy), Rep.Some(installedOn), Rep.Some(executionTime), Rep.Some(success)).shaped.<>({r=>import r._; _1.map(_=> SchemaVersionRow.tupled((_1.get, _2, _3.get, _4.get, _5.get, _6, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column installed_rank SqlType(INT), PrimaryKey */
    val installedRank: Rep[Int] = column[Int]("installed_rank", O.PrimaryKey)
    /** Database column version SqlType(VARCHAR), Length(50,true), Default(None) */
    val version: Rep[Option[String]] = column[Option[String]]("version", O.Length(50,varying=true), O.Default(None))
    /** Database column description SqlType(VARCHAR), Length(200,true) */
    val description: Rep[String] = column[String]("description", O.Length(200,varying=true))
    /** Database column type SqlType(VARCHAR), Length(20,true)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("type", O.Length(20,varying=true))
    /** Database column script SqlType(VARCHAR), Length(1000,true) */
    val script: Rep[String] = column[String]("script", O.Length(1000,varying=true))
    /** Database column checksum SqlType(INT), Default(None) */
    val checksum: Rep[Option[Int]] = column[Option[Int]]("checksum", O.Default(None))
    /** Database column installed_by SqlType(VARCHAR), Length(100,true) */
    val installedBy: Rep[String] = column[String]("installed_by", O.Length(100,varying=true))
    /** Database column installed_on SqlType(TIMESTAMP) */
    val installedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("installed_on")
    /** Database column execution_time SqlType(INT) */
    val executionTime: Rep[Int] = column[Int]("execution_time")
    /** Database column success SqlType(BIT) */
    val success: Rep[Boolean] = column[Boolean]("success")

    /** Index over (success) (database name schema_version_s_idx) */
    val index1 = index("schema_version_s_idx", success)
  }
  /** Collection-like TableQuery object for table SchemaVersion */
  lazy val SchemaVersion = new TableQuery(tag => new SchemaVersion(tag))

  /** Entity class storing rows of table Task
   *  @param taskUuid Database column task_uuid SqlType(INT), PrimaryKey
   *  @param taskName Database column task_name SqlType(VARCHAR), Length(45,true)
   *  @param taskStatus Database column task_status SqlType(VARCHAR), Length(45,true)
   *  @param workflowId Database column workflow_id SqlType(VARCHAR), Length(45,true)
   *  @param ipv4 Database column ipv4 SqlType(VARCHAR), Length(45,true)
   *  @param message Database column message SqlType(VARCHAR), Length(200,true) */
  case class TaskRow(taskUuid: Int, taskName: String, taskStatus: String, workflowId: String, ipv4: String, message: String)
  /** GetResult implicit for fetching TaskRow objects using plain SQL queries */
  implicit def GetResultTaskRow(implicit e0: GR[Int], e1: GR[String]): GR[TaskRow] = GR{
    prs => import prs._
    TaskRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[String], <<[String]))
  }
  /** Table description of table task. Objects of this class serve as prototypes for rows in queries. */
  class Task(_tableTag: Tag) extends Table[TaskRow](_tableTag, "task") {
    def * = (taskUuid, taskName, taskStatus, workflowId, ipv4, message) <> (TaskRow.tupled, TaskRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(taskUuid), Rep.Some(taskName), Rep.Some(taskStatus), Rep.Some(workflowId), Rep.Some(ipv4), Rep.Some(message)).shaped.<>({r=>import r._; _1.map(_=> TaskRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column task_uuid SqlType(INT), PrimaryKey */
    val taskUuid: Rep[Int] = column[Int]("task_uuid", O.PrimaryKey)
    /** Database column task_name SqlType(VARCHAR), Length(45,true) */
    val taskName: Rep[String] = column[String]("task_name", O.Length(45,varying=true))
    /** Database column task_status SqlType(VARCHAR), Length(45,true) */
    val taskStatus: Rep[String] = column[String]("task_status", O.Length(45,varying=true))
    /** Database column workflow_id SqlType(VARCHAR), Length(45,true) */
    val workflowId: Rep[String] = column[String]("workflow_id", O.Length(45,varying=true))
    /** Database column ipv4 SqlType(VARCHAR), Length(45,true) */
    val ipv4: Rep[String] = column[String]("ipv4", O.Length(45,varying=true))
    /** Database column message SqlType(VARCHAR), Length(200,true) */
    val message: Rep[String] = column[String]("message", O.Length(200,varying=true))

    /** Foreign key referencing Workflow (database name task_ibfk_1) */
    lazy val workflowFk = foreignKey("task_ibfk_1", workflowId, Workflow)(r => r.workflowId, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)

    /** Index over (taskStatus) (database name task_status_INDEX) */
    val index1 = index("task_status_INDEX", taskStatus)
  }
  /** Collection-like TableQuery object for table Task */
  lazy val Task = new TableQuery(tag => new Task(tag))

  /** Entity class storing rows of table Users
   *  @param guid Database column guid SqlType(VARCHAR), PrimaryKey, Length(36,true)
   *  @param firstName Database column first_name SqlType(VARCHAR), Length(254,true)
   *  @param lastName Database column last_name SqlType(VARCHAR), Length(254,true)
   *  @param email Database column email SqlType(VARCHAR), Length(254,true)
   *  @param password Database column password SqlType(VARCHAR), Length(254,true)
   *  @param salt Database column salt SqlType(VARCHAR), Length(254,true), Default(None)
   *  @param scope Database column scope SqlType(VARCHAR), Length(255,true)
   *  @param createdAt Database column created_at SqlType(TIMESTAMP)
   *  @param createdByGuid Database column created_by_guid SqlType(VARCHAR), Length(36,true)
   *  @param updatedAt Database column updated_at SqlType(TIMESTAMP), Default(None)
   *  @param updatedByGuid Database column updated_by_guid SqlType(VARCHAR), Length(36,true), Default(None)
   *  @param deletedAt Database column deleted_at SqlType(TIMESTAMP), Default(None)
   *  @param deletedByGuid Database column deleted_by_guid SqlType(VARCHAR), Length(36,true), Default(None) */
  case class UsersRow(guid: String, firstName: String, lastName: String, email: String, password: String, salt: Option[String] = None, scope: String, createdAt: java.sql.Timestamp, createdByGuid: String, updatedAt: Option[java.sql.Timestamp] = None, updatedByGuid: Option[String] = None, deletedAt: Option[java.sql.Timestamp] = None, deletedByGuid: Option[String] = None)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp], e3: GR[Option[java.sql.Timestamp]]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[String], <<?[String], <<[String], <<[java.sql.Timestamp], <<[String], <<?[java.sql.Timestamp], <<?[String], <<?[java.sql.Timestamp], <<?[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends Table[UsersRow](_tableTag, "users") {
    def * = (guid, firstName, lastName, email, password, salt, scope, createdAt, createdByGuid, updatedAt, updatedByGuid, deletedAt, deletedByGuid) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(guid), Rep.Some(firstName), Rep.Some(lastName), Rep.Some(email), Rep.Some(password), salt, Rep.Some(scope), Rep.Some(createdAt), Rep.Some(createdByGuid), updatedAt, updatedByGuid, deletedAt, deletedByGuid).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7.get, _8.get, _9.get, _10, _11, _12, _13)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column guid SqlType(VARCHAR), PrimaryKey, Length(36,true) */
    val guid: Rep[String] = column[String]("guid", O.PrimaryKey, O.Length(36,varying=true))
    /** Database column first_name SqlType(VARCHAR), Length(254,true) */
    val firstName: Rep[String] = column[String]("first_name", O.Length(254,varying=true))
    /** Database column last_name SqlType(VARCHAR), Length(254,true) */
    val lastName: Rep[String] = column[String]("last_name", O.Length(254,varying=true))
    /** Database column email SqlType(VARCHAR), Length(254,true) */
    val email: Rep[String] = column[String]("email", O.Length(254,varying=true))
    /** Database column password SqlType(VARCHAR), Length(254,true) */
    val password: Rep[String] = column[String]("password", O.Length(254,varying=true))
    /** Database column salt SqlType(VARCHAR), Length(254,true), Default(None) */
    val salt: Rep[Option[String]] = column[Option[String]]("salt", O.Length(254,varying=true), O.Default(None))
    /** Database column scope SqlType(VARCHAR), Length(255,true) */
    val scope: Rep[String] = column[String]("scope", O.Length(255,varying=true))
    /** Database column created_at SqlType(TIMESTAMP) */
    val createdAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_at")
    /** Database column created_by_guid SqlType(VARCHAR), Length(36,true) */
    val createdByGuid: Rep[String] = column[String]("created_by_guid", O.Length(36,varying=true))
    /** Database column updated_at SqlType(TIMESTAMP), Default(None) */
    val updatedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated_at", O.Default(None))
    /** Database column updated_by_guid SqlType(VARCHAR), Length(36,true), Default(None) */
    val updatedByGuid: Rep[Option[String]] = column[Option[String]]("updated_by_guid", O.Length(36,varying=true), O.Default(None))
    /** Database column deleted_at SqlType(TIMESTAMP), Default(None) */
    val deletedAt: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("deleted_at", O.Default(None))
    /** Database column deleted_by_guid SqlType(VARCHAR), Length(36,true), Default(None) */
    val deletedByGuid: Rep[Option[String]] = column[Option[String]]("deleted_by_guid", O.Length(36,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))

  /** Entity class storing rows of table Workflow
   *  @param workflowId Database column workflow_id SqlType(VARCHAR), PrimaryKey, Length(45,true)
   *  @param workflowName Database column workflow_name SqlType(VARCHAR), Length(45,true)
   *  @param workflowStatus Database column workflow_status SqlType(VARCHAR), Length(45,true)
   *  @param namespace Database column namespace SqlType(VARCHAR), Length(45,true)
   *  @param startTime Database column start_time SqlType(BIGINT)
   *  @param userId Database column user_id SqlType(VARCHAR), Length(45,true), Default(None) */
  case class WorkflowRow(workflowId: String, workflowName: String, workflowStatus: String, namespace: String, startTime: Long, userId: Option[String] = None)
  /** GetResult implicit for fetching WorkflowRow objects using plain SQL queries */
  implicit def GetResultWorkflowRow(implicit e0: GR[String], e1: GR[Long], e2: GR[Option[String]]): GR[WorkflowRow] = GR{
    prs => import prs._
    WorkflowRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[Long], <<?[String]))
  }
  /** Table description of table workflow. Objects of this class serve as prototypes for rows in queries. */
  class Workflow(_tableTag: Tag) extends Table[WorkflowRow](_tableTag, "workflow") {
    def * = (workflowId, workflowName, workflowStatus, namespace, startTime, userId) <> (WorkflowRow.tupled, WorkflowRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(workflowId), Rep.Some(workflowName), Rep.Some(workflowStatus), Rep.Some(namespace), Rep.Some(startTime), userId).shaped.<>({r=>import r._; _1.map(_=> WorkflowRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column workflow_id SqlType(VARCHAR), PrimaryKey, Length(45,true) */
    val workflowId: Rep[String] = column[String]("workflow_id", O.PrimaryKey, O.Length(45,varying=true))
    /** Database column workflow_name SqlType(VARCHAR), Length(45,true) */
    val workflowName: Rep[String] = column[String]("workflow_name", O.Length(45,varying=true))
    /** Database column workflow_status SqlType(VARCHAR), Length(45,true) */
    val workflowStatus: Rep[String] = column[String]("workflow_status", O.Length(45,varying=true))
    /** Database column namespace SqlType(VARCHAR), Length(45,true) */
    val namespace: Rep[String] = column[String]("namespace", O.Length(45,varying=true))
    /** Database column start_time SqlType(BIGINT) */
    val startTime: Rep[Long] = column[Long]("start_time")
    /** Database column user_id SqlType(VARCHAR), Length(45,true), Default(None) */
    val userId: Rep[Option[String]] = column[Option[String]]("user_id", O.Length(45,varying=true), O.Default(None))

    /** Index over (workflowStatus) (database name workflow_status_INDEX) */
    val index1 = index("workflow_status_INDEX", workflowStatus)
  }
  /** Collection-like TableQuery object for table Workflow */
  lazy val Workflow = new TableQuery(tag => new Workflow(tag))
}
