package com.example.ailatrieuphu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBXH extends RecyclerView.Adapter<AdapterBXH.Viewholder> {
    private IGetBXH iGetBXH;
    public AdapterBXH(IGetBXH iGetBXH){
        this.iGetBXH = iGetBXH;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_bxh, parent,false);
        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBXH.Viewholder holder, int position) {
        holder.tvSTT.setText((position + 1 + ""));
        holder.tvSoLevel.setText(iGetBXH.getItems(position).getSoLevel() + "");
        holder.tvTen.setText(iGetBXH.getItems(position).getName());
        holder.tvSoTien.setText(String.valueOf(iGetBXH.getItems(position).getSoTien()));
    }

    @Override
    public int getItemCount() {
        return iGetBXH.getCount();
    }

    static final class Viewholder extends RecyclerView.ViewHolder {
        private TextView tvSTT, tvTen, tvSoLevel, tvSoTien;

        public Viewholder(View itemView) {
            super(itemView);
            tvSTT = itemView.findViewById(R.id.tvSTT);
            tvTen = itemView.findViewById(R.id.tvTen);
            tvSoLevel = itemView.findViewById(R.id.tvSoLevel);
            tvSoTien = itemView.findViewById(R.id.tvSoTien);
        }
    }

    public interface IGetBXH {
        int getCount();
        BangXepHang getItems(int position);
    }
}
