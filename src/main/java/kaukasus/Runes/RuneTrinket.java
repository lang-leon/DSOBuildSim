package kaukasus.Runes;

import java.util.ArrayList;
import java.util.List;

public class RuneTrinket {

    private List<AbstractRune> runes;

    public RuneTrinket(List<AbstractRune> rune) {
        this.runes = rune;
    }

    public RuneTrinket() {
        this.runes = new ArrayList<>();
    }

    public List<AbstractRune> getRunes() {
        return this.runes;
    }

    public void addRune(AbstractRune rune){
        if (this.runes.size()<10){
            this.runes.add(rune);
        }else{
            throw new IllegalArgumentException("Can't add more than 10 runes to a rune trinket.");
        }
    }

    public void removeRune(AbstractRune rune){
        this.runes.remove(rune);
    }
}
