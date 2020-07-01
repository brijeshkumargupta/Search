package com.birjulabsinc.search.Program.Program;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.birjulabsinc.search.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    public static final String IMAGE="image";
    public static final String NAME="name";
    public static final String TITLE="id";
    public static final String DESC="desc";

    private Context context;
    private OnItemClickListener mListener;
    private ArrayList<Program> list;

    public Adapter(Context context,ArrayList<Program>list){


        this.context=context;
        this.list = list;
    }


    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

//    public void setOnItemClickListener(OnItemClickListener listener){
//        mListener=listener;
//
//    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardview,viewGroup, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.id.setText(list.get(i).getTitle());
        myViewHolder.setItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context.getApplicationContext(),DetailsActivity.class);
                intent.putExtra(TITLE,list.get(position).getTitle());
                intent.putExtra(DESC,list.get(position).getDesc());
                intent.putExtra(NAME,list.get(position).getName());
                intent.putExtra(IMAGE,list.get(position).getImage());

                view.getContext().startActivity(intent);

//                Toast.makeText(context, ""+list.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return list.size();


    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        OnItemClickListener itemClickListener;

        public void setItemClickListener(OnItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            id =itemView.findViewById(R.id.productId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemClickListener.onItemClick(v,getAdapterPosition());

                }
            });

        }
    }

}
