package com.example.thithu1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thithu1.DetailProduct;
import com.example.thithu1.Product;
import com.example.thithu1.R;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.AdapterViewHodel> {
    Context context;
   List<Product> products;
public float a =0;
    public AdapterProduct(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public AdapterViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_danhsach,parent,false);
        return new AdapterViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHodel holder, int position) {

        Product product1 = products.get(position);
        if(product1 ==null)
        {
            return;
        }
        holder.tvpid.setText("pid "+product1.getPid());
        int so = product1.getPid();
        if(so  %2==0)
        {
            holder.imgstart.setImageResource(R.drawable.ic_start);

        }

        for (Product p:products) {


         //   p.getPrice();
             a = a+p.getPrice();
        }
        holder.tvname.setText("pid "+product1.getName());
        holder.tvprice.setText("pid "+product1.getPrice());
        holder.crvdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, DetailProduct.class);
                Bundle bundle = new Bundle();
                bundle.putInt("pid",product1.getPid());
                bundle.putString("name",product1.getName());
                bundle.putFloat("price",product1.getPrice());
                bundle.putString("create",product1.getCreated_at());
                bundle.putString("update",product1.getUpdated_at());
                bundle.putFloat("trungbinh",a);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class AdapterViewHodel extends RecyclerView.ViewHolder{
        TextView tvpid,tvname,tvprice;
        ImageView imgstart;
        CardView crvdata;

        public AdapterViewHodel(@NonNull View itemView) {
            super(itemView);
            tvpid = itemView.findViewById(R.id.tvidds);
            tvname = itemView.findViewById(R.id.tvnameds1);
            tvprice = itemView.findViewById(R.id.tvpriceds1);
            imgstart = itemView.findViewById(R.id.imgidds);
            crvdata = itemView.findViewById(R.id.cardviewdata);
           // tvname = itemView.findViewById(R.id.tvname);
           // tvprice = itemView.findViewById(R.id.tvprices);
           // tvcreat = itemView.findViewById(R.id.tvcreat);
           // tvupdate = itemView.findViewById(R.id.tvupdate);
          //  crvdata = itemView.findViewById(R.id.cardviewdata);

        }
    }

}
