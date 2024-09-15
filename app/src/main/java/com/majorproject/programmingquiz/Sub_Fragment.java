package com.majorproject.programmingquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majorproject.programmingquiz.AdapterClass.SubAdapter;
import com.majorproject.programmingquiz.databinding.FragmentHomeBinding;
import com.majorproject.programmingquiz.modelClass.SubModel;

import java.util.ArrayList;

public class Sub_Fragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<SubModel> list = new ArrayList<>();
    SubAdapter adapter;
    String title;

    public Sub_Fragment() {

    }

    public Sub_Fragment(String title) {
        this.title = title;

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

        switch (title) {
            case "C":
                list.add(new SubModel("C BASIC", "Syntax,Loops,Array...","C"));
                list.add(new SubModel("C INTERMEDIATE", "Pointer,Structure,union...","C"));
                list.add(new SubModel("C ADVANCED", "Sorting,Searching,Macros...","C"));
                break;
            case "C++":
                list.add(new SubModel("C++ BASIC", "Function,Constructor,Cin/Cout...","C++"));
                list.add(new SubModel("C++ INTERMEDIATE", "Operator,Inheritance,Type Casting...","C++"));
                list.add(new SubModel("C++ ADVANCED", "Multithreading,Concurrency,Lambda Function...","C++"));
                break;
            case "JAVA":
                list.add(new SubModel("JAVA BASIC", "Class,Objects,Methods...","JAVA"));
                list.add(new SubModel("JAVA INTERMEDIATE", "Multithreading,JDBC,Synchronization...","JAVA"));
                list.add(new SubModel("JAVA ADVANCED", "JVM,Concurrency,Security...","JAVA"));
                break;
            case "PYTHON":
                list.add(new SubModel("PYTHON BASIC", "Keywords,Functions,Argument...","PYTHON"));
                list.add(new SubModel("PYTHON INTERMEDIATE", "Modules,JASON,XML Parsing...","PYTHON"));
                list.add(new SubModel("PYTHON ADVANCED", "GUI,Web Scraping,ML & DS Library...","PYTHON"));
                break;
        }

        adapter = new SubAdapter(getContext(), list);
        binding.rcv.setAdapter(adapter);

    }
}