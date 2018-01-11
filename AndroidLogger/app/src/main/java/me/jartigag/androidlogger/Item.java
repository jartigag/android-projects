package me.jartigag.androidlogger;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

@Entity
public class Item {

    @NotNull
    private String event;

    @NotNull
    private Date date;

    @Generated(hash = 1938907575)
    public Item(@NotNull String event, @NotNull Date date) {
        this.event = event;
        this.date = date;
    }

    @Generated(hash = 1470900980)
    public Item() {
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

