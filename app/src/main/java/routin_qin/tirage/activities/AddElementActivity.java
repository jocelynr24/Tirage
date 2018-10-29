package routin_qin.tirage.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import routin_qin.tirage.R;
import routin_qin.tirage.database.DataBaseHelper;

public class AddElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_element);

        final EditText et_title = (EditText) findViewById(R.id.et_element_name);
        final EditText et_description = (EditText) findViewById(R.id.et_element_description);
        FloatingActionButton fab_cancel = (FloatingActionButton) findViewById(R.id.fab_element_cancel);
        FloatingActionButton fab_send = (FloatingActionButton) findViewById(R.id.fab_element_send);

        fab_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fab_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Send", Toast.LENGTH_SHORT).show();
                DataBaseHelper db = new DataBaseHelper(getApplicationContext());
                db.addElement(et_title.getText().toString(), et_description.getText().toString());
                finish();
            }
        });
    }
}