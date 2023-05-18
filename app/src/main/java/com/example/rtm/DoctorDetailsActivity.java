package com.example.rtm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Walter White", "Hospital Address : Washington DC", "Exp : 15yrs", "Mobile No:6788226589", "600"},
                    {"Doctor Name : Gustavo Pieres", "Hospital Address : Colombia", "Exp : 17yrs", "Mobile No:2435679176", "900"},
                    {"Doctor Name : Mellisa McCall", "Hospital Address : Beacon HillsC", "Exp : 4yrs", "Mobile No:2554378956", "300"},
                    {"Doctor Name : Chris Otieno", "Hospital Address : Nairobi", "Exp : 3yrs", "Mobile No:0785467335", "500"},
                    {"Doctor Name : Yao Ming", "Hospital Address : Tokyo", "Exp : 15yrs", "Mobile No:7842389765", "800"}

            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Walter Black", "Hospital Address : Washington DC", "Exp : 15yrs", "Mobile No:6788226589", "600"},
                    {"Doctor Name : Jeff Bonanza", "Hospital Address : Colombia", "Exp : 17yrs", "Mobile No:2435679176", "900"},
                    {"Doctor Name : Kate Argent", "Hospital Address : Beacon HillsC", "Exp : 4yrs", "Mobile No:2554378956", "300"},
                    {"Doctor Name : Mark Ndungu", "Hospital Address : Nairobi", "Exp : 3yrs", "Mobile No:0785467335", "500"},
                    {"Doctor Name : Ging Freecs", "Hospital Address : Tokyo", "Exp : 15yrs", "Mobile No:7842389765", "800"}

            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Jeffrey Dahmer", "Hospital Address : Washington DC", "Exp : 15yrs", "Mobile No:6788226589", "600"},
                    {"Doctor Name : Richarlison", "Hospital Address : Colombia", "Exp : 17yrs", "Mobile No:2435679176", "900"},
                    {"Doctor Name : Malia Tate", "Hospital Address : Beacon HillsC", "Exp : 4yrs", "Mobile No:2554378956", "300"},
                    {"Doctor Name : Dennis Ombachi", "Hospital Address : Nairobi", "Exp : 3yrs", "Mobile No:0785467335", "500"},
                    {"Doctor Name : Hiruzen Shizuku", "Hospital Address : Tokyo", "Exp : 15yrs", "Mobile No:7842389765", "800"}

            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Wendy Wiliams", "Hospital Address : Washington DC", "Exp : 15yrs", "Mobile No:6788226589", "600"},
                    {"Doctor Name : Hakimi", "Hospital Address : Colombia", "Exp : 17yrs", "Mobile No:2435679176", "900"},
                    {"Doctor Name : Lydia Martin", "Hospital Address : Beacon HillsC", "Exp : 4yrs", "Mobile No:2554378956", "300"},
                    {"Doctor Name : Marcus Kinyenye", "Hospital Address : Nairobi", "Exp : 3yrs", "Mobile No:0785467335", "500"},
                    {"Doctor Name : Gojo Satoru", "Hospital Address : Tokyo", "Exp : 15yrs", "Mobile No:7842389765", "800"}

            };private String[][] doctor_details5 =
            {
                    {"Doctor Name : Ja Morant", "Hospital Address : Washington DC", "Exp : 15yrs", "Mobile No:6788226589", "600"},
                    {"Doctor Name : Bruno Fernandes", "Hospital Address : Colombia", "Exp : 17yrs", "Mobile No:2435679176", "900"},
                    {"Doctor Name : Talia Hale", "Hospital Address : Beacon HillsC", "Exp : 4yrs", "Mobile No:2554378956", "300"},
                    {"Doctor Name : Beavon Nyangari", "Hospital Address : Nairobi", "Exp : 3yrs", "Mobile No:0785467335", "500"},
                    {"Doctor Name : Itadori Yuji", "Hospital Address : Tokyo", "Exp : 15yrs", "Mobile No:7842389765", "800"}

            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonGoBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

            list = new ArrayList();
            for (int i=0;i<doctor_details.length;i++){
                item = new HashMap<String,String>();
                item.put("line1", doctor_details[i][0]);
                item.put("line2", doctor_details[i][1]);
                item.put("line3", doctor_details[i][2]);
                item.put("line4", doctor_details[i][3]);
                item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
                list.add( item );
            }
            sa = new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"line1","line2","line3","line4","line5",},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                    );
        ListView lst = findViewById(R.id.editTextTextMultiLine);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}