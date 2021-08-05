package com.kirabium.gegemail.service;


import com.kirabium.gegemail.model.Mail;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyMailApiService implements MailApiService {

    private final List<Mail> mails = DummyMailGenerator.generateMails();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mail> getMails() {
        return mails;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMail(Mail mail) {
        mails.remove(mail);
    }

    /**
     * {@inheritDoc}
     *
     * @param mail
     */
    @Override
    public void createMail(Mail mail) {
        mails.add(mail);
    }

    @Override
    public ArrayList<Mail> getMailsFilteredByDate(Date date) {
        ArrayList<Mail> result = new ArrayList<>();

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        for (int i = 0; i < mails.size(); i++) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(mails.get(i).getDate());
            boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                    cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
            if (sameDay) result.add(mails.get(i));

        }
        return result;
    }


}
