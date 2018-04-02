package com.eleng.p0191_simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener{


    //объявляю элементы экрана
    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //находим элементы экрана по идентификатору
        etNum1 = (EditText) findViewById(R.id.editText);
        etNum2 = (EditText) findViewById(R.id.editText2);

        btnAdd = (Button) findViewById(R.id.button);
        btnSub = (Button) findViewById(R.id.button1);
        btnMult = (Button) findViewById(R.id.button2);
        btnDiv = (Button) findViewById(R.id.button3);

        tvResult = (TextView) findViewById(R.id.textView);

        //прописываем обработчик
        btnAdd.setOnClickListener(MainActivity.this);
        btnSub.setOnClickListener(MainActivity.this);
        btnMult.setOnClickListener(MainActivity.this);
        btnDiv.setOnClickListener(MainActivity.this);
    }



    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        //проверка полей на пустоту
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())){
            return;
        }
        //читаем EditText и заполняем переменную числами

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        //определяем нажатую кнопку и выполняем соответствующую оперцию
        //в oper пишем операцию, потом будем использовать в выводе
        switch (view.getId()) {
            case R.id.button:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.button1:
                oper = "-";
                result = num1 - num2;
                break;

            case R.id.button2:
                oper = "*";
                result = num1 * num2;
                break;

            case R.id.button3:
                oper = "/";
                result = num1 / num2;
                break;
        }

        //формируем строку вывода
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

    //создаем меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    //обработка нажатий на пункты меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
        //очищаем поля
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID://выход из приложения
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
