package com.example.ricardo.cursokotlinlevel2

import javax.security.auth.callback.Callback


// Nulos

var apellido:String? = null
var apellido2:String? = apellido?.substring(0,1)
var apellido3:String? = apellido?.substring(0,1) ?: "sin apellido"
// se puede establecer que despues se va inicializar
lateinit var color:String

val id:String by lazy { "123" }

// Funciones

fun sumar(n1:Int, n2:Int):Int{
    return n1 + n2
}

fun sumar2(n1:Int, n2:Int = 0):Int = n1 + n2

var resul1 = sumar(2,4)
var resul2 = sumar2(3)
var resul3 = sumar2(n2 = 4, n1 = 3)


fun Int.mul(n:Int): Int = this * n

var rta = 4.mul(4)

infix fun Int.div(n:Int):Int = this / n
var rta2 = 3 div 5


var sub: (n1:Int , n2:Int)->Int = {n1,n2 -> n1 + n2}


fun operar(n1:Int, n2:Int , callback:(rta:Int) -> Unit){
    callback(n1 + n2)

}



fun testOperar(){

    operar(3,6, {rta -> println("resultado es: $rta")})
    operar(3,6){rta -> println("resultado es: $rta")}
    operar(3,6){println("resultado es: $it")}
}



// clases


class Usuario(val nombre:String, var correo:String)

val usr = Usuario("hector", "ejemplo@gl.com")

val nombre = usr.nombre


fun testUsuario(){
    usr.correo = "otro@ddkf.com"
}



open class  Mascota(val edad:Int, val raza:String){
    var edadHumana:Int = 0

    init {
        edadHumana = 7 * edad
    }

}

class Conejo(val nombre:String, edad:Int): Mascota(edad, "conejo"){
    constructor():this("", 0)

    fun comer(comida:Int){

    }
}

  // se puede sobreescribir un operador
/*operator fun plus(conejo:Conejo):Conejo{
      return Conejo(conejo.nombre, this.edad)
  }

val a = Conejo("a", 4)
val b = Conejo("d", 2)
val c = Conejo("c", 44)
*/




