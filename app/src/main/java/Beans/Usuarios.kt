package Beans

class Usuarios {

    var cod:Int
    var nombre:String
    var edad:Int
    var mail:String

    constructor(cod: Int, nombre: String, edad: Int, mail: String) {
        this.cod = cod
        this.nombre = nombre
        this.edad = edad
        this.mail = mail
    }

    constructor(nombre: String, edad: Int, mail: String) {
        this.cod = 0
        this.nombre = nombre
        this.edad = edad
        this.mail = mail
    }
}