package com.example.educationalinstitutemanagementsystem;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class MyAdapter_Notice extends RecyclerView.Adapter<MyAdapter_Notice.MyViewHolder> {

    ArrayList<Model_Notice> mList;
    Context context;

    public MyAdapter_Notice (Context context , ArrayList<Model_Notice> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_notice , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model_Notice model1 = mList.get(position);
        holder.date.setText(model1.getDate());
        holder.publisher.setText(model1.getPublisher());
        holder.notice.setText(model1.getNotice());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView date,publisher,notice;;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date= itemView.findViewById(R.id.date_it);
            publisher = itemView.findViewById(R.id.publisher_it);
            notice= itemView.findViewById(R.id.Notice_it);
        }
    }
}