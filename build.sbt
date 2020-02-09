name := "di_examples"

lazy val common = project.in(file("common"))
  .settings(Settings.common)

lazy val spring = project.in(file("1_spring"))
  .settings(Settings.common)
  .settings(libraryDependencies += "org.springframework" % "spring-context" % "5.2.3.RELEASE")
  .dependsOn(common)

lazy val guice = project.in(file("2_guice"))
  .settings(Settings.common)
  .settings(libraryDependencies += "net.codingwell" %% "scala-guice" % "4.2.6")
  .dependsOn(common)

lazy val macwire = project.in(file("3_macwire"))
  .settings(Settings.common)
  .settings(libraryDependencies ++= Seq(
    "com.softwaremill.macwire" %% "macros" % "2.3.3" % "provided", // contains only code which is used at compile-time
    "com.softwaremill.macwire" %% "macrosakka" % "2.3.3" % "provided" // contains only code which is used at compile-time
  ))
  .dependsOn(common)

lazy val root = project.in(file("."))
  .settings(Settings.common)
  .aggregate(common, guice, spring, macwire)
