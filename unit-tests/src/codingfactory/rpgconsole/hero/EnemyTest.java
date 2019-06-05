package test;

import junit.framework.*;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import codingfactory.rpgconsole.hero.Hero;
import codingfactory.rpgconsole.enemy.Enemy;

import java.util.Random;

public class EnemyTest {

    Hero hero;
    Enemy enemy;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Avant le démarrage");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Après tous les tests");
    }

    @Before
    public void setUp() throws Exception {
        hero = new Hero("Jaina Portvaillant");
        enemy = new Enemy("Skeleton", 1);
        System.out.println("Avant un test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Après un test");
    }

    @Test
    public void testHeroProperties() throws Exception {
        assertThat(enemy, hasProperty("name"));
        assertThat(enemy, hasProperty("hp"));
        assertThat(enemy, hasProperty("level"));
        assertThat(enemy, hasProperty("atk"));
        assertThat(enemy, hasProperty("name", is("Skeleton")));
        assertThat(enemy, hasProperty("hp", is(15)));
        assertThat(enemy, hasProperty("level", is(1)));
        assertThat(enemy, hasProperty("atk", is(1)));
    }

    @Test
    public void testAttack() throws Exception {
        Random rand = new Random();
        int randomNum = rand.nextInt(enemy.getLevel() + 1);
        assertThat(enemy.getAtk() + randomNum, greaterThanOrEqualTo(0));
    }

    @Test
    public void testSetLevel() throws Exception {
        assertThat(enemy.getLevel(), greaterThan(0));
    }

    @Test
    public void testTakeDamage() throws Exception {
        int enemyHpTemp = enemy.getHp();
        enemy.takeDamage(2);
        int enemyTakeDamage = enemy.getHp();
        assertThat(enemyTakeDamage, lessThanOrEqualTo(enemyHpTemp));
    }
}
