cd src/

javac -d ../bin/ codingfactory/rpgconsole/enemy/*.java
echo 'Enemy compiled successfully ✓'

javac -d ../bin/ codingfactory/rpgconsole/hero/*.java
echo 'Hero compiled successfully ✓'

javac -d ../bin/ codingfactory/rpgconsole/game/*.java
echo 'Game compiled successfully ✓'

javac -d ../bin/ test/HeroTest.java
echo 'HeroTest compiled successfully ✓'

javac -d ../bin/ test/EnemyTest.java
echo 'EnemyTest compiled successfully ✓'

javac -d ../bin/ test/GameTest.java
echo 'GameTest compiled successfully ✓'


echo 'Running HeroTest ...'
printf 'Running EnemyTest ... \n\n'



cd ../bin/
java org.junit.runner.JUnitCore test.HeroTest
java org.junit.runner.JUnitCore test.EnemyTest
java org.junit.runner.JUnitCore test.GameTest

