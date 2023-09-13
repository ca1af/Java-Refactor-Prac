package com.gildedrose.filter;

import com.gildedrose.Item;

public abstract class ItemFilter {
    // TODO: 2023-09-13 quality의 감소를 인터페이스로 빼서, 단순히 값으로만 비교하는 게 아니라 1배, 2배, 2*2배 등 으로 관리한다는 아이디어
    protected static boolean isItemChanged = false;
    protected static synchronized void markItemChanged(){
        isItemChanged = true;
    }

    protected static synchronized void initItemBoolean(){
        isItemChanged = false;
    }
    protected Item initialItem;

    protected Item item;

    protected ItemFilter() {
    }

    public void setInitialItem(Item item){
        this.initialItem = item;
    }

    abstract void filterItem(Item item);

    protected void doubleDecreaseQuality(Item item){
        item.quality -= 2;
        if (item.quality < 0) item.quality = 0;
    }

    protected void decreaseQuality(Item item){
        item.quality--;
        if (item.quality < 0) item.quality = 0;
    }
}
