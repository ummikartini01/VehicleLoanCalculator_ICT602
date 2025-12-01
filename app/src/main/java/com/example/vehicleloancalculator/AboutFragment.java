package com.example.vehicleloancalculator;

import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceSate){

        //convert xml layout into view object (on screen)
        View v = inflater.inflate(R.layout.fragment_about, container,false);

        //find TextView in layout with id.githubURL
        TextView github = v.findViewById(R.id.githubURL);

        //clickable link
        github.setMovementMethod(LinkMovementMethod.getInstance());


        github.setOnClickListener(view -> {
            String url = github.getText().toString(); //get link from TextView url
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url))); //open url in web browser

        });

        return v;
    }
}
