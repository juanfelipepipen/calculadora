package mx.itson.edu.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

@Suppress("SpellCheckingInspection")
class MainActivity : AppCompatActivity() {
    private var operation: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        number1()
        number2()
        number3()
        number4()
        number5()
        number6()
        number7()
        number8()
        number9()
        clear()
        sumar()
        restar()
        dividir()
        multiplicar()
        calculate()
    }

    /// Number 1
    private fun number1() {
        val btn: Button = findViewById(R.id.btn1)
        btn.setOnClickListener {
            addNumber(1)
        }
    }

    /// Number 2
    private fun number2() {
        val btn: Button = findViewById(R.id.btn2)
        btn.setOnClickListener {
            addNumber(2)
        }
    }

    /// Number 3
    private fun number3() {
        val btn: Button = findViewById(R.id.btn3)
        btn.setOnClickListener {
            addNumber(3)
        }
    }

    /// Number 4
    private fun number4() {
        val btn: Button = findViewById(R.id.btn4)
        btn.setOnClickListener {
            addNumber(4)
        }
    }

    /// Number 5
    private fun number5() {
        val btn: Button = findViewById(R.id.btn5)
        btn.setOnClickListener {
            addNumber(5)
        }
    }

    /// Number 6
    private fun number6() {
        val btn: Button = findViewById(R.id.btn6)
        btn.setOnClickListener {
            addNumber(6)
        }
    }

    /// Number 7
    private fun number7() {
        val btn: Button = findViewById(R.id.btn7)
        btn.setOnClickListener {
            addNumber(7)
        }
    }

    /// Number 8
    private fun number8() {
        val btn: Button = findViewById(R.id.btn8)
        btn.setOnClickListener {
            addNumber(8)
        }
    }

    /// Number 9
    private fun number9() {
        val btn: Button = findViewById(R.id.btn9)
        btn.setOnClickListener {
            addNumber(9)
        }
    }

    /// Clear operations
    private fun clear() {
        val btn: Button = findViewById(R.id.btnLimpiar)
        btn.setOnClickListener {
            val calcular1: TextView = findViewById(R.id.calcular1)
            val calcular2: TextView = findViewById(R.id.calcular2)
            operation = null
            calcular1.text = ""
            calcular2.text = ""
        }
    }

    /// Sumar
    private fun sumar() {
        val btn: Button = findViewById(R.id.btnSumar)
        btn.setOnClickListener {
            addOperation("+", "SUMAR")
        }
    }

    /// Restar
    private fun restar() {
        val btn: Button = findViewById(R.id.btnRestar)
        btn.setOnClickListener {
            addOperation("-", "RESTAR")
        }
    }

    /// Restar
    private fun dividir() {
        val btn: Button = findViewById(R.id.btnDividir)
        btn.setOnClickListener {
            addOperation("/", "DIVIDIR")
        }
    }

    /// Multiplicar
    private fun multiplicar() {
        val btn: Button = findViewById(R.id.btnPor)
        btn.setOnClickListener {
            addOperation("*", "MULTIPLICAR")
        }
    }

    /// Add number for calculation
    private fun addNumber(value: Int) {
        val calcular2: TextView = findViewById(R.id.calcular2)
        calcular2.text = calcular2.text.toString().plus(value)
    }

    /// Calcular operaciones
    fun calculate() {
        val btn: Button = findViewById(R.id.btnIgual)
        btn.setOnClickListener {
            val calcular1: TextView = findViewById(R.id.calcular1)
            val calcular2: TextView = findViewById(R.id.calcular2)

            if (calcular2.text.isNotEmpty() && calcular1.text.length > 1) {
                val numeros = calcular1.text.toString().dropLast(1).filter { it.isDigit() }
                val numeros1: Double = numeros.toDouble()
                val numeros2: Double = calcular2.text.toString().toDouble()
                calcular1.text = ""
                calcular2.text = calcularOperacion(numeros1, numeros2).toString()
                this.operation = null
            }
        }
    }

    /// Agregar operacion
    private fun addOperation(simbolo: String, operacion: String) {
        val calcular1: TextView = findViewById(R.id.calcular1)
        val calcular2: TextView = findViewById(R.id.calcular2)

        if (calcular2.text != "" && this.operation == null) {
            this.operation = operacion
            calcular1.text = calcular2.text.toString().plus(simbolo)
            calcular2.text = ""
        }
    }

    /// Calcular operacion basado en simbolo
    private fun calcularOperacion(numero1: Double, numero2: Double): Double {
        if (operation == "SUMA") {
            return (numero1 + numero2).toDouble()
        }

        if (operation == "RESTAR") {
            return (numero1 - numero2).toDouble()
        }

        if (operation == "DIVIDIR") {
            return (numero1 / numero2).toDouble()
        }

        return (numero1 * numero2).toDouble()
    }
}