call mvn clean
call mvn eclipse:clean
call mvn dependency:sources
call mvn eclipse:eclipse -Dwtpversion=2.0
call PAUSE