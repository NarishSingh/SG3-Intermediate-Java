/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.sg.testing.dao.implementations.buggy;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadMonsterDaoA implements MonsterDao {

    Map<Integer, Monster> monsters = new HashMap<>();
    int id; //objects shouldn't have to store their own ID, HashMap already does
    
    @Override
    public Monster addMonster(int i, Monster m) { //parameter int i isn't used
        return monsters.put(id, m); //we don't have a constructor, how will we get the ID now?
    }

    @Override
    public Monster getMonster(int id) {
       Monster m = monsters.get(id); //creation of m is inefficient
       return m; //this is ok on its own...but we will never get to see any monsters bc of bad add method
    }

    @Override
    public List<Monster> getAllMonsters() {
        List<Monster> monsterList = new ArrayList<>(); //creation of monsterList is inefficient
        monsterList.addAll(monsters.values());
        return monsterList; //won't see anything
    }

    @Override
    public void updateMonster(int id, Monster m) { //finally got the param right
        monsters.replace(id, m); //will be replacing null
    }

    @Override
    public Monster removeMonster(int id) {
        Monster m = monsters.remove(id); //creation of m is inefficient
        return m;
    }
    
}
