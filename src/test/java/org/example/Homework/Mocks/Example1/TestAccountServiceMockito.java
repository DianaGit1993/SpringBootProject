package org.example.Homework.Mocks.Example1;


import org.example.Homework.Mocks.Example1.Account;
import org.example.Homework.Mocks.Example1.AccountManager;
import org.example.Homework.Mocks.Example1.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestAccountServiceMockito {


    @Mock
    private AccountManager mockAccountManager;

    @Test
    public void testTransferOk(){
        Account senderAccount=new Account("1",200);
        Account beneficiaryAccount=new Account("2",100);


        //declaring expectations with "when"
        Mockito.when(mockAccountManager.findAccountForUser("1"))
                .thenReturn(senderAccount);

        Mockito.when(mockAccountManager.findAccountForUser("2"))
                .thenReturn(beneficiaryAccount);

        AccountService accountService=new AccountService();
        accountService.setAccountManager(mockAccountManager);

        //when
        accountService.transfer("1","2",50);


        //
        Assertions.assertEquals(150,senderAccount.getBalance());
        Assertions.assertEquals(150,beneficiaryAccount.getBalance());
        Mockito.verify(mockAccountManager,Mockito.times(1)).findAccountForUser("1");
    }
}
