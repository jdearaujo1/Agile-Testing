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


printf 'Running HeroTest ... \n\n'


cd ../bin/
java org.junit.runner.JUnitCore test.HeroTest
java org.junit.runner.JUnitCore test.EnemyTest

