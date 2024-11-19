package kaukasus.Gems;

import java.util.ArrayList;
import java.util.List;

public class Opal extends AbstractGem{
    Gem gem1;
    Gem gem2;
    Gem gem3;

    public Opal(Gem gem1, Gem gem2, Gem gem3){
        gem1.setValue(gem1.getValue()*0.75);
        this.gem1 = gem1;
        gem2.setValue(gem2.getValue()*0.75);
        this.gem2 = gem2;
        gem3.setValue(gem3.getValue()*0.75);
        this.gem3 = gem3;
    }

    public List<Gem> getGems(){
        return List.of(this.gem1, this.gem2, this.gem3);
    }

    @Override
    public Opal copyGem()
    {
        return new Opal(this.gem1.copyGem(), this.gem2.copyGem(), this.gem3.copyGem());
    }
}
