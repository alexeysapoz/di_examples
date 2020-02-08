name := "di_examples"

lazy val manual = project.in(file("manual"))
  .settings(Settings.common)

lazy val guice = project.in(file("guice"))
  .settings(Settings.common)

lazy val spring = project.in(file("spring"))
  .settings(Settings.common)

lazy val macwire = project.in(file("macwire"))
  .settings(Settings.common)

lazy val root = project.in(file("."))
  .settings(Settings.common)
  .aggregate(manual, guice, spring, macwire)
