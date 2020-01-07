package com.example.fragmentgit;

import android.content.Context;
import android.icu.text.Transliterator;
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
import androidx.lifecycle.Lifecycle;

public class FragmentSend extends Fragment {

String message;
String reply;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            // Get back arguments
            if(getArguments() != null) {
                reply = getArguments().getString("Reply", reply);
            }
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final EditText editText=(EditText) view.findViewById(R.id.editText_main);
        Button button=(Button) view.findViewById(R.id.button);

        TextView textView=(TextView) view.findViewById(R.id.text_message_reply);
        textView.setText(reply);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message=editText.getText().toString();
listener.sendMessage(message);
            }
        });
    }

private ClickListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ClickListener){
            this.listener = (ClickListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement PizzaMenuFragment.OnItemSelectedListener");
        }
    }

    public interface ClickListener {
        void sendMessage(String message);
    }
}
