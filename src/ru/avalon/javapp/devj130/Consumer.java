package ru.avalon.javapp.devj130;

public class Consumer extends AbstractEntity{
    public Consumer(String name, Warehouse warehouse) {
        super(name, warehouse);
    }

    @Override
    public void run() {
        while (true) {
            pause(1_000, 2_000);
            warehouse.consumerGoods(this, 2 + rnd.nextInt(12), random(200,300));
        }
    }
}
