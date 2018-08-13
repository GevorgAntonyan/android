package com.instigatemobile.gsonlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<People> list = new ArrayList<>();
    public  static final String LAT = "lat";
    public  static final String LNG = "lng";
    Context context;

    public CustomAdapter(MainActivity mainActivity, List<People> list) {
        this.list = list;
        context = mainActivity;
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 1:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
                viewHolder = new MyViewHolder1(view1);
                break;
            case 0:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list2, parent, false);
                viewHolder = new MyViewHolder2(view2);
                break;
        }


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        People people = list.get(position);
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case 1:
                ((MyViewHolder1)holder).name.setText(people.getName());
                Picasso.get().load("http://icons.iconarchive.com/icons/icons-land/vista-people/256/Person-Male-Light-icon.png")
                        .into(((MyViewHolder1)holder).image);
                break;
            case 0:
                ((MyViewHolder2)holder).name.setText(people.getName());
                Picasso.get().load("http://icons.iconarchive.com/icons/icons-land/vista-people/256/Office-Customer-Female-Light-icon.png")
                        .into(((MyViewHolder2)holder).image);
                break;
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView name;
        de.hdodenhof.circleimageview.CircleImageView image;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            FrameLayout view = itemView.findViewById(R.id.male);
            view.setVisibility(View.VISIBLE);
            image = itemView.findViewById(R.id.imageMale);
            name = itemView.findViewById(R.id.malename);
        }
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView name;
        de.hdodenhof.circleimageview.CircleImageView image;
        ImageView call;
        ImageView mail;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            FrameLayout view = itemView.findViewById(R.id.female);
            view.setVisibility(View.VISIBLE);
            image = itemView.findViewById(R.id.imageFemale);
            call = itemView.findViewById(R.id.call);
            mail = itemView.findViewById(R.id.email);
            name = itemView.findViewById(R.id.femaleName);
            call.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onClick(View view) {
                    String uri = "tel:" + list.get(getAdapterPosition()).getPhone();
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(uri));
                    context.startActivity(intent);
                }
            });

            mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, list.get(getAdapterPosition()).getEmail());
                    email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    email.putExtra(Intent.EXTRA_TEXT, "message");
                    email.setType("message/rfc822");
                    context.startActivity(Intent.createChooser(email, "Choose an Email client :"));
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    JSONObject jo = new JSONObject();
                    try {
                        jo = (list.get(getAdapterPosition()).getAddress());
                        Intent intent = new Intent(context, Map.class);
                        intent.putExtra(LAT, jo.getString(LAT));
                        intent.putExtra(LNG, jo.getString(LNG));
                        context.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                       }
            });
        }

    }

}