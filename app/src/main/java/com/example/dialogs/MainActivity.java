package com.example.dialogs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btnDialeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnDialeg = findViewById(R.id.buttonDialeg);

        this.btnDialeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear y mostrar el cuadro de diálogo
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Hello")
                        .setMessage("Missatge Alerta.")
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Aquí puedes agregar acciones si se hace clic en el botón "Cancelar"
                                dialog.dismiss(); // Cerrar el cuadro de diálogo
                            }
                        })
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Aquí puedes agregar acciones si se hace clic en el botón "Aceptar"
                                dialog.dismiss(); // Cerrar el cuadro de diálogo
                            }
                        });

                // Crear el cuadro de diálogo y mostrarlo
                AlertDialog dialog = builder.create();
                dialog.show();

                // Ajustar el diseño de los botones (colocar el botón "Aceptar" a la derecha)
                Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                Button negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                layoutParams.weight = 10; // Hacer que el botón "Aceptar" sea más ancho
                positiveButton.setLayoutParams(layoutParams);
                negativeButton.setLayoutParams(layoutParams);

            }
        });
    }
}