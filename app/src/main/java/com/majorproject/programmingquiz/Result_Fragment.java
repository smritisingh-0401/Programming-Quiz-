package com.majorproject.programmingquiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.majorproject.programmingquiz.databinding.FragmentQuizBinding;
import com.majorproject.programmingquiz.databinding.FragmentResultBinding;


public class Result_Fragment extends Fragment {

    FragmentResultBinding binding;
    int right, allQuestion;
    String category, title;

    public Result_Fragment() {

    }

    public Result_Fragment(int right, int allQuestion, String category, String title) {
        this.right = right;
        this.allQuestion = allQuestion;
        this.category = category;
        this.title = title;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(getLayoutInflater());

        String rightScore = String.valueOf(right);
        String wrongScore = String.valueOf(allQuestion-right);
        String totalQueScore = String.valueOf(allQuestion);

        binding.correct.setText(rightScore+" Correct");
        binding.incorrect.setText(wrongScore+" Incorrect");
        binding.score.setText("You got the "+rightScore+"out of "+totalQueScore);

        binding.explorebtn.setOnClickListener(v->{
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new Home_Fragment()).commit();

        });

        binding.replay.setOnClickListener(v->{
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new Quiz_Fragment(category,title)).commit();

        });

        binding.explain.setOnClickListener(v->{
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper, new Explain_Fragment(category,title)).commit();

        });



        return binding.getRoot();
    }
}