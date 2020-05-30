package com.sg.testing.dao.implementations;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author naris
 */
public class AGoodMonsterDaoTest {

    MonsterDao testDAO;

    public AGoodMonsterDaoTest() {
    }

    @BeforeEach
    public void setUp() {
        testDAO = new AGoodMonsterDao(); //keeps DAO clean and empty per test
    }

    @Test
    public void testAddGetMonster() {
        //ARRANGE
        final int monster1ID = 0001;
        Monster testMonster1 = new Monster("Carmilla", MonsterType.VAMPIRE, 69, "Black Pudding");

        //ACT
        testDAO.addMonster(monster1ID, testMonster1);
        Monster addedMonster = testDAO.getMonster(monster1ID);

        //ASSERT
        assertEquals(testDAO.getMonster(monster1ID), addedMonster, "Carmilla should be the added monster");
    }

    @Test
    public void testGetAllMonsters() {
        //ARRANGE
        final int monster1ID = 0001;
        Monster testMonster1 = new Monster("Carmilla", MonsterType.VAMPIRE, 69, "Black Pudding");
        final int monster2ID = 0002;
        Monster testMonster2 = new Monster("Elizabeth", MonsterType.LIZARDMAN, 35, "BBQ Squirrel");

        //ACT
        testDAO.addMonster(monster1ID, testMonster1);
        Monster addedMonster1 = testDAO.getMonster(monster1ID);
        testDAO.addMonster(monster2ID, testMonster2);
        Monster addedMonster2 = testDAO.getMonster(monster2ID);

        List<Monster> monsterRoster = testDAO.getAllMonsters();

        //ASSERT
        assertEquals(testDAO.getMonster(monster1ID), addedMonster1, "Carmilla should be the first added monster");
        assertEquals(testDAO.getMonster(monster2ID), addedMonster2, "Elizabeth should be the second added monster");

        assertFalse(monsterRoster.isEmpty(), "Monster Roster shouldn't be empty");
        assertEquals(2, monsterRoster.size(), "Monster Roster should have exactly 2 monsters");
        assertTrue(monsterRoster.contains(testMonster1), "Roster should contain Carmilla");
        assertTrue(monsterRoster.contains(testMonster2), "Roster should contain Elizabeth");
    }

    @Test
    public void testUpdateMonster() {
        //ARRANGE
        final int monsterID = 0001;
        Monster testMonster1 = new Monster("Carmilla", MonsterType.VAMPIRE, 69, "Black Pudding");
        Monster testMonster2 = new Monster("Elizabeth", MonsterType.LIZARDMAN, 35, "BBQ Squirrel");

        //ACT
        testDAO.addMonster(monsterID, testMonster1);
        Monster originalMonster0001 = testDAO.getMonster(monsterID);

        testDAO.updateMonster(monsterID, testMonster2);
        Monster newMonster0001 = testDAO.getMonster(monsterID);

        List<Monster> monsterRoster = testDAO.getAllMonsters();

        //ASSERT
        assertFalse(monsterRoster.contains(originalMonster0001), "Carmilla should no longer be in roster");
        assertTrue(monsterRoster.contains(newMonster0001), "Elizabeth should be in Roster");
        assertEquals(testDAO.getMonster(monsterID), newMonster0001, "Elizabeth should be the monster at test ID");
        assertNotEquals(testDAO.getMonster(monsterID), originalMonster0001, "Carmilla shouldn't be at test ID");
    }

    @Test
    public void testRemoveMonster() {
        //ARRANGE
        final int monster1ID = 0001;
        Monster testMonster1 = new Monster("Carmilla", MonsterType.VAMPIRE, 69, "Black Pudding");
        final int monster2ID = 0002;
        Monster testMonster2 = new Monster("Elizabeth", MonsterType.LIZARDMAN, 35, "BBQ Squirrel");

        //ACT/ASSERT
        testDAO.addMonster(monster1ID, testMonster1);
        Monster addedMonster1 = testDAO.getMonster(monster1ID);
        testDAO.addMonster(monster2ID, testMonster2);
        Monster addedMonster2 = testDAO.getMonster(monster2ID);

        //full roster
        List<Monster> monsterRoster = testDAO.getAllMonsters();
        assertFalse(monsterRoster.isEmpty(), "Monster Roster shouldn't be empty");
        assertEquals(2, monsterRoster.size(), "Monster Roster should have exactly 2 monsters");
        assertTrue(monsterRoster.contains(addedMonster1), "Roster should contain Carmilla");
        assertTrue(monsterRoster.contains(addedMonster2), "Roster should contain Elizabeth");

        //remove 1st test monster
        testDAO.removeMonster(monster1ID);
        monsterRoster = testDAO.getAllMonsters();
        assertFalse(monsterRoster.contains(addedMonster1), "Carmilla shouldn't be in roster anymore");
        assertTrue(monsterRoster.contains(addedMonster2), "Roster should contain Elizabeth");
        assertFalse(monsterRoster.isEmpty(), "Monster Roster shouldn't be empty");
        assertEquals(1, monsterRoster.size(), "Monster Roster should have exactly 1 monsters after removal");

        //remove last test
        testDAO.removeMonster(monster2ID);
        monsterRoster = testDAO.getAllMonsters();
        assertTrue(monsterRoster.isEmpty(), "Monster Roster should be empty after second removal");
        assertFalse(monsterRoster.contains(addedMonster1), "Carmilla shouldn't be in roster anymore");
        assertFalse(monsterRoster.contains(addedMonster2), "Elizabeth shouldn't be in roster anymore");
    }
}
