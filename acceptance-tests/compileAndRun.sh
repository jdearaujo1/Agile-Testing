cd src/

javac -d ../bin/ test/acceptance/Homepage*.java
echo 'AcceptanceTest compiled successfully ✓'

printf 'Running AcceptanceTest ... \n\n'


cd ../bin/
java org.junit.runner.JUnitCore test.acceptance.HomepageTest
