import java.util.concurrent.atomic.AtomicLong;

class Account {
    AtomicLong money = new AtomicLong(0);

    public void transfer(long diff) {
        System.out.printf("%s переводит вам %d рублей\n",
                Thread.currentThread().getName(), diff);
        long result = money.addAndGet(diff);
        System.out.printf("Теперь у вас на счету %d рублей\n", result);
    }

    public long getCurrent() {
        return money.get();
    }
}
