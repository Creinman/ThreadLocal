public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Bank bank = new Bank();

        /*new Thread(null, () -> bank.transfer(500), "Клиент 1").start();
        new Thread(null, () -> bank.transfer(1500), "Клиент 2").start();
        new Thread(null, () -> bank.transfer(20), "Клиент 3").start();
*/
        Thread thread1 = new Thread(null, () -> account.transfer(500), "Клиент 1");
        Thread thread2 = new Thread(null, () -> account.transfer(200), "Клиент 2");
        Thread thread3 = new Thread(null, () -> account.transfer(300), "Клиент 3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread3.join();
        thread2.join();
        thread1.join();
        System.out.println("\nБаланс после всех переводов: " + account.getCurrent());
// example to use LongAdder
        /*ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder stat = new LongAdder();
        IntStream.range(0, 500)
                .forEach(i -> executorService.submit(() -> stat.add(i)));
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + stat.sum());
        executorService.shutdown();
*/
        // example to use LongAccumulator не соблюдается порядок

        /*ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongBinaryOperator operator = (x, y) -> x + y;
        LongAccumulator stat = new LongAccumulator(operator, 0L);
        IntStream.range(0, 500)
                .forEach(i -> executorService.submit(() -> stat.accumulate(i)));
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + stat.get());
        executorService.shutdown(); */

    }
}
