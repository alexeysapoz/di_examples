name := "di_examples"

lazy val common = project.in(file("common"))
  .settings(Settings.common)

lazy val manual = project.in(file("0_manual"))
  .settings(Settings.common)
  .dependsOn(common)

lazy val spring = project.in(file("1_spring"))
  .settings(Settings.common)
  .settings(libraryDependencies += "org.springframework" % "spring-context" % "5.2.3.RELEASE")
  .dependsOn(common)

lazy val guice = project.in(file("2_guice"))
  .settings(Settings.common)
  .dependsOn(common)

lazy val macwire = project.in(file("3_macwire"))
  .settings(Settings.common)
  .dependsOn(common)

lazy val root = project.in(file("."))
  .settings(Settings.common)
  .aggregate(common, manual, guice, spring, macwire)
