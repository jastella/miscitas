package es.fabricaweb.www.miscitas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jorge on 07/02/2016.
 */
public class citaAdaptador extends RecyclerView.Adapter <citaAdaptador.citaViewHolder> {

    List<cita> citaLista;

    public citaAdaptador(List<cita> citaLista) {
        this.citaLista = citaLista;
    }

    @Override
    public citaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.tarjeta_cita, parent, false);
        return new citaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(citaViewHolder holder, int position) {
        holder.nombreGestor.setText(citaLista.get(position).getNombreGestor());
        holder.nombreAgenda.setText(citaLista.get(position).getNombreAgenda());
        holder.fecha.setText(String.valueOf(citaLista.get(position).getFecha()));
        holder.hora.setText(String.valueOf(citaLista.get(position).getFecha()));
        holder.nota.setText(String.valueOf(citaLista.get(position).getNota()));
    }

    @Override
    public int getItemCount() {
        return citaLista.size();
    }

    public class citaViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreGestor;
        public TextView nombreAgenda;
        public TextView fecha;
        public TextView hora;
        public TextView nota;

        public citaViewHolder(View itemView) {
            super(itemView);
            nombreGestor = (TextView) itemView.findViewById(R.id.tvGestor);
            nombreAgenda = (TextView) itemView.findViewById(R.id.tvAgenda);
            fecha = (TextView) itemView.findViewById(R.id.tvFecha);
            hora= (TextView) itemView.findViewById(R.id.tvHora);
            nota= (TextView) itemView.findViewById(R.id.tvNota);
        }
    }
}
