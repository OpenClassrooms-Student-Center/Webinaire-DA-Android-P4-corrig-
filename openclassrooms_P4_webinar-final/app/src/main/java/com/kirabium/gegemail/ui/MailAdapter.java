package com.kirabium.gegemail.ui;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kirabium.gegemail.R;
import com.kirabium.gegemail.model.Mail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class MailAdapter extends RecyclerView.Adapter<MailAdapter.ViewHolder> {

    private final ArrayList<Mail> mails;


    public MailAdapter(ArrayList<Mail> mails) {
        this.mails = mails;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mail, parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Mail mail = mails.get(position);
        viewHolder.displayMail(mail);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mails.size();
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView recipient;
        public final TextView content;
        public final TextView date;
        public final TextView subject;
        public final TextView letter;

        public ViewHolder(View view) {
            super(view);
            letter = view.findViewById(R.id.letter);
            recipient = view.findViewById(R.id.recipient);
            content = view.findViewById(R.id.content);
            subject = view.findViewById(R.id.subject);
            date = view.findViewById(R.id.date);
        }

        public void displayMail(Mail mail) {
            SimpleDateFormat fmtOut = new SimpleDateFormat("dd-MM-yyyy");

            recipient.setText("To: " + mail.getRecipient());
            subject.setText(mail.getSubject());
            content.setText(mail.getText());
            date.setText(fmtOut.format(mail.getDate()));
            letter.setText("" + mail.getRecipient().charAt(0));
        }
    }
}
