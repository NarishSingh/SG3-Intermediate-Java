/*
All tests fail
First test won't even run
 */
package com.sg.testing.dao.implementations.buggy;

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
public class BadMonsterDaoATest {

    MonsterDao badTestDAO;

    public BadMonsterDaoATest() {
    }

    @BeforeEach
    public void setUp() {
        badTestDAO = new BadMonsterDaoA(); //keeps DAO clean and empty per test
    }

    @Test
    public void testAddGetMonster() {
        //NOTE: there is no way to even run this test, cannot access the ID from badTestDao

        //ARRANGE
        Monster testMonster1 = new Monster("Carmilla", MonsterType.VAMPIRE, 69, "Black Pudding");

        //ACT
        badTestDAO.addMonster(badTestDAO.id, testMonster1);
        Monster addedMonster = badTestDAO.getMonster(BadMonsterDaoATest);

        //ASSERT
        assertEquals(badTestDAO.getMonster(BadMonsterDaoATest), addedMonster, "Carmilla should be the added monster");
    }

    @Test
    public void testGetAllMonsters() {
        //ARRANGE
        final int monster1ID = 0001;
        Monster testMonster1 = new Monster("Carmilla", MonsterType.VAMPIRE, 69, "Black Pudding");
        final int monster2ID = 0002;
        Monster testMonster2 = new Monster("Elizabeth", MonsterType.LIZARDMAN, 35, "BBQ Squirrel");

        //ACT
        badTestDAO.addMonster(monster1ID, testMonster1);
        Monster addedMonster1 = badTestDAO.getMonster(monster1ID);
        badTestDAO.addMonster(monster2ID, testMonster2);
        Monster addedMonster2 = badTestDAO.getMonster(monster2ID);

        List<Monster> monsterRoster = badTestDAO.getAllMonsters();

        //ASSERT
        assertEquals(badTestDAO.getMonster(monster1ID), addedMonster1, "Carmilla should be the first added monster");
        assertEquals(badTestDAO.getMonster(monster2ID), addedMonster2, "Elizabeth should be the second added monster");

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
        badTestDAO.addMonster(monsterID, testMonster1);
        Monster originalMonster0001 = badTestDAO.getMonster(monsterID);

        badTestDAO.updateMonster(monsterID, testMonster2);
        Monster newMonster0001 = badTestDAO.getMonster(monsterID);

        List<Monster> monsterRoster = badTestDAO.getAllMonsters();

        //ASSERT
        assertFalse(monsterRoster.contains(originalMonster0001), "Carmilla should no longer be in roster");
        assertTrue(monsterRoster.contains(newMonster0001), "Elizabeth should be in Roster");
        assertEquals(badTestDAO.getMonster(monsterID), newMonster0001, "Elizabeth should be the monster at test ID");
        assertNotEquals(badTestDAO.getMonster(monsterID), originalMonster0001, "Carmilla shouldn't be at test ID");
    }

    @Test
    public void testRemoveMonster() {
        //ARRANGE
        final int monster1ID = 0001;
        Monster testMonster1 = new Monster("Carmilla", MonsterType.VAMPIRE, 69, "Black Pudding");
        final int monster2ID = 0002;
        Monster testMonster2 = new Monster("Elizabeth", MonsterType.LIZARDMAN, 35, "BBQ Squirrel");

        //ACT/ASSERT
        badTestDAO.addMonster(monster1ID, testMonster1);
        Monster addedMonster1 = badTestDAO.getMonster(monster1ID);
        badTestDAO.addMonster(monster2ID, testMonster2);
        Monster addedMonster2 = badTestDAO.getMonster(monster2ID);

        //full roster
        List<Monster> monsterRoster = badTestDAO.getAllMonsters();
        assertFalse(monsterRoster.isEmpty(), "Monster Roster shouldn't be empty");
        assertEquals(2, monsterRoster.size(), "Monster Roster should have exactly 2 monsters");
        assertTrue(monsterRoster.contains(addedMonster1), "Roster should contain Carmilla");
        assertTrue(monsterRoster.contains(addedMonster2), "Roster should contain Elizabeth");

        //remove 1st test monster
        badTestDAO.removeMonster(monster1ID);
        monsterRoster = badTestDAO.getAllMonsters();
        assertFalse(monsterRoster.contains(addedMonster1), "Carmilla shouldn't be in roster anymore");
        assertTrue(monsterRoster.contains(addedMonster2), "Roster should contain Elizabeth");
        assertFalse(monsterRoster.isEmpty(), "Monster Roster shouldn't be empty");
        assertEquals(1, monsterRoster.size(), "Monster Roster should have exactly 1 monsters after removal");

        //remove last test
        badTestDAO.removeMonster(monster2ID);
        monsterRoster = badTestDAO.getAllMonsters();
        assertTrue(monsterRoster.isEmpty(), "Monster Roster should be empty after second removal");
        assertFalse(monsterRoster.contains(addedMonster1), "Carmilla shouldn't be in roster anymore");
        assertFalse(monsterRoster.contains(addedMonster2), "Elizabeth shouldn't be in roster anymore");
    }
}
