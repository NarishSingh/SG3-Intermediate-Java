/** *******************************
 * The Software Guild
 * Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
 ******************************** */
package com.sg.testing.dao.implementations.buggy;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadMonsterDaoB implements MonsterDao {

    Map<Integer, Monster> monsters = new HashMap<>();

    @Override
    public Monster addMonster(int id, Monster m) {
        return monsters.put(id, m);
    }

    @Override
    public Monster getMonster(int id) {
        if (monsters.containsKey(id)) {
            return monsters.get(id);
        } else {
            return null; //if-else is unnecessary, .get() will return null on its own if no key found
        }
    }

    @Override
    public List<Monster> getAllMonsters() {
        List<Monster> allDaMonsters = new ArrayList<>(monsters.values()); //var is inefficient, just return
        return allDaMonsters;
    }

    @Override
    public void updateMonster(int id, Monster m) {
        if (monsters.containsKey(id)) {
            Monster oldMonster = monsters.remove(id); //nothing is done with captured removed obj
            monsters.put(id, m);
        } //nothing happens if id invalid...
    }

    @Override
    public Monster removeMonster(int id) {
        Monster m = monsters.get(id); //var is inefficient
        return m;
    }

}
