import sbt._
import Keys._

object MathsProblemBuild extends Build
{
    lazy val root = Project(
        id = "MathsProblem",
        base = file( "." ),
        settings = Project.defaultSettings
    )
}
