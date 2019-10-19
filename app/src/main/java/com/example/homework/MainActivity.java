package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Myinterface{
    Prisenter prisenter;
    MyViewModel viewModel;
    @BindView(R.id.plus_button)
    Button plusButton;
    @BindView(R.id.mul_button)
    Button mulButton;
    @BindView(R.id.div_button)
    Button divButton;
    @BindView(R.id.mul_result_textView)
    TextView mulResultTextView;
    @BindView(R.id.plus_result_textView)
    TextView plusResultTextView;
    @BindView(R.id.div_result_textView)
    TextView divResultTextView;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prisenter=new Prisenter(this);
        viewModel= ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.resultLifeDta.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mulResultTextView.setText(String.valueOf(integer));
            }
        });
    }

    @OnClick(R.id.plus_button)
    public void onViewClicked() {
        getPlusResult();
    }
    public void getPlusResult()
    {
        DataBase dataBase=new DataBase();
        NumberModel numbers = dataBase.getNumbers();
        int firstNum = numbers.getFirstNum();
        int secondNum = numbers.getSecondNum();
        int resultPlus=firstNum+secondNum;
        plusResultTextView.setText(String.valueOf(resultPlus));

    }


    @Override
    public void getResult(int result) {
        divResultTextView.setText(String.valueOf(result));
    }



    public void Multi(View view) {
        viewModel.getResult();
    }

    public void div(View view) {
        prisenter.getReesult();
    }
}

