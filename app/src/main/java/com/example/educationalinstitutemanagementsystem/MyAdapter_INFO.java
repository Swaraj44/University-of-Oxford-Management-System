package com.example.educationalinstitutemanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class MyAdapter_INFO extends RecyclerView.Adapter<MyAdapter_INFO.MyViewHolder> {

    ArrayList<Model_INFO> mList;
    Context context;

    public MyAdapter_INFO(Context context , ArrayList<Model_INFO> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_info , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model_INFO model = mList.get(position);
        holder.name.setText(model.getName());
       // holder.surname.setText(model.getSurname());
        holder.email.setText(model.getEmail());
        holder.mobile.setText(model.getMobile());
        holder.dept.setText(model.getDept());


        holder.mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+model.getMobile()));
                context.startActivity(intent);
            }
        });


        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + model.getEmail()));
                context.startActivity(Intent.createChooser(emailIntent, "Chooser Title"));

            }
        });



    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView  name,email,mobile,designation,dept;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_in);
            email = itemView.findViewById(R.id.email_in);
            mobile= itemView.findViewById(R.id.mobile_in);
            dept = itemView.findViewById(R.id.dept_in);
           // designation = itemView.findViewById(R.id.designation1);
            //surname = itemView.findViewById(R.id.surname_text);
            //email = itemView.findViewById(R.id.email_text);
        }
    }
}