package com.debugandroid.RecyclerViewFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends Fragment {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<String> data=new ArrayList<String>();
    public MyFragment() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        recyclerView= (RecyclerView) getActivity().findViewById(R.id.recyclerView);

        for (int i=0;i<=32;i++){
            data.add("Item "+i);
        }
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);

        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override public int getSpanSize(int position) {

                switch (adapter.getItemViewType(position)){
                    case 0: return 2;
                    case 1: return 1;
                    case 2: return 2;
                    default: return 2;
                }

            }
        });
        recyclerView.setLayoutManager(glm);

        adapter=new Adapter(getActivity(),data,true,true);

        recyclerView.setAdapter(adapter);

    }



}
