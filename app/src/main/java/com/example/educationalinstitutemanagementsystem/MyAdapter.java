package com.example.educationalinstitutemanagementsystem;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Model> mList;
    Context context;

    public MyAdapter(Context context , ArrayList<Model> mList){

        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item , parent ,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model model = mList.get(position);
        holder.roll.setText(model.getRoll());
        holder.course_code.setText(model.getCourse_code());
        holder.mark.setText(model.getMark());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView roll,course_code,mark;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            roll= itemView.findViewById(R.id.rollit);
            course_code = itemView.findViewById(R.id.course_codeit);
            mark = itemView.findViewById(R.id.markit);
        }
    }
}