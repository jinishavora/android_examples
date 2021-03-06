package com.example.vora.fragments_example;


import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {

    ItemSelected selectActivity;

    public interface ItemSelected
    {
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        selectActivity = (ItemSelected) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] data = getResources().getStringArray(R.array.pieces);

        /*Before using the xml
        ArrayList<String> data = new ArrayList<String>();

        data.add("1. This is Item 1");
        data.add("2. This is Item 2");
        data.add("3. This is Item 3");
        */

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));

        if(this.getActivity().findViewById(R.id.layout_land) != null)
        {
            selectActivity.onItemSelected(0);

        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        selectActivity.onItemSelected(position);
    }
}
