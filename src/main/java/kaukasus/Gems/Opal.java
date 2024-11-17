package kaukasus.Gems;

import java.util.ArrayList;
import java.util.List;

public class Opal extends AbstractGem{
    List<Gem> gems = new ArrayList<>();

    public Opal(Gem gem1, Gem gem2, Gem gem3){
        gem1.setValue(gem1.getValue()*0.75);
        gems.add(gem1);
        gem2.setValue(gem2.getValue()*0.75);
        gems.add(gem2);
        gem3.setValue(gem3.getValue()*0.75);
        gems.add(gem3);
    }

    public List<Gem> getGems(){
        return gems;
    }
}
