package com.example.docdate;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tab3_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tab3_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public tab3_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab1_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static tab3_fragment newInstance(String param1, String param2) {
        tab3_fragment fragment = new tab3_fragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =   inflater.inflate(R.layout.tab3_layout,container,false);
        Button btn = (Button)view.findViewById(R.id.formBtn);
        EditText vname = (EditText)view.findViewById(R.id.vnameInp);
        EditText nname = (EditText)view.findViewById(R.id.nnameInp);
        EditText address = (EditText)view.findViewById(R.id.adressInp);
        EditText phone = (EditText)view.findViewById(R.id.phoneInp);
        EditText email = (EditText)view.findViewById(R.id.EMailInp);
        EditText fachrichtung = (EditText)view.findViewById(R.id.fachrichtungInp);
        EditText kzBesch = (EditText)view.findViewById(R.id.kurzbeschreibung);
        EditText longBesch = (EditText)view.findViewById(R.id.erzählenInp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> missing = new ArrayList<String>();

                if(vname.getText().length()<=0){
                    missing.add("Vorname");
                }

                if(nname.getText().length()<=0){
                    missing.add("Nachname");
                }

                if(address.getText().length()<=0){
                    missing.add("Adresse");
                }

                if(phone.getText().length()<=0){
                    missing.add("Telefonnummer");
                }

                if(email.getText().length()<=0){
                    missing.add("E-Mail");
                }

                if(fachrichtung.getText().length()<=0){
                    missing.add("Fachrichtung");
                }

                if(kzBesch.getText().length()<=0){
                    missing.add("Kurzbeschreibung");
                }

                if(longBesch.getText().length()<=0){
                    missing.add("Beschreibung");
                }
                if(missing.size()==0) {
                    Snackbar.make(view, "Erfolgreich eingereicht", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{

                    String joined = TextUtils.join(", ", missing);
                    Snackbar.make(view, "Folgende Pflichfelder fehlen: "+ joined, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        return view;
    }
}