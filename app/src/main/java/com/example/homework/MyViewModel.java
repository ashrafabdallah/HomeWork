package com.example.homework;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<Integer>resultLifeDta=new MutableLiveData<>();
    public void getResult()
    {

        NumberModel numbers = DataBase.getNumbers();
        int secondNum = numbers.getSecondNum();
        int firstNum = numbers.getFirstNum();
        int result=firstNum*secondNum;
        resultLifeDta.setValue(result);
    }
}
