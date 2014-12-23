import sbt._
import Keys._

object MathsProblemBuild extends Build
{
    lazy val root = Project(
        id = "MathsProblem",
        base = file( "." ),
        settings = Defaults.defaultSettings ++ Seq(
            scalaVersion := "2.10.2",
            libraryDependencies ++= Seq(
                "org.scalatest" %% "scalatest" % "2.2.1" % "test"
            )
        )
    )
}
