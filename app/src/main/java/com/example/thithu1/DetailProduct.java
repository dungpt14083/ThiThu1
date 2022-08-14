package com.example.thithu1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailProduct extends AppCompatActivity {
    TextView tvpid,tvname,tvprice,tvcreate,tvupdate,tvtrungbinh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        tvpid = findViewById(R.id.tvpid);
        tvname = findViewById(R.id.tvname);
        tvprice = findViewById(R.id.tvprices);
        tvcreate = findViewById(R.id.tvcreat);
        tvupdate = findViewById(R.id.tvupdate);
        tvtrungbinh =findViewById(R.id.tvtrungbinh);
        Intent intent =getIntent();
        Bundle bundle =intent.getExtras();
        if(bundle!=null)
        {
            tvpid.setText("Pid: "+bundle.getInt("pid"));
            tvname.setText("name: "+bundle.getString("name"));
            tvprice.setText("price: "+bundle.getFloat("price"));
            tvcreate.setText("create_at: "+bundle.getString("create"));
            tvupdate.setText("update_at: "+bundle.getString("update"));
            tvtrungbinh.setText("Trung Bình giá sản Phẩm: "+bundle.getFloat("trungbinh"));
        }
    }
}