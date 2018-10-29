package routin_qin.tirage.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import routin_qin.tirage.R;
import routin_qin.tirage.database.DataBaseHelper;

public class RandomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        TextView tv_random_title = (TextView) findViewById(R.id.tv_random_title);
        TextView tv_random_description = (TextView) findViewById(R.id.tv_random_description);
        Button bt_random_back = (Button) findViewById(R.id.bt_random_back);

        bt_random_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        List<String> titles = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        DataBaseHelper db = new DataBaseHelper(this);
        Cursor data = db.getAllData();

        while(data.moveToNext()){
            titles.add(data.getString(1));
            descriptions.add(data.getString(2));
        }

        Random rand = new Random();
        int n = rand.nextInt(titles.size());

        tv_random_title.setText(titles.get(n));
        tv_random_description.setText(descriptions.get(n));
    }
}
