package com.eleng.p0161_dymaniclayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);  //создаю элемент макета
        linearLayout.setOrientation(LinearLayout.VERTICAL);//устанавливаю ориентацию
        ViewGroup.LayoutParams linLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); //linLayoutParams - файл хранящий лэйаут свойства "по ширине родителя"
        setContentView(linearLayout, linLayoutParams);//назначаю КОРНЕВЫМ элементом linearLayout с лэйаут свойствами из linLayoutParams

        ViewGroup.LayoutParams lpView = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//lpView - объект хранящий лэйаут свойства "по ширине контента"

        TextView tv = new TextView(this); //создаю элемент текствью
        tv.setText("TextView");//присваиваю ему текст
        tv.setLayoutParams(lpView);//присваиваю ему лэйаут параменты lpView, то есть "по длине содержимого"
        linearLayout.addView(tv);//добавляю текствью в корневой элемент linearLayout

        Button btn = new Button(this);//создаю элемент-кнопку
        btn.setText("Button");//присваиваю ей текст
        linearLayout.addView(btn, lpView);//одновременно (фича) присваиваю лэйаут параметры lpView и добавляю элемент-баттон в корневой linearLayout
        //объект lpView имеет базовый тип ViewGroup и позволяет настроить лишь высоту и ширину, для отступа и выравнивания необходимо создать
        //новый лэйаут объект и иными параметрами
        LinearLayout.LayoutParams leftmarginParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);//leftmarginParams - объект лэйаут типа LinearLayout
        leftmarginParams.leftMargin = 50; //указываю отступ слева 50 пикселей, который хранится в объекте leftmarginParams

        Button btn2 = new Button(this); //создаю элемент-кнопку
        btn2.setText("Button2");//присваиваю ей текст
        linearLayout.addView(btn2, leftmarginParams);//добавляю элемент btn2 в корневой linearLayout и присваиваю параметры leftmarginParams (ширина и высота "по содержимому" и отступ слева 50 пикселей)

        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightGravityParams.gravity = Gravity.RIGHT;//указываю выравнивание по правому краю, которое хранится в объекте rightGravityParams

        Button btn3 = new Button(this);
        btn3.setText("Button3");
        linearLayout.addView(btn3, rightGravityParams);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
