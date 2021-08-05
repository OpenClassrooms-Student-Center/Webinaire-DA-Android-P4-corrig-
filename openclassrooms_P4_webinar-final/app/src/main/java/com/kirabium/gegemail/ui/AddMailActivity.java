package com.kirabium.gegemail.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.kirabium.gegemail.DI.DI;
import com.kirabium.gegemail.R;
import com.kirabium.gegemail.databinding.ActivityAddMailBinding;
import com.kirabium.gegemail.databinding.ActivityMainBinding;
import com.kirabium.gegemail.model.Mail;
import com.kirabium.gegemail.service.MailApiService;

public class AddMailActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAddMailBinding binding;
    private MailApiService mMailApiService = DI.getMailApiService();

    private void initUI() {
        binding = ActivityAddMailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setButton();
        getSupportActionBar().setTitle("New mail");
    }

    private void setButton() {
        binding.submitButton.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    @Override
    public void onClick(View view) {
        if (view == binding.submitButton) {
            onSubmit();
        }
    }

    private void onSubmit() {
        String recipient = binding.textFieldRecipient.getEditText().getText().toString();
        String subject = binding.textFieldSubject.getEditText().getText().toString();
        String content = binding.textFieldContent.getEditText().getText().toString();

        if (recipient.isEmpty()) {
            binding.textFieldRecipient.setError("Please type a recipient");
            return;
        }
        if (subject.isEmpty()) {
            binding.textFieldSubject.setError("Please type a subject");
            return;
        }
        if (content.isEmpty()) {
            binding.textFieldContent.setError("Please type a text");
            return;
        }

        mMailApiService.createMail(new Mail(subject, content, recipient));
        Toast.makeText(this, "Mail sent !", Toast.LENGTH_SHORT).show();
        finish();

    }
}