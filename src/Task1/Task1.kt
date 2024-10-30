package Task1

/*Точка и треугольник (создать класс Точка и класс Треугольник)
Треугольник описан координатами трех своих вершин. Указаны координаты отдельной точки. Составить программу,
показывающую, где находится точка - внутри или вне треугольника.
Треугольник и точка находятся на координатной плоскости.
Обратить внимание на обработку ошибок при вводе координат. Программа не должна "падать" при вводе неправильных значений.*/

/*Координаты треугольника 2;4 4;-4 -5;-2
Точки 3;0 - на стороне
0;0 - внутри*/
fun main() {
    try {
        println("Введите координаты вершин треугольника через пробел\n" +
                "В формате 1,2;2 3;4")
        var triangle = Triangle()
        triangle.setCord(readln())
        println("Введите координаты точки")
        var dot = Dot()
        dot.setCord(readln())
        triangle.intersection(dot)
    } catch (e: Exception) {
        print("Данные введены неверно")
        return
    }

}
abstract class Coordinates(){
    abstract fun setCord(dot: String)
}
class Dot : Coordinates(){
    var j = mutableListOf("")
    override fun setCord(dot: String,){
        j = dot.split(';').toMutableList()
    }
}
class Triangle : Coordinates() {
    private var a = mutableListOf("")
    private var b = mutableListOf("")
    private var c = mutableListOf("")
override fun setCord(dot: String){
    try {
        var arr = dot.split(' ')
        a = arr[0].split(';').toMutableList()
        b = arr[1].split(';').toMutableList()
        c = arr[2].split(';').toMutableList()
    } catch (e: Exception) {
        println("Неправильный формат вывода данных")
        return
    }
    println("Введены координаты \nт. а x: ${a.get(0)}, y: ${a.get(1)}\n" +
            "т. b x: ${b.get(0)}, y: ${b.get(1)}\n" +
            "т. c x: ${c.get(0)}, y: ${c.get(1)}")
}
    fun intersection(dot: Dot) {
        var pr1 = (a.get(0).toDouble() - dot.j.get(0).toDouble()) * (b.get(1).toDouble() - a.get(1).toDouble())  -
                ((b.get(0).toDouble() - a.get(0).toDouble()) * (a.get(1).toDouble() - dot.j.get(1).toDouble()))

        var pr2 = (b.get(0).toDouble() - dot.j.get(0).toDouble()) * (c.get(1).toDouble() - b.get(1).toDouble())  -
                ((c.get(0).toDouble() - b.get(0).toDouble()) * (b.get(1).toDouble() - dot.j.get(1).toDouble()))

        var pr3 = (c.get(0).toDouble() - dot.j.get(0).toDouble()) * (a.get(1).toDouble() - c.get(1).toDouble())  -
                ((a.get(0).toDouble() - c.get(0).toDouble()) * (c.get(1).toDouble() - dot.j.get(1).toDouble()))
        if ((pr1 > 0 && pr2 > 0 && pr3 > 0) || (pr1 < 0 && pr2 < 0 && pr3 < 0)) println("Точка лежит внутри треугольника")
        else if (pr3 == 0.0 || pr2 == 0.0 || pr1 == 0.0 ) println("Точка лежит на стороне треугольника")
        else println("Точка находится вне треугольника")
    }
}
