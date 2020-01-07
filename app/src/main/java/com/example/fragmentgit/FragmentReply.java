package com.example.fragmentgit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentReply extends Fragment {
String message;
    String reply;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                message = getArguments().getString("Message", message);
            }
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment2, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView=(TextView) view.findViewById(R.id.text_message);
        textView.setText(message);
        final EditText editText=(EditText) view.findViewById(R.id.editText_second);
        Button button=(Button) view.findViewById(R.id.button_second);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        reply=editText.getText().toString();
        listener2.getData(reply);
    }
});
    }
    private SendReply listener2;

    public interface SendReply {
        void getData(String reply);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentReply.SendReply){
            this.listener2 = (FragmentReply.SendReply) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement PizzaMenuFragment.OnItemSelectedListener");
        }
    }
}
