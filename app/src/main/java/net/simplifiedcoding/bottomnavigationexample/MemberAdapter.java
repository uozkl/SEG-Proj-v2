package net.simplifiedcoding.bottomnavigationexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    private Context context;
    private List<ItemAppointment> memberList;

    MemberAdapter(Context context, List<ItemAppointment> memberList) {
        this.context = context;
        this.memberList = memberList;
    }

    @Override
    public MemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_appointment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemberAdapter.ViewHolder holder, int position) {
        final ItemAppointment member = memberList.get(position);
        holder.textId.setText(String.valueOf(member.getId()));
        holder.textDoctor.setText(member.getDoctor());
        holder.textLocation.setText(member.getLocation());
        holder.textTime.setText(member.getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "item clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    //Adapter 需要一個 ViewHolder，只要實作它的 constructor 就好，保存起來的view會放在itemView裡面
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textId, textDoctor, textLocation, textTime;
        ViewHolder(View itemView) {
            super(itemView);
            textId = (TextView) itemView.findViewById(R.id.text_apponum);
            textDoctor = (TextView) itemView.findViewById(R.id.text_doctor);
            textLocation = (TextView) itemView.findViewById(R.id.text_loaction);
            textTime = (TextView) itemView.findViewById(R.id.text_time);
        }
    }
}
