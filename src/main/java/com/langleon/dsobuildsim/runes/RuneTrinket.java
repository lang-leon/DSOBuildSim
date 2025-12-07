package com.langleon.dsobuildsim.runes;

import java.util.ArrayList;
import java.util.List;

public class RuneTrinket {

    private List<Rune> runes;

    public RuneTrinket(List<Rune> rune) {
        this.runes = rune;
    }

    public RuneTrinket() {
        this.runes = new ArrayList<>();
    }

    public List<Rune> getRunes() {
        return this.runes;
    }

    public void addRune(Rune rune){
        if (this.runes.size()<10){
            this.runes.add(rune);
        }else{
            throw new IllegalArgumentException("Can't add more than 10 runes to a rune trinket.");
        }
    }

    public void removeRune(Rune rune){
        this.runes.remove(rune);
    }
}
