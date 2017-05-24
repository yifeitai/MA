package ma.com.ma.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import ma.com.ma.R;
import ma.com.ma.models.SubmitNewActivity;


public class FirstTab extends Fragment {
    private ListView newsList;
    private FloatingActionButton addNew;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_first_tab, container, false);

//        view.findViewById(R.id....)

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addNew = (FloatingActionButton)view.findViewById(R.id.addNew);


        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SubmitNewActivity.class);
                startActivity(intent);
            }
        });


        //djhdjh






    }
}
