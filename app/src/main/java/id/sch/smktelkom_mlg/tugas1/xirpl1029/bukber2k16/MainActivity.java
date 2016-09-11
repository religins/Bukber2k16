package id.sch.smktelkom_mlg.tugas1.xirpl1029.bukber2k16;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    Button bReg;
    TextView tvHasilNama, tvDatang, tvAnda, tvAngk;
    int nBersama;
    RadioGroup rgAnda;
    CheckBox cbKl, cbTmn, cbLain;
    Spinner spAngk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bReg = (Button) findViewById(R.id.buttonReg);
        tvHasilNama = (TextView) findViewById(R.id.textViewHasilNama);
        tvDatang = (TextView) findViewById(R.id.textViewDatang);
        tvAnda = (TextView) findViewById(R.id.textViewAnda);
        tvAngk = (TextView) findViewById(R.id.textViewAngk);

        rgAnda = (RadioGroup) findViewById(R.id.rgAnda);
        cbKl = (CheckBox) findViewById(R.id.checkBoxKl);
        cbTmn = (CheckBox) findViewById(R.id.checkBoxTmn);
        cbLain = (CheckBox) findViewById(R.id.checkBoxLain);
        cbKl.setOnCheckedChangeListener(this);
        cbTmn.setOnCheckedChangeListener(this);
        cbLain.setOnCheckedChangeListener(this);
        spAngk = (Spinner) findViewById(R.id.spinnerAngk);

        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        String nama = etNama.getText().toString();
        tvHasilNama.setText(nama + " " + "\n");

        String hasil = null;
        if (rgAnda.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgAnda.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvAnda.setText(" Belum memilih" + "\n");
        } else {
            tvAnda.setText(" Anda adalah " + hasil + "\n");
        }

        String hasilcb = " Anda datang bersama: \n";
        int startlen = hasilcb.length();
        if (cbKl.isChecked()) hasilcb += cbKl.getText() + "\n";
        if (cbTmn.isChecked()) hasilcb += cbTmn.getText() + "\n";
        if (cbLain.isChecked()) hasilcb += cbLain.getText() + "\n";

        if (hasilcb.length() == startlen) hasilcb += "Tidak ada pilihan";
        tvDatang.setText(hasilcb + "\n");

        tvAngk.setText("Angkatan " + spAngk.getSelectedItem().toString());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nBersama += 1;
        else nBersama -= 1;

        tvDatang.setText("Datang bersama (" + nBersama + " terpilih)");
    }
}
