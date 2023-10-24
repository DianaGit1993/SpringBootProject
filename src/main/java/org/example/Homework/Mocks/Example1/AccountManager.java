package org.example.Homework.Mocks.Example1;

import org.example.Homework.Mocks.Example1.Account;

public interface AccountManager {
    Account findAccountForUser(String userId);
    void updateAccount(Account account);
}
