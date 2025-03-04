@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
<<<<<<< .merge_file_a16496
import lesson1.task1.sqr
=======
>>>>>>> .merge_file_a12936
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

// Урок 2: ветвления (здесь), логический тип (см. 2.2).
// Максимальное количество баллов = 6
// Рекомендуемое количество баллов = 5
// Вместе с предыдущими уроками = 9/12

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая (2 балла)
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
<<<<<<< .merge_file_a16496
fun ageDescription(age: Int): String = when {
    (age / 10 % 10 == 1) || (age % 10 == 0) || (age % 10 in 5..9) -> "$age лет"
    age % 10 == 1 -> "$age год"
    else -> "$age года"
}
=======
fun ageDescription(age: Int): String =
    when {
        age % 10 in 5..9 || age % 10 == 0 || age % 100 in 11..19 -> "$age лет"
        age % 10 == 1 -> "$age год"
        else -> "$age года"
    }
>>>>>>> .merge_file_a12936

/**
 * Простая (2 балла)
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {
<<<<<<< .merge_file_a16496
    val halfWay = (t1 * v1 + t2 * v2 + t3 * v3) / 2
    return when {
        (v1 * t1 >= halfWay) -> halfWay / v1
        (v1 * t1 + v2 * t2 >= halfWay) -> t1 + (halfWay - v1 * t1) / v2
        else -> (t1 + t2 + (halfWay - v1 * t1 - v2 * t2) / (v3))
    }
}

=======
    val sHalf = (t1 * v1 + t2 * v2 + t3 * v3) / 2.0
    return  if (sHalf <= t1 * v1) sHalf / v1
            else if (sHalf - t1 * v1 <= t2 * v2) t1 + (sHalf - t1 * v1) / v2
            else t1 + t2 + (sHalf - t1 * v1 - t2 * v2) / v3
}
>>>>>>> .merge_file_a12936

/**
 * Простая (2 балла)
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
<<<<<<< .merge_file_a16496
): Int =
    when {
        ((rookX1 == kingX || rookY1 == kingY)
                && (rookX2 == kingX || rookY2 == kingY)) -> 3
        (rookX2 == kingX || rookY2 == kingY) -> 2
        (rookX1 == kingX || rookY1 == kingY) -> 1
        else -> 0
    }
=======
): Int {
    val danger1 = kingX == rookX1 || kingY == rookY1
    val danger2 = kingX == rookX2 || kingY == rookY2
    return when {
        danger1 && danger2 -> 3
        danger1 -> 1
        danger2 -> 2
        else -> 0
    }
}
>>>>>>> .merge_file_a12936

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int =
    when {
        rookX != kingX && kingY != rookY && (abs(kingX - bishopX) != abs(kingY - bishopY)) -> 0
        (rookX == kingX || kingY == rookY) && (abs(kingX - bishopX) != abs(kingY - bishopY)) -> 1
        (rookX != kingX && kingY != rookY) && (abs(kingX - bishopX) == abs(kingY - bishopY)) -> 2
        else -> 3
    }


/**
 * Простая (2 балла)
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
<<<<<<< .merge_file_a16496
    val sumOfAllTriangleSides = a + b + c
    val biggestSide = maxOf(a, b, c)
    val smallestSide = minOf(a, b, c)
    val averageSide = sumOfAllTriangleSides - biggestSide - smallestSide


    return when {
        biggestSide > smallestSide + averageSide -> -1
        (sqr(biggestSide) < sqr(smallestSide) + sqr(averageSide)) -> 0
        (sqr(biggestSide) == sqr(smallestSide) + sqr(averageSide)) -> 1
        else -> 2

    }
=======
    val cosA = (b * b + c * c - a * a) / (2 * b * c)
    val cosB = (a * a + c * c - b * b) / (2 * a * c)
    val cosC = (b * b + a * a - c * c) / (2 * b * a)
    return if (abs(cosA) > 1) -1
    else if (cosA < 0 || cosB < 0 || cosC < 0) 2
    else if (cosA == 0.0 || cosB == 0.0 || cosC == 0.0) 1
    else 0
>>>>>>> .merge_file_a12936
}

/**
 * Средняя (3 балла)
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
<<<<<<< .merge_file_a16496
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    val x = maxOf(a, c)
    val y = minOf(b, d)
    return when {
        y - x >= 0 -> y - x
        else -> -1
    }
}
=======
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int =
    when {
        (a <= c) && (c <= b) && (b <= d) -> b - c   // ACBD
        (a <= c) && (d <= b) -> d - c               // (c <= d) = true; ACDB
        (c <= a) && (b <= d) -> b - a               // (a <= b) = true; CABD
        (c <= a) && (a <= d) && (d <= b) -> d - a   // CADB

        else -> -1
    }
>>>>>>> .merge_file_a12936
