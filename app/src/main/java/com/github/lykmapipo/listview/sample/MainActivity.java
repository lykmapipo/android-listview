package com.github.lykmapipo.listview.sample;

import android.os.Bundle;
import android.widget.Button;

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

        // show dialog value picker
        Button btnDialogPicker = findViewById(R.id.btnSimpleList);
        btnDialogPicker.setOnClickListener(v -> {
        });

        // show bottom sheet value picker
        Button btnBottomSheetPicker = findViewById(R.id.btnPagedList);
        btnBottomSheetPicker.setOnClickListener(v -> {
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
