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

public class BadMonsterDaoD implements MonsterDao {

    Map<Integer, Monster> monsters = new HashMap<>();

    @Override
    public Monster addMonster(int id, Monster m) {
        Monster oldM = monsters.put(id, m);
        return oldM; //unnecessary, .put() already handles this return
    }

    @Override
    public Monster getMonster(int id) {
        Monster storedMonster = monsters.get(id);
        return storedMonster; //unnecessary, .get() already handles this return
    }

    @Override
    public List<Monster> getAllMonsters() {
        ArrayList<Monster> manyMonsters = new ArrayList<>();
        for (Monster m : monsters.values()) {
            manyMonsters.add(m);
        }
        return manyMonsters; //unnecessary, could be shortened
    }

    @Override
    public void updateMonster(int id, Monster m) {
        if (monsters.containsKey(id)) {
            monsters.remove(id);//unnecessary, .put() already handles overwriting the value at existing key
        }
        monsters.put(id, m);
    }

    @Override
    public Monster removeMonster(int id) {
        Monster removed = monsters.remove(id);
        return removed; //unnecessary, .remove() already handles this return
    }

}
