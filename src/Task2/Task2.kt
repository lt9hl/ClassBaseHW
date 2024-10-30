package Task2
import kotlin.math.*
/*Расстояние между точками (с использованием класса Точка)
Две точки находятся на координатной плоскости. Каждая точка описана своими координатами. Найти расстояние между указанными точками.*/
fun main(){
    var dot1 = Dot()
    var dot2 = Dot()
    try {
        println("Введите координаты первой точки \nв формате x;y")
        dot1.setCord(readln().split(';').toList())
        println("Введите координаты второй точки")
        dot2.setCord(readln().split(';').toList())
    } catch (e:Exception) {
        println("Данные введены неверно")
        return
    }
    println("Расстояние между точками ${String.format("%.2f",dot1.distance(dot2))}")
}
class Dot(){
    var x = 1.1
    var y = 1.1
    fun distance(dot2: Dot): Double{
        var dist =sqrt(Math.pow(dot2.x - x,2.0) + Math.pow(dot2.y - y,2.0))
        return dist
    }
    fun setCord(cord: List<String>){
        try {
            x = cord[0].toDouble()
            y = cord[1].toDouble()
        } catch (e:Exception){
            println("Введено не число")
            return
        }
    }
}