package com.eleng.p0171_dynamiclayout;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //в качестве обработчика для кнопок назначаю активити - OnClick.
                                                                                    //Для этого имплеменчу View.OnClickListener
    LinearLayout llMain;
    RadioGroup rgGravity;//Описываю все, созданные в макете, элементы.
    EditText etName;
    Button btnCreate;
    Button btnClear;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);//Нахожу все элементы по идентификаторам
        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnCreate.setOnClickListener(this);//присваиваю обработчик(активити) кнопкам
        btnClear.setOnClickListener(this);

    }

    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnCreate: //Если нажата кнопка btnCreate, то создаем объект lParams, которая будет хранить
                // размеры объекта "по содержанию"
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int btnGravity = Gravity.LEFT;//Также создаю btnGravity, которая, по умолчанию, содержит выравнивание по левому краю

                switch (rgGravity.getCheckedRadioButtonId()) {//Создаю свич, который определяет какой именно РадиоБаттон выбран и в соответствии
                    case R.id.rbLeft:                         //с этим назначает выравнивание для кнопки в btnGravity
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }

                lParams.gravity = btnGravity;//Назначаю полученное в свиче "выравнивание" в lParams
                Button btnNew = new Button(this);//Создаю объект
                btnNew.setText(etName.getText().toString());//Присваиваю ему текст
                btnNew.setId(i);//Присваиваю кнопке ID
                final String ID = "ID кнопки = "+i;
                if (i!=3) {
                    btnNew.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) { //если ID созданной кнопки != 3, тогда Toast покажет ID
                            Toast.makeText(MainActivity.this, ID,Toast.LENGTH_SHORT).show();
                        }
                    });
                } else { btnNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) { //если ID созданной кнопки = 3, тогда Toast покажет "ТРЕТЬЯ КНОПОЧКА".
                        Toast.makeText(MainActivity.this, "ТРЕТЬЯ КНОПОЧКА",Toast.LENGTH_SHORT).show();
                    }
                });
                }
                i = ++i;//Увеличиваю ID на еденицу, чтобы обеспечить уникальный ID следующей кнопке
                llMain.addView(btnNew, lParams);//Добавляю btnNew в llMain
                break;

            case R.id.btnClear:           //При нажатии btnClear
                llMain.removeAllViews(); //Метод удаляет все дочерние элементы из llMain
                Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_SHORT).show();//Toast показывает сообщение "Deleted"
                break;

        }
    }
}
