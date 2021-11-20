package com.misiontic.AccountMS.controllers;

import com.misiontic.AccountMS.models.Account;
import com.misiontic.AccountMS.models.Transaction;
import com.misiontic.AccountMS.exceptions.AccountNotFoundException;
import com.misiontic.AccountMS.repositories.AccountRepository;
import com.misiontic.AccountMS.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionController(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    /*
    * tipo: GET
    * url: /transactions/{usernameOrigin}
    * que recibe: usernameOrigin
    * donde recibe: Path
    * */
    @GetMapping("/transactions/{usernameOrigin}")
    List<Transaction> getTransactionByUsernameOrigin(@PathVariable String usernameOrigin){
        return transactionRepository.getByUsernameOrigin(usernameOrigin);
    }


    /*
     * tipo: POST
     * url: /transactions/
     * que recibe: info de transaccion
     * donde recibe: Body
     * */
    @PostMapping("/transaction/")
    Transaction newTransaction(@RequestBody Transaction transaction){

        //verificamos que las cuentas existan
        Account accountDestiny = accountRepository.findById(transaction.getUsernameDestiny()).orElse(null);
        Account accountOrigin = accountRepository.findById(transaction.getUsernameOrigin()).orElse(null);
        if(accountOrigin == null || accountDestiny == null){
            throw new AccountNotFoundException("La cuenta origen o la cuenta destino no existen");
        }

        //actualizamos los nuevos valores de las cuentas
        accountDestiny.setBalance(accountDestiny.getBalance() + transaction.getValue());
        accountOrigin.setBalance(accountOrigin.getBalance() - transaction.getValue());
        accountRepository.save(accountDestiny);
        accountRepository.save(accountOrigin);
        //lo guardamos en la db
        return transactionRepository.save(transaction);
    }
}
