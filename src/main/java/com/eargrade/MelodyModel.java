package com.eargrade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Dmitry on 29.10.2017.
 */

@Entity
public class MelodyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    public String melodyName;

    @NotNull
    public byte[] midiButtons;

    @NotNull
    public byte[] midiLength;

}
