package id.sch.smktelkom_mlg.tugas01.xiirpl1029.aplikasihotel;

import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView tvHasil,tvHasil2, tvTanggal, tvFasilitas;
    int nFasilitas;
    Button buttonPesan;
    Spinner sptipekmr, spSubkm;
    EditText editnama,editnoktp,editnotelp;
    CheckBox cbLunch,cbDinner,cbKaraoke,cbSpa,cbGym,cb24;
    RadioButton rbTunai, rbKartu, rbVoucher;
    RadioGroup rgBayar;

    String [][] arSub = {{"Single Room"},{"Single Room","Twin Room"},{"Twin Room", "Double Room"}
            ,{"Double Room","Triple/Family Room"}};
    ArrayList<String> listSubtipe = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTanggal = (TextView) findViewById(R.id.textViewTgl);
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        String dateString = sdf.format(date);
        tvTanggal.setText(dateString);

        editnama = (EditText) findViewById(R.id.editTextNama);
        editnoktp=(EditText) findViewById(R.id.editTextKTP);
        editnotelp=(EditText) findViewById(R.id.editTextTelp);

        sptipekmr = (Spinner) findViewById(R.id.spinnerKamar);

        spSubkm = (Spinner) findViewById(R.id.spinnerSub);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listSubtipe);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSubkm.setAdapter(adapter);

        cbLunch = (CheckBox) findViewById(R.id.checkBoxLunch);
        cbDinner = (CheckBox) findViewById(R.id.checkBoxDinner);
        cbKaraoke = (CheckBox) findViewById(R.id.checkBoxKaraoke);
        cbSpa = (CheckBox) findViewById(R.id.checkBoxSpa);
        cbGym = (CheckBox) findViewById(R.id.checkBoxGym);
        cb24 = (CheckBox) findViewById(R.id.checkBox24);

        rbTunai = (RadioButton) findViewById(R.id.radioButtonTunai);
        rbKartu = (RadioButton) findViewById(R.id.radioButtonKredit);
        rbVoucher = (RadioButton) findViewById(R.id.radioButtonVoucher);
        rgBayar=(RadioGroup) findViewById(R.id.radiogroupBayar);

        buttonPesan = (Button) findViewById(R.id.buttonOK);
        tvFasilitas= (TextView) findViewById(R.id.textViewaFasilitas);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
    }
}
