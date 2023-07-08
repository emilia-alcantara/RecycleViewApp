package cl.individual.recycleviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.individual.recycleviewapp.databinding.ItemBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<String> countries;

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String country = countries.get(position);
        holder.bind(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemBinding binding;

        public MyViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String item =countries.get(position);
            Toast.makeText(itemView.getContext(), "El elemento seleccionado es: " + item, Toast.LENGTH_LONG).show();
        }

        public void bind(String country) {
            binding.txtListaItem.setText(country);
        }
    }
}
