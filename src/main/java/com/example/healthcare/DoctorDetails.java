package com.example.healthcare;

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

public class DoctorDetails extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Doctor Name : Priyatosh Kadam", "Hospital Address : Pimpri", "Exp : 3yrs", "Mobile no:9326766696", "600"},
                    {"Doctor Name : Yash Mahi", "Hospital Address : BT Kawade", "Exp : 5yrs", "Mobile no:9235734297", "900"},
                    {"Doctor Name : Sumit Kolekar", "Hospital Address : Magarpatta", "Exp : 8yrs", "Mobile no:8895634567", "500"},
                    {"Doctor Name : Mahesh Deshmukh", "Hospital Address : Manjari", "Exp : 6yrs", "Mobile no:9326766696", "300"},
                    {"Doctor Name : Ashok Mane", "Hospital Address : Aundh", "Exp : 6yrs", "Mobile no:9326766696", "800"},
            };
    private String[][] doctor_details2=
            {
                    {"Doctor Name : Ankita Kadam", "Hospital Address : Pimpri", "Exp : 3yrs", "Mobile no:9326766696", "600"},
                    {"Doctor Name : ROhit Hedau", "Hospital Address : BT Kawade", "Exp : 5yrs", "Mobile no:9235734297", "900"},
                    {"Doctor Name : Diksha Kkakde", "Hospital Address : Magarpatta", "Exp : 8yrs", "Mobile no:8895634567", "500"},
                    {"Doctor Name : Dhiraj Dixit", "Hospital Address : Manjari", "Exp : 6yrs", "Mobile no:9326766696", "300"},
                    {"Doctor Name : Vishal arote", "Hospital Address : Aundh", "Exp : 6yrs", "Mobile no:9326766696", "800"},
            };
    private String[][] doctor_details3=
            {
                    {"Doctor Name : Priyatosh Kadam", "Hospital Address : Pimpri", "Exp : 3yrs", "Mobile no:9326766696", "600"},
                    {"Doctor Name : Yash Mahi", "Hospital Address : BT Kawade", "Exp : 5yrs", "Mobile no:9235734297", "900"},
                    {"Doctor Name : Sumit Kolekar", "Hospital Address : Magarpatta", "Exp : 8yrs", "Mobile no:8895634567", "500"},
                    {"Doctor Name : Mahesh Deshmukh", "Hospital Address : Manjari", "Exp : 6yrs", "Mobile no:9326766696", "300"},
                    {"Doctor Name : Ashok Mane", "Hospital Address : Aundh", "Exp : 6yrs", "Mobile no:9326766696", "800"},
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name : Priyatosh Kadam", "Hospital Address : Pimpri", "Exp : 3yrs", "Mobile no:9326766696", "600"},
                    {"Doctor Name : Yash Mahi", "Hospital Address : BT Kawade", "Exp : 5yrs", "Mobile no:9235734297", "900"},
                    {"Doctor Name : Sumit Kolekar", "Hospital Address : Magarpatta", "Exp : 8yrs", "Mobile no:8895634567", "500"},
                    {"Doctor Name : Mahesh Deshmukh", "Hospital Address : Manjari", "Exp : 6yrs", "Mobile no:9326766696", "300"},
                    {"Doctor Name : Ashok Mane", "Hospital Address : Aundh", "Exp : 6yrs", "Mobile no:9326766696", "800"},
            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name : Priyatosh Kadam", "Hospital Address : Pimpri", "Exp : 3yrs", "Mobile no:9326766696", "600"},
                    {"Doctor Name : Yash Mahi", "Hospital Address : BT Kawade", "Exp : 5yrs", "Mobile no:9235734297", "900"},
                    {"Doctor Name : Sumit Kolekar", "Hospital Address : Magarpatta", "Exp : 8yrs", "Mobile no:8895634567", "500"},
                    {"Doctor Name : Mahesh Deshmukh", "Hospital Address : Manjari", "Exp : 6yrs", "Mobile no:9326766696", "300"},
                    {"Doctor Name : Ashok Mane", "Hospital Address : Aundh", "Exp : 6yrs", "Mobile no:9326766696", "800"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    ArrayList list;
    HashMap<String,String> item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textView_logo6);
        btn = findViewById(R.id.buttonLDGoBack);
        Intent it=getIntent();

        String title =it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details =doctor_details1;
        else if(title.compareTo("Dietician")==0)
            doctor_details =doctor_details2;
        else if(title.compareTo("Dentist")==0)
            doctor_details =doctor_details3;
        else if(title.compareTo("Surgeon")==0)
            doctor_details =doctor_details4;
        else
            doctor_details =doctor_details5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetails.this,FindDoctorActivity.class));
            }
        });

        list =new ArrayList();
        for (int i=0; i<doctor_details.length;i++) {
            item = new HashMap<String,String>();
            item.put( "line1", doctor_details[i][0]);
            item.put( "line2", doctor_details[i][1]);
            item.put( "line3", doctor_details[i][2]);
            item.put( "line4", doctor_details[i][3]);
            item.put( "line5", "Cons Fees" + doctor_details[4] + "/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst =findViewById(R.id.editTextLDTextMultiLine);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetails.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][2]);
                it.putExtra("text2",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}