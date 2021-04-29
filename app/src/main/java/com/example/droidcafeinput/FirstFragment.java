package com.example.droidcafeinput;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FirstFragment extends Fragment {

    ImageView imgDonut;
    ImageView imgIceCream;
    ImageView imgFroyo;

    private String mOrderMessage;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("extra_message", mOrderMessage);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
            }
        });

        imgDonut = view.findViewById(R.id.donut);
        imgIceCream = view.findViewById(R.id.ice_cream);
        imgFroyo = view.findViewById(R.id.froyo);

        imgDonut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDonutOrder(view);
            }
        });

        imgIceCream.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showIceCreamOrder(view);
            }
        });

        imgFroyo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showFroyoOrder(view);
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getActivity(), message,
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }
}