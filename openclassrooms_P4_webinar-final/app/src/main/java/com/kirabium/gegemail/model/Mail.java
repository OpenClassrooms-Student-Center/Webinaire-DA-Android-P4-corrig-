package com.kirabium.gegemail.model;

import java.util.Date;

public class Mail {
    String subject, text, recipient;
    Date mDate;

    public Mail(String subject, String text, String recipient) {
        this.subject = subject;
        this.text = text;
        this.recipient = recipient;
        this.mDate = new Date();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Mail(String subject, String text, String recipient, Date date) {
        this.subject = subject;
        this.text = text;
        this.recipient = recipient;
        mDate = date;
    }

}
