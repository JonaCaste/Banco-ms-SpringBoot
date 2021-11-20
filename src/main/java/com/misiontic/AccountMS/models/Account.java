package com.misiontic.AccountMS.models;

import java.util.Date;
import org.springframework.data.annotation.Id;

public class Account {

    @Id                         //decorador para convertir username a PK
    private String username;
    private Integer balance;    //como manejamos string no se crea un dato primitivo
                                //spring espera la clase de los datos
    private Date lastChange;

    public Account(String username, Integer balance, Date lastChange){
        this.username = username;
        this.balance = balance;
        this.lastChange = lastChange;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}
