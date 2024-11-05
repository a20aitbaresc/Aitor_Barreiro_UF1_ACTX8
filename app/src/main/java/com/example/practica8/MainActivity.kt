package com.example.practica8

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Referencias a los elementos de la interfaz
    private lateinit var cbMateria1: CheckBox
    private lateinit var cbMateria2: CheckBox
    private lateinit var cbMateria3: CheckBox
    private lateinit var cbMateria4: CheckBox
    private lateinit var cbMateria5: CheckBox
    private lateinit var cbMateria6: CheckBox
    private lateinit var cbMateria7: CheckBox
    private lateinit var cbMateria8: CheckBox

    private lateinit var rbMatí: RadioButton
    private lateinit var rbTarda: RadioButton
    private lateinit var btnConfirmar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar los elementos de la interfaz
        cbMateria1 = findViewById(R.id.cbMateria1)
        cbMateria2 = findViewById(R.id.cbMateria2)
        cbMateria3 = findViewById(R.id.cbMateria3)
        cbMateria4 = findViewById(R.id.cbMateria4)
        cbMateria5 = findViewById(R.id.cbMateria5)
        cbMateria6 = findViewById(R.id.cbMateria6)
        cbMateria7 = findViewById(R.id.cbMateria7)
        cbMateria8 = findViewById(R.id.cbMateria8)

        rbMatí = findViewById(R.id.rbMatí)
        rbTarda = findViewById(R.id.rbTarda)
        btnConfirmar = findViewById(R.id.btnConfirmar)

        // Configurar el evento del botón Confirmar
        btnConfirmar.setOnClickListener {
            confirmarSeleccion()
        }
    }

    private fun confirmarSeleccion() {
        // Crear una lista para almacenar las asignaturas seleccionadas
        val asignaturasSeleccionadas = mutableListOf<String>()

        // Agregar las asignaturas seleccionadas a la lista
        if (cbMateria1.isChecked) asignaturasSeleccionadas.add(cbMateria1.text.toString())
        if (cbMateria2.isChecked) asignaturasSeleccionadas.add(cbMateria2.text.toString())
        if (cbMateria3.isChecked) asignaturasSeleccionadas.add(cbMateria3.text.toString())
        if (cbMateria4.isChecked) asignaturasSeleccionadas.add(cbMateria4.text.toString())
        if (cbMateria5.isChecked) asignaturasSeleccionadas.add(cbMateria5.text.toString())
        if (cbMateria6.isChecked) asignaturasSeleccionadas.add(cbMateria6.text.toString())
        if (cbMateria7.isChecked) asignaturasSeleccionadas.add(cbMateria7.text.toString())
        if (cbMateria8.isChecked) asignaturasSeleccionadas.add(cbMateria8.text.toString())

        // Obtener el turno seleccionado
        val turnoSeleccionado = when {
            rbMatí.isChecked -> "Matí"
            rbTarda.isChecked -> "Tarda"
            else -> null
        }

        // Validar si el usuario ha seleccionado al menos una asignatura y un turno
        if (asignaturasSeleccionadas.isEmpty()) {
            Toast.makeText(this, "Per favor, selecciona almenys una matèria.", Toast.LENGTH_SHORT).show()
            return
        }

        if (turnoSeleccionado == null) {
            Toast.makeText(this, "Per favor, selecciona un torn (Matí o Tarda).", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear un mensaje de confirmación con la selección
        val mensajeConfirmacion = "Matèries seleccionades: ${asignaturasSeleccionadas.joinToString(", ")}\n" +
                "Torn: $turnoSeleccionado"

        // Mostrar el mensaje en un Toast
        Toast.makeText(this, mensajeConfirmacion, Toast.LENGTH_LONG).show()
    }
}
