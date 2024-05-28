package com.example.samplejsonparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView txtTitle,txtId,txtUserId,txtPostBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        Gson gson = new Gson();
        String json = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}";
        Post post = gson.fromJson(json,Post.class);
        Log.d(TAG, "onCreate: post title" + post.getTitle());

        txtTitle.setText(post.getTitle());
        txtUserId.setText(String.valueOf(post.getUserid()));
        txtPostBody.setText(post.getBody());
        txtId.setText(String.valueOf(post.getId()));

        Post secondpost = new Post(2, 3, "WE WILL KEEP TRYING" , "TULISHARISK TUTAJARIBU TENA");
        String second =  gson.toJson(secondpost);
        Log.d(TAG, "onCreate: post" +second);

    }
    private void initViews()
    {
        Log.d(TAG, "initViews: started");
        txtTitle = (TextView) findViewById(R.id.title);
        txtId = (TextView) findViewById(R.id.postid);
        txtUserId = (TextView) findViewById(R.id.userId);
        txtPostBody = (TextView) findViewById(R.id.postbody);
    }
}