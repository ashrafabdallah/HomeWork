package com.example.homework;

public class Prisenter {
    private Myinterface myinterface;

    public Prisenter(Myinterface myinterface) {
        this.myinterface = myinterface;
    }

    public NumberModel getresultfromDatabase() {
       return DataBase.getNumbers();
    }
    public void getReesult()
    {
        NumberModel numberModel = getresultfromDatabase();
        int secondNum = numberModel.getSecondNum();
        int firstNum = numberModel.getFirstNum();
        int result = 0;
        if(secondNum!=0)
        {
            result=firstNum/secondNum;
        }
        myinterface.getResult(result);

    }

}
