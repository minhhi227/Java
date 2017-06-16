import com.github.play2war.plugin._

name := """cab-remittance"""

version := "1.0-SNAPSHOT"

Play2WarPlugin.play2WarSettings

Play2WarKeys.servletVersion := "3.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
	javaCore, 
	javaJpa,
	cache,
	"org.hibernate" % "hibernate-entitymanager" % "3.6.9.Final",
	"org.springframework" % "spring-orm" % "3.0.5.RELEASE",
	"org.springframework" % "spring-test" % "3.0.5.RELEASE",
	"commons-dbcp" % "commons-dbcp" % "1.4",
	"postgresql" % "postgresql" % "9.1-901-1.jdbc4",
	"org.jasypt" % "jasypt" % "1.9.0",
	"commons-io" % "commons-io" % "2.0.1",
	"com.googlecode.json-simple" % "json-simple" % "1.1",
	"net.sf.jxls" % "jxls-core" % "1.0"
)
