package cn.mycats.j3assistant;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xavier on 2017/11/5.
 */

class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{
    private List<PetResult> data = new ArrayList<>();

    public void setData(List<PetResult> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pet_list,parent,false);
        return new PetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PetViewHolder holder, int position) {
        PetResult petResult = data.get(position);
        holder.nameMeet.setText(petResult.getName());
        holder.namePet.setText(petResult.getPet());
        holder.time.setText(petResult.getTime());
        holder.state.setText(petResult.getStatus());
        if (petResult.getStatus().contains("进CD")){
            holder.state.setTextColor(Color.BLUE);
        }else if (petResult.getStatus().contains("还需")){
            holder.state.setTextColor(Color.RED);
        }else if (petResult.getStatus().contains("失联")){
            holder.state.setTextColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PetViewHolder extends RecyclerView.ViewHolder{
        TextView nameMeet;
        TextView namePet;
        TextView time;
        TextView state;
        public PetViewHolder(View itemView) {
            super(itemView);
            nameMeet = (TextView) itemView.findViewById(R.id.name_meet);
            namePet = (TextView) itemView.findViewById(R.id.name_pet);
            time = (TextView) itemView.findViewById(R.id.time);
            state = (TextView) itemView.findViewById(R.id.state);
        }
    }
}
