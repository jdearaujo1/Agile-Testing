cd src/

javac -d ../bin/ test/functional/FunctionalTest.java
echo 'FunctionalTest compiled successfully ✓'

printf 'Running FonctionalTest ... \n\n'


cd ../bin/
java org.junit.runner.JUnitCore test.functional.FunctionalTest
