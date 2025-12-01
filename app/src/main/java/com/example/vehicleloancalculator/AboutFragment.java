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

        View v = inflater.inflate(R.layout.fragment_about, container,false);

        TextView github = v.findViewById(R.id.githubURL);
        github.setMovementMethod(LinkMovementMethod.getInstance());

        github.setOnClickListener(view -> {
            String url = github.getText().toString();
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));

        });

        return v;
    }
}
