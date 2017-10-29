package com.eargrade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Created by Dmitry on 29.10.2017.
 */

@Entity
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotEmpty
    @Size(min = 4, max = 26, message = "Username должен быть от 4 до 26 символов")
    public String username;

    @Transient
    public String lastMelody;

    public void setUsername(String user) {
        username = user;
    }

    public void  setLastMelody(String melody) {
        lastMelody = melody;
    }

}
