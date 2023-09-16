package com.gildedrose.filter;

import com.gildedrose.Item;
import com.gildedrose.func.DecreaseFunction;

public abstract class ItemFilter {
    // TODO: 2023-09-13 quality의 감소를 인터페이스로 빼서, 단순히 값으로만 비교하는 게 아니라 1배, 2배, 2*2배 등 으로 관리한다는 아이디어
    protected static boolean isItemChanged = false;
    protected static synchronized void markItemChanged(){
        isItemChanged = true;
    }
    protected static synchronized void setItemChangedFalse(){
        isItemChanged = false;
    }

    public void filterItem(Item item){
        if (isItemChanged) return;
        doFilter(item);
    }

    protected abstract void doFilter(Item item);

    protected void doubleDecreaseQuality(Item item){
        item.quality -= 2;
        if (item.quality < 0) item.quality = 0;
    }

    protected void decreaseQuality(Item item){
        item.quality--;
        if (item.quality < 0) item.quality = 0;
    }

    public void decreaseByCondition(DecreaseFunction decreaseFunction, Item item, ItemFilter itemFilter){
        item.quality -= decreaseFunction.decrease(itemFilter);
    }

    private int increaseQualityBySellIn(int sellIn){
        if (sellIn > 5 && sellIn <= 10) {
            return 2;
        }
        if (sellIn <= 5){
            return 3;
        }
        return 1;
    }

    // TODO: 2023/09/13 Filter의 인스턴스가 아닌 Item에 대한 판별 로직이 들어가야 함. 그걸 여기서 하는것이 맞는지?
    public void decreaseQuality(Item item, ItemFilter itemFilter){
        decreaseByCondition(filter -> {
            int count = 1;
            if (filter instanceof SulfurasFilter) return 0;
            if (filter instanceof AgedBrieFilter && item.quality < 50) return -count;
            if (filter instanceof BackstagePassFilter) count = increaseQualityBySellIn(item.sellIn);
            if (filter instanceof ConjuredItemFilter) count *= 2;
            return count;
        }, item, itemFilter);
    }
}
