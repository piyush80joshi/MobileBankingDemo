package com.cts.mobilebankingdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link BalanceTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BalanceTransferFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Spinner acctFromSpn;
    private Spinner acctToSpn;
    private TextView tFromAcct;
    private TextView tToAcct;
    private Button bCancel;
    private Button bTransferBalance;
    private EditText eAmount;
    private String selectedFromAccount;
    private String selectedToAccount;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BalanceTransferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BalanceTransferFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BalanceTransferFragment newInstance(String param1, String param2) {
        BalanceTransferFragment fragment = new BalanceTransferFragment();
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
        // Inflate the layout for this fragment

        eAmount = (EditText) getActivity().findViewById(R.id.fAmountTxt);
        bTransferBalance = (Button) getActivity().findViewById(R.id.fTransBalBtn);

        bTransferBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                transferBalance();
            }
        });

        bCancel = (Button) getActivity().findViewById(R.id.fbackBtn);
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        //-------------------------
        tFromAcct = (TextView) getActivity().findViewById(R.id.fAcctFromTxt);
        tToAcct = (TextView) getActivity().findViewById(R.id.fAcctToTxt);
        ArrayList<String> fromAccountList = getFromAccountList();
        ArrayAdapter fromAcctAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, fromAccountList);

        acctFromSpn = (Spinner) getActivity().findViewById(R.id.fActFromSpn);
        acctFromSpn.setAdapter(fromAcctAdapter);
        acctFromSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedFromAccount = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<String> toAccountList = getToAccountList();
        ArrayAdapter toAcctAdapter = new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, toAccountList);
        acctToSpn = (Spinner) getActivity().findViewById(R.id.fAcctToSpn);
        acctToSpn.setAdapter(toAcctAdapter);
        acctToSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedToAccount = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return inflater.inflate(R.layout.fragment_balance_transfer, container, false);
    }

    private ArrayList<String> getToAccountList() {
        ArrayList toAccountList = new ArrayList<String>();
        toAccountList.add("Ritam.B");
        toAccountList.add("Mani");
        return toAccountList;
    }

    private ArrayList<String> getFromAccountList() {
        ArrayList fromAccountList = new ArrayList<String>();
        fromAccountList.add("PJ");

        return fromAccountList;
    }

    private void transferBalance() {
        //TODO

        String toastString = "Amount $" + eAmount.getText().toString() + " transferred from Account " + selectedFromAccount + " to Account " + selectedToAccount + " .";
        Toast.makeText(getActivity().getBaseContext(), toastString, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View view) {

    }
}
