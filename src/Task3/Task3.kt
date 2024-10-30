package Task3

import kotlin.math.*

/*Выбор наибольшего и наименьшего расстояний (обязательно использовать класс Точка)
Множество точек расположено на координатной плоскости. Количество точек задается в консоли при запуске
программы и оно должно быть больше двух. Каждая точка задается своими координатами.
Точки не совпадают друг с другом. Требуется найти минимальное и максимальное расстояние между точками.*/
fun main() {
    println("Введите количество точек")
    var count = readln().toIntOrNull()?.let {
        if (it <= 2) {
            println("Точек должно быть больше 2")
            return
        } else it
    }
    if (count == null) {
        println("Введено не число")
        return
    }
    var dots = Array(count) { Dot() }
    for (i in 0..<count) {
        println("Введите координаты ${i + 1} точки")
        dots[i].setCord(readln().split(';'))
    }
    var min = 2147483647.0
    var max = -2147483647.0
    for (i in dots.indices) {
        for (j in dots.indices) {
            if (min > dots[i].distance(dots[j]) && i != j) {
                min = dots[i].distance(dots[j])
            } else if (max < dots[i].distance(dots[j]) && i != j) {
                max = dots[i].distance(dots[j])
            }
        }
    }
    println("Минимальное расстояние между точками: ${String.format("%.2f", min)} " +
                "\nМаксимальное расстояние: ${String.format("%.2f", max)}")
}

class Dot{
    private var x = 0.0
    private var y = 0.0

    fun setCord(cords: List<String>) {
        try {
            x = cords[0].toDouble()
            y = cords[1].toDouble()
        } catch (e: Exception) {
            println("Данные введены неверно")
            return
        }
    }

    fun distance(dot2: Dot): Double {
        val dist = sqrt(Math.pow(dot2.x - x, 2.0) + Math.pow(dot2.y - y, 2.0))
        return dist
    }
}

