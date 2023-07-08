package cl.individual.recycleviewapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cl.individual.recycleviewapp.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    private FragmentMainBinding binding;
    List<String> data = getData();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater(), container, false);
        initRecycler();
        initListeners();
        return binding.getRoot();
    }

    private void initListeners() {
        binding.fBotonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add("Perrito " + data.size());
                binding.rvLista.getAdapter().notifyItemInserted(data.size());
                binding.rvLista.smoothScrollToPosition(data.size());
            }
        });
    }

    private void initRecycler() {

        MyAdapter perritosAdapter = new MyAdapter();
        perritosAdapter.setPerritos(data);

        binding.rvLista.setAdapter(perritosAdapter);
        binding.rvLista.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

    }

    private List<String> getData() {
        ArrayList<String> perritos = new ArrayList<>();
        perritos.add("Yorkie Poo");
        perritos.add("Pastor Alemán");
        perritos.add("Golden Retriever");
        perritos.add("Maltés");
        perritos.add("Cocker Spaniel");
        perritos.add("Labrador");
        perritos.add("York Shire");


        return perritos;
    }
}