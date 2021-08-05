package com.kirabium.gegemail.service;


import com.kirabium.gegemail.model.Mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

abstract class DummyMailGenerator {

    public static List<Mail> DUMMY_MAILS = Arrays.asList(new Mail("Réunion", "nouvelle réunion demain soir à 19h", "toto@gegemail.com", new Date(1626557205000L)),
            new Mail("Financement", "votre financement va se terminer dans 1 jour", "toto@gegemail.com", new Date(1626557205000L)),
            new Mail("Webinar", "nouveau webinar demain soir à 19h", "titi@gegemail.com", new Date(1626557205000L)),
            new Mail("Raclette", "raclette demain soir à 20h", "hugue@gegemail.com", new Date(1626384405000L)),
            new Mail("Réunion", "nouvelle réunion demain soir à 19h", "toto@gegemail.com", new Date(1626557205000L)),
            new Mail("Financement", "votre financement va se terminer dans 2 jours", "toto@gegemail.com", new Date(1626470805000L)),
            new Mail("Réunion", "nouvelle réunion demain soir à 19h", "toto@gegemail.com", new Date(1626384405000L)),
            new Mail("Financement", "votre financement va se terminer dans 3 jours", "toto@gegemail.com", new Date(1626384405000L)));

    static List<Mail> generateMails() {
        return new ArrayList<>(DUMMY_MAILS);
    }
}
