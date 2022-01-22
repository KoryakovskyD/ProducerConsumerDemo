package ru.avalon.javapp.devj130;

public class Producer extends AbstractEntity{
    public Producer(String name, Warehouse warehouse) {
        super(name, warehouse);
    }

    @Override
    public void run() {
        while (true) {
            warehouse.storeGoods(this, 5 + rnd.nextInt(15), random(300, 500));
            pause(2_000, 3_000);
        }
    }
}
