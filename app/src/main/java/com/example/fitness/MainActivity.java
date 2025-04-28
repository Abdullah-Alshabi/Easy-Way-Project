package com.example.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());  // تهيئة الـ ViewBinding
        setContentView(binding.getRoot());  // تعيين الـ root view

        // إعداد Firebase
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference reference = db.getReference("Users");

        // عند الضغط على زر "Sign up"
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.SignUpName.getText().toString();
                String email = binding.SignUpEmail.getText().toString();
                String password = binding.SignUpPassword.getText().toString();
                String confirmPass = binding.SignUpConfirmPassword.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPass.isEmpty()) {
                    Users users = new Users(name, email, password, confirmPass);
                    reference.child(email.replace(".", ",")).setValue(users)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    binding.SignUpName.setText("");
                                    binding.SignUpEmail.setText("");
                                    binding.SignUpPassword.setText("");
                                    binding.SignUpConfirmPassword.setText("");
                                    if (task.isSuccessful() && password == confirmPass) {
                                        Toast.makeText(MainActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, Calculate.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });



    }
}
