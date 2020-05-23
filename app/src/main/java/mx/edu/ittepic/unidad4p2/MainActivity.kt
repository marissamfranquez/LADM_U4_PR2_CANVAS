package mx.edu.ittepic.unidad4p2

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.abs

class MainActivity : AppCompatActivity(), SensorEventListener {
    var manejadorSensor: SensorManager?=null
    var acelerometro: Sensor?=null
    var proximidad: Sensor?=null
    var canvas:Canvas?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        canvas = Canvas(this)
        this.setContentView(canvas)
        manejadorSensor=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        proximidad= manejadorSensor!!.getDefaultSensor(Sensor.TYPE_PROXIMITY) as Sensor
        acelerometro = manejadorSensor!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) as Sensor
        manejadorSensor!!.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_GAME);
        manejadorSensor!!.registerListener(this, proximidad, SensorManager.SENSOR_DELAY_GAME);
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        var tipoSensor = event!!.sensor.type;
        var tipoProximidad = Sensor.TYPE_PROXIMITY;
        var tipoAcelerometro = Sensor.TYPE_ACCELEROMETER;

        if(tipoSensor == tipoAcelerometro){
            var xdesplazamiento = event.values[0]
            var width = canvas!!.width
            var cx = canvas!!.cx
            var tamxcarro = canvas!!.carroazul.width
            if(xdesplazamiento<0 && cx<=width-tamxcarro){
                canvas!!.cx = cx+abs(xdesplazamiento) *6
            }
            else if(xdesplazamiento>0 && cx>=0){
                canvas!!.cx = cx-xdesplazamiento*6
            }
        }
        else if(tipoSensor == tipoProximidad) {
            canvas!!.dia = event.values[0] != 0.0f
        }

    }
}
