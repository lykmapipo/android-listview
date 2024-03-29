package com.github.lykmapipo.listview.sample;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // show state view
        findViewById(R.id.btnStateView).setOnClickListener(v -> {
            startActivity(new Intent(this, StateViewActivity.class));
        });

        // show loading view
        findViewById(R.id.btnLoadingView).setOnClickListener(v -> {
            startActivity(new Intent(this, LoadingViewActivity.class));
        });

        // show state layout
        findViewById(R.id.btnStateLayout).setOnClickListener(v -> {
            startActivity(new Intent(this, StateLayoutActivity.class));
        });

        // show dialog value picker
        findViewById(R.id.btnSimpleList).setOnClickListener(v -> {
        });

        // show bottom sheet value picker
        findViewById(R.id.btnPagedList).setOnClickListener(v -> {
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private List<Contact> getContactList() {
        List<Contact> contacts = new ArrayList<Contact>();

        for (int i = 0; i < 10; i++) {
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String phone = faker.phoneNumber().phoneNumber();
            Contact contact = new Contact(name, phone);
            contacts.add(contact);
        }

        return contacts;
    }

    class Contact {
        String name;
        String phone;

        public Contact(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        @NonNull
        public String getId() {
            return phone;
        }

        @NonNull
        public String getName() {
            return name;
        }

        @Nullable
        public String getDescription() {
            return phone;
        }

        @Nullable
        public String getColor() {
            return null;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
}
