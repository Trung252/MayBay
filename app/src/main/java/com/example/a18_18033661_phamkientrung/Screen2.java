package com.example.a18_18033661_phamkientrung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a18_18033661_phamkientrung.Entity.Burger;

import java.util.HashMap;
import java.util.Map;

public class Screen2 extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnAdd, btnMinus;
    int i = 1;
    Burger burger;
    TextView tvGia, tvTen, tvCount, tvAddToCart;
    ImageView imgHinh;

    String url = "https://60ce2e5191cc8e00178dcb16.mockapi.io/fashion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("entity");
        burger = (Burger) bundle.getSerializable("fashion");

        MappingId();

        tvGia.setText("$" + String.valueOf(burger.getGia()));
        tvTen.setText(burger.getTen());
        imgHinh.setImageResource(burger.getHinh());

        btnAdd.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        tvAddToCart.setOnClickListener(this);
    }

    private void MappingId() {
        tvGia = findViewById(R.id.textView_cost);
        tvTen = findViewById(R.id.textView_name);
        tvCount = findViewById(R.id.count);
        //tvAddToCart = findViewById(R.id.tvAddToCart);

        btnAdd = findViewById(R.id.cong);
        btnMinus = findViewById(R.id.tru);

        imgHinh = findViewById(R.id.imgHinh);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnAdd)) {
            i++;
            tvCount.setText(String.valueOf(i));
            tvGia.setText("$" + String.valueOf(burger.getGia() * i));
        }
        if (v.equals(btnMinus)) {
            if (i <= 0) {
                tvCount.setText("0");
            } else {
                i--;
                tvCount.setText(String.valueOf(i));
                tvGia.setText("$" + String.valueOf(burger.getGia() * i));
            }
        }
        if (v.equals(tvAddToCart)) {
            StringRequest stringRequest = new StringRequest(
                    Request.Method.POST,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(Screen2.this, "Add API successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Screen2.this, MainActivity.class));
                            finish();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Screen2.this, "Failed to add data!", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> params = new HashMap<>();
                    params.put("name", tvTen.getText().toString());
                    params.put("price", tvGia.getText().toString());
                    params.put("quantity", tvCount.getText().toString());
                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(Screen2.this);
            requestQueue.add(stringRequest);
        }
    }
}