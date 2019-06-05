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
public class HeroTest {

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
	public void testHeroLevelUp() throws Exception {
        assertThat(hero, hasProperty("level"));
        heroLevelTemp = hero.getLevel();
        heroLevelUp = hero.levelUp();
        assertThat(heroLevelUp, greaterThan(heroLevelTemp));
	}

	@Test
	public void testHeroProperties() throws Exception {
		assertThat(hero, hasProperty("name"));
		assertThat(hero, hasProperty("hp"));
		assertThat(hero, hasProperty("level"));
		assertThat(hero, hasProperty("atk"));
        assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));
        assertThat(hero, hasProperty("hp", is(20)));
        assertThat(hero, hasProperty("level", is(1)));
        assertThat(hero, hasProperty("atk", is(2)));
	}

	@Test
	public void testAttack() throws Exception {
		Random rand = new Random();
		int randomNum = rand.nextInt(hero.getLevel() + 1);
		assertThat(hero.getAtk() + randomNum, greaterThanOrEqualTo(0));
	}

	@Test
	public void testSetLevel() throws Exception {
		assertThat(hero.getLevel(), greaterThan(0));
	}