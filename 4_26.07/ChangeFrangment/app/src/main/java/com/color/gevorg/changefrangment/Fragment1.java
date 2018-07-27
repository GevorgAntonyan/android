package com.color.gevorg.changefrangment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    public Fragment1Listener listener;



    public Fragment1() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        final EditText text1 = view.findViewById(R.id.text1);
        text1.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        ((MainActivity)getActivity()).onInputASent(String.valueOf(text1.getText()));
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );
        return view;

    }

    public interface Fragment1Listener {
        void onInputASent(String i);
    }

}
