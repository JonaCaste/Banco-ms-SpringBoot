package com.misiontic.AccountMS.controllers;

import com.misiontic.AccountMS.models.Account;
import com.misiontic.AccountMS.exceptions.AccountNotFoundException;
import com.misiontic.AccountMS.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /*
    * Obtener una cuenta por Username
    *
    * Tipo : GET
    * url: /accounts/{username}
    * Path Variable: le mando el username en el link
    * Que me debe devolver: Cuenta
    *
    * */

    //endpoint
    /*@GetMapping("/accounts/{username}")
    public Account getAccount(@PathVariable String username){
        return this.repository = repository;
    }*/

    //Metodo cuando no estamos seguros de que tipo vamos a recibir
        //por ejemplo si no existe
    /*@GetMapping("/accounts/{username}")
    public Optional<Account> getAccount(@PathVariable String username){
        return this.accountRepository.findById(username);
    }*/
    @GetMapping("/accounts/{username}")
    public Account getAccount(@PathVariable String username){
        return this.accountRepository.findById(username)
                .orElseThrow(() -> new AccountNotFoundException("La cuenta no existe"));
        //en lugar del optiona, retornamos un mensaje personalizado si no existe
    }


    /*
     * Obtener una cuenta por Username
     *
     * Tipo : POST
     * url: /accounts
     * RequestBody: le mando info en el body
     * Que me debe devolver: Cuenta
     *
     * */
    @PostMapping("/accounts")
    public Account newAccount(@RequestBody Account account){
        return this.accountRepository.save(account);
    }


    /*
     * Obtener una cuenta por Username
     *
     * Tipo : DELETE
     * url: /accounts/{username}
     * Recibe: username
     * Path Variable: le mando el username en el link
     * Que me debe devolver: nada
     *
     * */
    @DeleteMapping("/accounts/{username}")
    public void deleteAccount(@PathVariable String username){
        accountRepository.deleteById(username);
    }

    /*
     * Obtener una cuenta por Username
     *
     * Tipo : PUT
     * url: /accounts/{username}
     * Recibe: Account (objeto tipo cuenta)
     * Path Variable: le mando el username en el link
     * RequestBody: le mando info en el body
     * Que me debe devolver: Account
     *
     * */
    @PutMapping("/accounts/{username}")
    public Account updateAccount(@PathVariable String username, @RequestBody Account new_account){
        Account old_account = accountRepository.findById(username).orElse(null);
        // .orElse similar a Optional <>


        //ACTUALIZAMOS EL OBJETO EN JAVA

        //old_account.balance = new_account.balance;
        //genera error por que los atributos son privados, utilizamos los setters y los getterrs
        old_account.setBalance(new_account.getBalance());
        old_account.setLastChange(new_account.getLastChange());
        //el id nunca se actualiza


        //GUARDAMOS EN LA DB
        return accountRepository.save(old_account);
    }
}
