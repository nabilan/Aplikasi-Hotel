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
    TextView tvHasil, tvTanggal, tvFasilitas;
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

//        rbTunai = (RadioButton) findViewById(R.id.radioButtonTunai);
//        rbKartu = (RadioButton) findViewById(R.id.radioButtonKredit);
//        rbVoucher = (RadioButton) findViewById(R.id.radioButtonVoucher);
        rgBayar=(RadioGroup) findViewById(R.id.radiogroupBayar);

        buttonPesan = (Button) findViewById(R.id.buttonOK);
        tvFasilitas= (TextView) findViewById(R.id.textViewaFasilitas);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        sptipekmr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listSubtipe.clear();
                listSubtipe.addAll(Arrays.asList(arSub[pos]));
                adapter.notifyDataSetChanged();
                spSubkm.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        buttonPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = editnama.getText().toString();

            String noktp = editnoktp.getText().toString();
            String notelp = editnotelp.getText().toString();

            String hasil = null;
            if(rgBayar.getCheckedRadioButtonId()!=-1){
                RadioButton rb = (RadioButton)
                        findViewById(rgBayar.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }

            String hasil2="Fasilitas yang dipilih : \n";
            int startlen = hasil2.length();
            if (cbLunch.isChecked()) hasil2 +=cbLunch.getText() +"\n";
            if (cbDinner.isChecked()) hasil2 +=cbDinner.getText() +"\n";
            if(cbKaraoke.isChecked()) hasil2 +=cbKaraoke.getText() +"\n";
            if (cbGym.isChecked()) hasil2 +=cbGym.getText() +"\n";
            if (cbSpa.isChecked()) hasil2 +=cbSpa.getText() +"\n";
            if (cb24.isChecked()) hasil2 +=cb24.getText() +"\n";

            if (hasil2.length()==startlen) hasil2="Tidak memilih fasilitas tambahan";

            tvHasil.setText("Nama Anda                 : " + nama + "\n\n" +
                    "No KTP Anda               : " + noktp + "\n\n" +
                    "No. Telepon Anda          : " + notelp + "\n\n" +
                    "Anda Memilih Tipe Kamar   : " + sptipekmr.getSelectedItem().toString() + "dengan Jenis Kamar " + spSubkm.getSelectedItem().toString() +"\n\n"+
                    hasil2 + "\n\n"+
                    "Anda Melakukan Pembayaran : " + hasil + "\n\n"
            );
        }
    }
    private boolean isValid() {
        boolean valid=true;

        String nama = editnama.getText().toString();
        String noktp = editnoktp.getText().toString();
        String notelp = editnotelp.getText().toString();

        if(nama.isEmpty())
        {
            editnama.setError("Nama Belum Diisir");
            valid=false;
        }

        else if(nama.length()<2)
        {
            editnama.setError("Nama kurang dari 2 karakter");
            valid=false;
        }

        else {
            editnama.setError(null);
        }

        if(noktp.isEmpty())
        {
            editnoktp.setError("No. KTP Belum Diisi");
            valid=false;
        }

        else if(noktp.length()!=16)
        {
            editnoktp.setError("No. KTP yang Anda Inputkan Tidak Tepat");
            valid=false;
        }

        else {
            editnoktp.setError(null);
        }

        if(notelp.isEmpty())
        {
            editnotelp.setError("No. Telepon Belum Diisi");
            valid=false;
        }

        else if(notelp.length()<8)
        {
            editnotelp.setError("No. Telepon kurang dari 8 karakter");
            valid=false;
        }

        else {
            editnotelp.setError(null);
        }
        return valid;
    }
}
