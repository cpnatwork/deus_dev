
cmd /D/C mvn install:install-file -Dfile=smack-3.1.0.jar -DartifactId=smack -DgroupId=jivesoftware -Dversion=3.1.0 -Dpackaging=jar
cmd /D/C mvn install:install-file -Dfile=smackx-3.1.0.jar -DartifactId=smackx -DgroupId=jivesoftware -Dversion=3.1.0 -Dpackaging=jar
cmd /D/C mvn install:install-file -Dfile=smackx-debug-3.1.0.jar -DartifactId=smackx-debug -DgroupId=jivesoftware -Dversion=3.1.0 -Dpackaging=jar

pause