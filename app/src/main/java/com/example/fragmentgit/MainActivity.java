package com.example.fragmentgit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentSend.ClickListener, FragmentReply.SendReply{
String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.framelayout, new FragmentSend());
            fragmentTransaction.commit();
        }


    }

    @Override
    public void sendMessage(String message) {
        FragmentReply secondFragment = new FragmentReply();

        Bundle args = new Bundle();
        args.putString("Message", message);
        secondFragment.setArguments(args);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout, secondFragment) // replace flContainer
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void getData(String reply) {
        FragmentSend firstFragment = new FragmentSend();

        Bundle args = new Bundle();
        args.putString("Reply", reply);
        firstFragment.setArguments(args);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout, firstFragment) // replace flContainer
                .addToBackStack(null)
                .commit();

    }
}
