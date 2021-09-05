class Bank {
    // переменная, которая хранит все счета
    ThreadLocal<Integer> account = ThreadLocal.withInitial(() -> 0);

    public void transfer(int diff) {
        System.out.println("Перевод на счет клиента " +
                Thread.currentThread().getName());
// Получаем сумму, лежающую на счете
        Integer money = account.get();
// Расчитываем итоговую сумму после перевода
        int result = money + diff;
// Сохраняем расчет
        account.set(result);
        System.out.printf("Перевод на счет клиента %s удался. Теперь на счете %d рублей.\n");
        Thread.currentThread()
                .getName(), account.get())
    }
}