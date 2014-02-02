name := "RaspPi-I2C-Test"

version := "0.1"

scalaVersion := "2.10.3"

scalacOptions ++= Seq(
	"-deprecation",
	"-unchecked"
)

libraryDependencies ++= Seq(
	"com.pi4j" % "pi4j-core" % "0.0.5"
)

libraryDependencies ++= Seq(
	"junit" % "junit" % "4.11" % "test",
	"org.scalatest" % "scalatest_2.10" % "2.0" % "test",
	"org.scalacheck" %% "scalacheck" % "1.11.1" % "test"
)

val libs = Seq(
	Attributed.blank(file("/opt/pi4j/lib/pi4j-core.jar")),
	Attributed.blank(file("/opt/pi4j/lib/pi4j-device.jar")),
	Attributed.blank(file("/opt/pi4j/lib/pi4j-gpio-body.jar")),
	Attributed.blank(file("/opt/pi4j/lib/pi4j-service.jar"))
)

fullClasspath in Compile ++= libs

fullClasspath in Runtime ++= libs

fullClasspath in Test ++= libs
