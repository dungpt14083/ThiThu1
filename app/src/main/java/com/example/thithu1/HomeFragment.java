package com.example.thithu1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thithu1.Adapter.AdapterProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterProduct adapterProduct;
    private List<Product> data;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        recyclerView = view.findViewById(R.id.rcv);
        data = new ArrayList<>();
        adapterProduct = new AdapterProduct(getContext(),data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterProduct);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApliInterface apliInterface = retrofit.create(ApliInterface.class);
        Call<ListProduct> call = apliInterface.getJson();
        call.enqueue(new Callback<ListProduct>() {
            @Override
            public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {

                ListProduct listProduct =response.body();
                data = new ArrayList<>(Arrays.asList(listProduct.getProducts()));
                adapterProduct = new AdapterProduct(getContext(),data);
                Log.e("TAGID",  "data"+data );
                recyclerView.setAdapter(adapterProduct);
                adapterProduct.notifyDataSetChanged();



            }

            @Override
            public void onFailure(Call<ListProduct> call, Throwable t) {
                Log.e("LoiGETDATA", "onFailure: "+t );
                Toast.makeText(getContext(),"lõi "+t,Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }
}
