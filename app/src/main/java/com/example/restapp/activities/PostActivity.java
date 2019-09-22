package com.example.restapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.restapp.R;
import com.example.restapp.entities.Post;
import com.example.restapp.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private static final String TAG = "PostActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        enviarConsultaRest();
    }

    private void enviarConsultaRest() {
        Post post = new Post(1, "teste", "Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem Lorem " +
                "Lorem Lorem Lorem Lorem Lorem Lorem Lorem ");
        RetrofitService.getServico().criarpost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                int cod = response.code();
                int id = response.body().getId();

                ((TextView)findViewById(R.id.textViewexibirId)).setText(""+id);
                ((TextView)findViewById(R.id.textView7)).setText(""+cod);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "OnFailure"+ t.getMessage());
            }
        });
    }
}
