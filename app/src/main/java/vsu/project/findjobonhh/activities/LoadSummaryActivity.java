package vsu.project.findjobonhh.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import vsu.project.findjobonhh.R;

// активити для создания(загрузки) резюме
// возможно здесь также будет проверка трудового резюме на ошибки (валидация данных при загрузке)

// ToDo - где вбиваются в создании резюме данные о контактах, фото и портфолио???

public class LoadSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_summary);
    }
}
