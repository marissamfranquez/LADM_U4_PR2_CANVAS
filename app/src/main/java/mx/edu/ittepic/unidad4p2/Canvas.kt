package mx.edu.ittepic.unidad4p2

import android.graphics.*
import android.graphics.Canvas
import android.view.View

class Canvas(puntero:MainActivity):View(puntero){
    var dia = true
    var paint = Paint()
    var carroazul = BitmapFactory.decodeResource(resources, R.drawable.carroazul) as Bitmap
    var carropolicia = BitmapFactory.decodeResource(resources, R.drawable.carropolicia) as Bitmap
    var cx = 0.0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if(dia==true){/*Dibujar paisaje blanco y sol*/
            paint.color = Color.WHITE
            canvas!!.drawRect(0.0f, 0.0f, this.width.toFloat(), this.height.toFloat(), paint)
            paint.color = Color.YELLOW
            canvas!!.drawCircle(120.0f, 120.0f, 100.0f, paint)
        }
        else{ /*Dibujar paisaje oscuro y luna*/
            paint.color = Color.rgb(31, 34, 67)
            canvas!!.drawRect(0.0f, 0.0f, this.width.toFloat(), this.height.toFloat(), paint)
            paint.color=Color.LTGRAY
            canvas!!.drawCircle(this.width-120.0f, 120.0f, 100.0f, paint)
        }

        /*Dibujar carretera, linea amarilla y carros*/
        paint.color = Color.DKGRAY
        canvas!!.drawRect(0.0f, 430.0f, this.width.toFloat(),470.0f+carroazul.height, paint)
        paint.color = Color.YELLOW
        var tamcarretera = 470.0f+carroazul.height-430.0f
        canvas!!.drawRect(0.0f, 430.0f+tamcarretera/2, this.width.toFloat(),430.0f+tamcarretera/2+2, paint)
        canvas!!.drawBitmap(carroazul, cx, 450.0f, paint)
        paint.color = Color.DKGRAY
        canvas!!.drawRect(0.0f, 830.0f, this.width.toFloat(),870.0f+carropolicia.height, paint)
        paint.color=Color.YELLOW
        tamcarretera = 870.0f+carropolicia.height-830.0f
        canvas!!.drawRect(0.0f, 830.0f+tamcarretera/2, this.width.toFloat(),830.0f+tamcarretera/2+2, paint)
        canvas!!.drawBitmap(carropolicia, cx, 850.0f, paint)

        invalidate()
    }
}