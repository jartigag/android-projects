package me.jartigag.loginandrtemplate.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * Modelo Access: objeto que contiene info de cada acceso (email,fecha,accesoValido)
 */

@Entity
public class Access {

    @NotNull
    private String email;

    @NotNull
    private Date date;

    @NotNull
    private boolean valid;

    @Generated(hash = 26887892)
    public Access(@NotNull String email, @NotNull Date date, boolean valid) {
        this.email = email;
        this.date = date;
        this.valid = valid;
    }

    @Generated(hash = 1253708747)
    public Access() {
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
