package com.langleon.dsobuildsim.jewels;

import java.util.ArrayList;
import java.util.List;

public class JewelTrinket {

    private List<Jewel> jewels;

    public JewelTrinket(List<Jewel> jewels) {
        this.jewels = jewels;
    }

    public JewelTrinket() {
        this.jewels = new ArrayList<>();
    }

    public List<Jewel> getJewels() {
        return this.jewels;
    }

    public void addJewel(Jewel jewel){
        if (this.jewels.size()<10){
            this.jewels.add(jewel);
        }else{
            throw new IllegalArgumentException("Can't add more than 10 jewels to a jewel trinket.");
        }
    }

    public void removeJewel(Jewel jewel){
        this.jewels.remove(jewel);
    }
}
