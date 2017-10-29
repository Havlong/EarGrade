package com.eargrade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Dmitry on 29.10.2017.
 */

@Entity
public class RecordModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotEmpty
    public String username;

    @Transient
    public int score;

}
