package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;


public class ProductGridFragment extends Fragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
        }

        @Override
        public View onCreateView(
                @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment with the ProductGrid theme
            View view = inflater.inflate(R.layout.shr_product_grid_fragment, container, false);

            // Set up the toolbar
            setUpToolbar(view);

            return view;
        }

        private void setUpToolbar(View view) {
            Toolbar toolbar = view.findViewById(R.id.app_bar);
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            if (activity != null) {
                activity.setSupportActionBar(toolbar);
            }
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.shr_toolbar_menu, menu);
            super.onCreateOptionsMenu(menu, menuInflater);
        }

    }
