package com.langleon.dsobuildsim.dragonstones;

public class DragonCrestTrinket {

    private DragonStone[] dragonStones;

    public DragonCrestTrinket() {
        this.dragonStones = new DragonStone[10];
    }

    public DragonStone[] getDragonStones() {
        return dragonStones;
    }

    public void addDragonStone(DragonStone dragonStone, int slot)
    {
        if (dragonStone==null) throw new IllegalArgumentException("Dragon Stone is null!");
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        dragonStones[slot] = dragonStone;
    }

    public void removeDragonStone(int slot)
    {
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        dragonStones[slot] = null;
    }
}
