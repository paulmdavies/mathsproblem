import sbt._
import Keys._

object MathsProblemBuild extends Build
{
    lazy val sharedLibraryDependencies = Seq(
        "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
    )

    lazy val root = Project(
        id = "MathsProblem",
        base = file( "." ),
        settings = Project.defaultSettings ++ Seq(
            libraryDependencies ++= sharedLibraryDependencies
        )
    )
}
