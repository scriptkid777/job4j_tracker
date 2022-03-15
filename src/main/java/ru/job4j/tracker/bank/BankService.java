package ru.job4j.tracker.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс показывает работу очереди по ключу. В указанном класе реализованны
 * методы способные добавлять пользователя, открывать счет, переводить средства
 * между счетами
 *
 * @author OnufrienkoI
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение задания осуществляется в коллекции HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в список
     * абонентов
     *
     * @param user пользователь который добавляется в спиисок
     */
    public void addUser(User user) {
               users.putIfAbsent(user, new ArrayList<Account>());
        }

    /**
     * Метод добавляет к существующему пользователю аккаунт.
     * Если пользователь не найден, аккаунт не добавляется
     *
     * @param passport паспортные данные пользователя
     * @param account  акаунт который добавляется в список акаунтов
     */
    public void addAccount(String passport, Account account) {
      User user = findByPassport(passport);
        if (user != null) {
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
        }
    }

    /**
     * Метод принимает на вход данные паспорта и сравнивает с другими паспортными данными
     * пользователей. Если паспортные данные отсутсвуют то возвращает
     * null
     *
     * @param passport паспортные данные которые сравнивается с пользователями
     * @return возвращает пользователя если пользователь с указанными данными присутствует
     * и null если такого пользователя нет
     */
    public User findByPassport(String passport) {
        return users.keySet()
               .stream()
               .filter(s -> s.getPassport().equals(passport))
               .findFirst()
               .orElse(null);
    }

    /**
     * Метод рпринимает на вход паспортные данные и реквизиты счета и находит акаунт по
     * данным параметрам
     *
     * @param passport  паспортыне данные по которым ищут полььзователя
     * @param requisite реквизиты счета пользователя
     * @return возвращает акаунт из списка акаунтов если найден полььзователь и у него есть
     * открытый счет иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
         return users.get(user)
                 .stream()
                 .filter(s ->s.getRequisite().equals(requisite))
                 .findFirst()
                 .orElse(null);
        }
        return null;
}

    /**
     * Метод позволяет переводить средства с одного счета на другой
     *
     * @param srcPassport   паспортны еданные пользователя, с которого
     *                      будут списаны деньги
     * @param srcRequisite  реквизиты счета отправителя
     * @param destPassport  паспортные данные получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount        сумма списания с баланса отпрвителя и переведеная получателю
     * @return возвращает true  если перевод был осуществлен
     * и false в случае ошибки
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
          srcAccount.setBalance((srcAccount.getBalance() - amount));
          destAccount.setBalance(destAccount.getBalance() + amount);
          rsl = true;
        }
        return rsl;
    }
}