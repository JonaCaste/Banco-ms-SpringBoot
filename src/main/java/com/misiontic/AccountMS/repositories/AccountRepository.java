package com.misiontic.AccountMS.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.misiontic.AccountMS.models.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
                                                          //modelo - tipo de dato de PK
    //metodos que heredamos
        //save - CU
        //delete - D
        //findById - R
        //findAll - R
    //si utilizaramos metodos poropios, tendriamos que escribirlos aca

}
