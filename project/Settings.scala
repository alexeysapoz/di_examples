import sbt.Keys._
import sbt.{Def, Defaults}

object Settings {
  lazy val common: Seq[Def.Setting[_]] =
    Defaults.coreDefaultSettings ++ Seq(
      version := "1.0",
      organization := "java2scala",
      scalaVersion := "2.13.1",
      scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-Xfatal-warnings")
    )
}
