package ru.avalon.javapp.devj130;

public class Warehouse {
    private int amount;

    public void storeGoods(Producer p, int amount, int loadTime) {
        try {
            Thread.sleep(loadTime);
        } catch (InterruptedException e) {
        }
        synchronized (this) {
            System.out.printf("%s wants to load %d units of goods.%n", p.getName(), amount);
            this.amount +=amount;
            notifyAll();
            System.out.printf("%s loaded it goods. Balance now in %d. %n", p.getName(), this.amount);
        }
    }

    public void consumerGoods(Consumer c, int amount, int consumerTime) {

        synchronized (this) {
            System.out.printf("%s wants to take %d units of goods. %n", c.getName(), amount);
            while (amount > this.amount) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            this.amount -= amount;
            System.out.printf("%s has taken it goods. Balance now is %d. %n", c.getName(), this.amount);
        }
    }
}
