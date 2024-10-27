package br.edu.fateczl.contas;
/*
 *@author:<Gustavo de Paula>
 */
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.contas.model.ContaEspecial;
import br.edu.fateczl.contas.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbContaE, rbContaP;
    private TextView tvSaida;
    private EditText etCliente, etNumConta, etSaldo, etValor, etTaxaLimite;
    private Button btnDepositar, btnSacar;
    private RadioGroup rgTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rbContaE = findViewById(R.id.rbContaE);
        rbContaP = findViewById(R.id.rbContaP);
        rbContaP.setChecked(true);
        tvSaida = findViewById(R.id.tvSaida);
        etCliente = findViewById(R.id.etCliente);
        etNumConta = findViewById(R.id.etNumConta);
        etSaldo = findViewById(R.id.etSaldo);
        etValor = findViewById(R.id.etValor);
        etTaxaLimite = findViewById(R.id.etTaxaLimite);
        btnDepositar = findViewById(R.id.btnDepositar);
        btnSacar = findViewById(R.id.btnSacar);


        rgTipo = findViewById(R.id.rgTipo);
        rgTipo.setOnCheckedChangeListener((group, checkedId)-> {
            if (checkedId == R.id.rbContaE) {
                etTaxaLimite.setHint(R.string.limite);

            } else {
                etTaxaLimite.setHint(R.string.taxa);
            }
            etTaxaLimite.setText("");
        });

        btnDepositar.setOnClickListener(v -> {
            if(rbContaE.isChecked()){
                ContaEspecial ce = new ContaEspecial();
                ce.cliente = etCliente.getText().toString();
                ce.num_conta = Integer.parseInt(etNumConta.getText().toString());
                ce.saldo = Float.parseFloat(etSaldo.getText().toString());
                ce.limite = Float.parseFloat(etTaxaLimite.getText().toString());
                ce.depositar(Float.parseFloat(etValor.getText().toString()));
                tvSaida.setText("Novo saldo: "+String.valueOf(ce.saldo));
            }else if(rbContaP.isChecked()){
                ContaPoupanca cp = new ContaPoupanca();
                cp.cliente = etCliente.getText().toString();
                cp.num_conta = Integer.parseInt(etNumConta.getText().toString());
                cp.saldo = Float.parseFloat(etSaldo.getText().toString());
                cp.depositar(Float.parseFloat(etValor.getText().toString()));
                cp.calcularNovoSaldo(Float.parseFloat(etTaxaLimite.getText().toString()));
                tvSaida.setText("Novo saldo com rendimento: "+String.valueOf(cp.saldo));
            }
        });

        btnSacar.setOnClickListener(v -> {
            if(rbContaE.isChecked()){
                ContaEspecial ce = new ContaEspecial();
                ce.cliente = etCliente.getText().toString();
                ce.num_conta = Integer.parseInt(etNumConta.getText().toString());
                ce.saldo = Float.parseFloat(etSaldo.getText().toString());
                ce.limite = Float.parseFloat(etTaxaLimite.getText().toString());
                ce.sacar(Float.parseFloat(etValor.getText().toString()));
                tvSaida.setText("Novo saldo: "+String.valueOf(ce.saldo));
            }else if(rbContaP.isChecked()){
                ContaPoupanca cp = new ContaPoupanca();
                cp.cliente = etCliente.getText().toString();
                cp.num_conta = Integer.parseInt(etNumConta.getText().toString());
                cp.saldo = Float.parseFloat(etSaldo.getText().toString());
                cp.sacar(Float.parseFloat(etValor.getText().toString()));
                cp.calcularNovoSaldo(Float.parseFloat(etTaxaLimite.getText().toString()));
                tvSaida.setText("Novo saldo com rendimento: "+String.valueOf(cp.saldo));
            }
        });

    }
}