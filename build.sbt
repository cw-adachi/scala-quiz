name := "sandbox"

version := "1.0"

scalaVersion := "2.11.4"

scalacOptions ++= Seq("-encoding", "UTF-8", "-feature", "-unchecked", "-deprecation")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
