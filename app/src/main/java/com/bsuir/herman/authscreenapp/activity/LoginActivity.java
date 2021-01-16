package com.bsuir.herman.authscreenapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bsuir.herman.authscreenapp.NetworkService;
import com.bsuir.herman.authscreenapp.Validator;
import com.bsuir.herman.authscreenapp.databinding.ActivityLoginBinding;
import com.bsuir.herman.authscreenapp.dto.MessageDto;
import com.bsuir.herman.authscreenapp.model.Subject;

import java.io.IOException;

//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private String TAG = "TAG";
    private NetworkService networkService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        networkService = new NetworkService();

        setValidatorsOnEditTextField();

        binding.btnLoginScreenLogin.setOnClickListener(clickListener);

        binding.tvLoginScreenNotRegister.setOnClickListener(
                view1 -> {
                    Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                }
        );
    }


    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /**-----------------------------------------------------------------**/

            networkService.getApi()
                    .getMain()
                    .enqueue(new Callback<MessageDto>() {
                        @Override
                        public void onResponse(Call<MessageDto> call, Response<MessageDto> response) {
                            //Данные успешно пришли, но надо проверить response.body() на null
                            Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<MessageDto> call, Throwable t) {
                            //Произошла ошибка
                            Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
            /**-----------------------------------------------------------------**/
        }
    };

    private void setValidatorsOnEditTextField() {
        Validator v = new Validator();
        binding.etLoginScreenLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!v.matchEmail(editable.toString())) {
                    binding.tilLoginScreenLogin.setError("Error :)");
                } else binding.tilLoginScreenLogin.setError("");
            }
        });

        binding.etLoginScreenPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!v.matchPassword(editable.toString())) {
                    binding.tilLoginScreenPassword.setError("Error :)");
                } else binding.tilLoginScreenPassword.setError("");
            }
        });
    }
}