package pe.cibertec.demo06.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.cibertec.demo06.R;
import pe.cibertec.demo06.adapter.recyclerview.listeners.IRVFirstAdapterListener;
import pe.cibertec.demo06.entities.Persona;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public class RVFirstAdapter extends RecyclerView.Adapter<RVFirstAdapter.RVFirstAdapterViewHolder> {

    private ArrayList<Persona> mLstPersona;
    private IRVFirstAdapterListener mIRVFirstAdapterListener;

    public RVFirstAdapter(IRVFirstAdapterListener mIRVFirstAdapterListener) {
        mLstPersona = new ArrayList<>();
        this.mIRVFirstAdapterListener = mIRVFirstAdapterListener;
    }

    public void add(Persona persona) {
        mLstPersona.add(persona);
//        notifyItemInserted(mLstPersona.size() - 1);
        notifyDataSetChanged();
    }

    public void update(Persona persona) {
        boolean isUpdated = false;
        for (int i = 0; i < mLstPersona.size(); i++) {
            if (mLstPersona.get(i).getId() == persona.getId()) {
                mLstPersona.get(i).setName(persona.getName());
                mLstPersona.get(i).setLast(persona.getLast());
                mLstPersona.get(i).setDoc(persona.getDoc());
                mLstPersona.get(i).setPhone(persona.getPhone());
                mLstPersona.get(i).setAge(persona.getAge());

                notifyItemChanged(i);

                isUpdated = true;
                break;
            }
        }

        if (!isUpdated)
            add(persona);
    }

    public void remove(Persona persona) {
        for (int i = 0; i < mLstPersona.size(); i++) {
            if (mLstPersona.get(i).getId() == persona.getId()) {
                mLstPersona.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }

    @Override
    public RVFirstAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVFirstAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVFirstAdapterViewHolder holder, int position) {
        Persona persona = mLstPersona.get(position);
        holder.tvFirstItemName.setText(persona.getName());
        holder.tvFirstItemLast.setText(persona.getLast());
        holder.tvFirstItemPhone.setText(persona.getPhone());
        holder.tvFirstItemDoc.setText(persona.getDoc());
        holder.tvFirstItemAge.setText(String.valueOf(persona.getAge()));

        holder.itemView.setOnClickListener(itemViewOnClickListener);
        holder.itemView.setTag(position);

        holder.tvFirstItemPhone.setOnClickListener(holderOnClickListener);
        holder.tvFirstItemPhone.setTag(position);
        holder.tvFirstItemName.setOnClickListener(holderOnClickListener);
        holder.tvFirstItemName.setTag(position);
    }

    View.OnClickListener itemViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            mIRVFirstAdapterListener.onItemClick(mLstPersona.get((Integer) v.getTag()));
        }
    };

    View.OnClickListener holderOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.tvFirstItemPhone){
                mIRVFirstAdapterListener.onItemPhoneClick(mLstPersona.get((Integer) v.getTag()));
            }else{
                mIRVFirstAdapterListener.onItemMapClick(mLstPersona.get((Integer) v.getTag()));
            }
        }
    };

    @Override
    public int getItemCount() {
        return mLstPersona.size();
    }

    static class RVFirstAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView tvFirstItemName, tvFirstItemLast, tvFirstItemAge, tvFirstItemDoc, tvFirstItemPhone;

        public RVFirstAdapterViewHolder(View itemView) {
            super(itemView);

            tvFirstItemName = (TextView) itemView.findViewById(R.id.tvFirstItemName);
            tvFirstItemLast = (TextView) itemView.findViewById(R.id.tvFirstItemLast);
            tvFirstItemAge = (TextView) itemView.findViewById(R.id.tvFirstItemAge);
            tvFirstItemDoc = (TextView) itemView.findViewById(R.id.tvFirstItemDoc);
            tvFirstItemPhone = (TextView) itemView.findViewById(R.id.tvFirstItemPhone);
        }
    }
}
