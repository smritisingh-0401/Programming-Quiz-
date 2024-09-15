package com.majorproject.programmingquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majorproject.programmingquiz.AdapterClass.HomeAdapter;
import com.majorproject.programmingquiz.databinding.FragmentHomeBinding;
import com.majorproject.programmingquiz.databinding.FragmentSubBinding;
import com.majorproject.programmingquiz.modelClass.HomeModel;

import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<HomeModel> list = new ArrayList<>();
    HomeAdapter adapter;

    public Home_Fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentHomeBinding.inflate(getLayoutInflater());


        LoadData();
        return binding.getRoot();

    }

    private void LoadData() {

        binding.rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        list.clear();
        list.add(new HomeModel("C", "Syntax, Pointer, Sorting..."));
        list.add(new HomeModel("C++", "Class, Threading, JVM..."));
        list.add(new HomeModel("JAVA", "Function, Inheritance, Library..."));
        list.add(new HomeModel("PYTHON", "Loops, Modules, GUI..."));

        adapter = new HomeAdapter(getContext(), list);
        binding.rcv.setAdapter(adapter);

    }
}