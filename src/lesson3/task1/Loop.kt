@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

<<<<<<< .merge_file_a07008
import java.lang.StrictMath.min
import kotlin.math.abs
import kotlin.math.pow
=======
import kotlin.math.abs
>>>>>>> .merge_file_a16688
import kotlin.math.sqrt

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */



fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
<<<<<<< .merge_file_a07008
    var num = 0
    var x = abs(n)
    do {
        x /= 10
        num += 1
    } while (x > 0)
    return num
=======
    if (n == 0)
        return 1
    var res = 0
    var num = n
    while (abs(num) > 0) {
        num /= 10
        res++
    }
    return res
>>>>>>> .merge_file_a16688
}

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
<<<<<<< .merge_file_a07008
    var s1 = 1
    var s2 = 1
    var s = 0
    if (n in 1..2) {
        s = 1
    }
    for (i in 3..n) {
        s = s1 + s2
        s1 = s2
        s2 = s
    }
    return s
=======
    if (n == 1 || n == 2)
        return 1

    var a = 1
    var b = 1
    var c = 0
    for (i in 3..n) {
        c = a + b
        a = b
        b = c
    }
    return c
>>>>>>> .merge_file_a16688
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
<<<<<<< .merge_file_a07008
    var i = 1
    do {
        i += 1
    } while (n % i != 0)
    return i
=======
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return i
        }
    }
    return n
>>>>>>> .merge_file_a16688
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
<<<<<<< .merge_file_a07008
fun maxDivisor(n: Int): Int = (n / minDivisor(n))

=======
fun maxDivisor(n: Int): Int = n / minDivisor(n)
>>>>>>> .merge_file_a16688

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
<<<<<<< .merge_file_a07008
    var counter = 0
    var y = x
    return if (x == 1) 0
    else {
        do {
            if (y % 2 == 0) {
                y /= 2
            } else {
                y = 3 * y + 1
            }
            counter += 1
        } while (y != 1)
        counter
    }
=======
    if (x == 1)
        return 0
    if (x % 2 == 0)
        return collatzSteps(x / 2) + 1
    return collatzSteps(3 * x + 1) + 1
>>>>>>> .merge_file_a16688
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
<<<<<<< .merge_file_a07008
fun gcd(n: Int, m: Int): Int {
    var i = minOf(m, n)
    return if ((m % i == 0) && (n % i == 0)) i
    else {
        do {
            i -= 1
        } while ((n % i != 0) || (m % i != 0))
        i
    }
}

fun lcm(m: Int, n: Int): Int {
    val div = gcd(m, n)
    return abs(m * n) / div
}
=======
fun gcf(m: Int, n: Int): Int {
    var a = m
    var b = n
    while (a != 0 && b != 0) {
        if (a > b)
            a %= b
        else
            b %= a
    }
    return a + b
}

fun lcm(m: Int, n: Int): Int = m * n / gcf(m, n)
>>>>>>> .merge_file_a16688

/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
<<<<<<< .merge_file_a07008
fun isCoPrime(m: Int, n: Int): Boolean {
    val indicator = true
    val minMN = min(m, n)
    for (i in 2..minMN) {
        if ((m % i == 0) && (n % i == 0)) return false
    }
    return indicator

}
=======
fun isCoPrime(m: Int, n: Int): Boolean =
    gcf(m, n) == 1
>>>>>>> .merge_file_a16688

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
<<<<<<< .merge_file_a07008
    var k = digitNumber(n)
    var y = 0
    var digit: Int
    var i = n
    do {
        k -= 1
        digit = i % 10
        y += digit * 10.0.pow(k.toDouble()).toInt()
        i /= 10
    } while (i > 0)
    return y

=======
    var a = n
    var res = 0
    while (a > 0) {
        res = res * 10 + a % 10
        a /= 10
    }
    return res
>>>>>>> .merge_file_a16688
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
<<<<<<< .merge_file_a07008
fun isPalindrome(n: Int): Boolean {
    val k = digitNumber(n)
    return if (k == 1)
        true
    else if (k % 2 != 0) {
        val rightHalf = revert((n % ((10.0).pow(k / 2))).toInt())
        var leftHalf = ((n / ((10.0).pow((k / 2).toDouble() + 1.0)))).toInt()
        if (leftHalf % 10 == 0) do {
            leftHalf /= 10
        } while (leftHalf % 10 == 0)
        leftHalf == rightHalf
    } else {
        val rightHalf = revert((n % ((10.0).pow((k / 2).toDouble()))).toInt())
        var leftHalf = (n / ((10.0).pow((k / 2).toDouble()))).toInt()
        if (leftHalf % 10 == 0) do {
            if (leftHalf % 10 == 0) {
                leftHalf /= 10

            }
        } while (leftHalf % 10 == 0)

        rightHalf == leftHalf
    }
}

=======
fun isPalindrome(n: Int): Boolean = n == revert(n)
>>>>>>> .merge_file_a16688

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
<<<<<<< .merge_file_a07008
    var flag = false
    var m = abs(n)
    if (m < 10) return false
    val x = m % 10
    do {
        m /= 10
        if (x != m % 10) {
            flag = true; break
        }
    } while (m > 9)
    return flag
=======
    var num = n
    val lastDif = num % 10; num / 10
    while (num > 0) {
        if (num % 10 != lastDif)
            return true
        num /= 10
    }
    return false
>>>>>>> .merge_file_a16688
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()

/*fun sin(x: Double, eps: Double): Double {
    var res = x
    var i = 1
    var member = x
    while (member > eps) {
        member *= x * x / ((2 * i) * (2 * i + 1))
        i++
        res += member * ((-0.5 + i % 2) * 2)
    }
    return res
}*/

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var k = 0
    var sqrNumber: Int
    var i = 1
    do {
        sqrNumber = i * i
        k += digitNumber(sqrNumber)
        i += 1
    } while (k < n)
    return fibN(k, n, sqrNumber)
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
<<<<<<< .merge_file_a07008
    var k = 2
    var i = 3
    var fibNumber: Int
    if ((n == 1) || (n == 2)) return 1
    do {
        fibNumber = fib(i)
        k += digitNumber(fibNumber)
        i += 1
    } while (k < n)
    return fibN(k, n, fibNumber)
}

private fun fibN(k: Int, n: Int, fibNumber: Int): Int {
    var fibNumber1 = fibNumber
    fibNumber1 /= ((10.0).pow((k - n).toDouble())).toInt()
    return fibNumber1 % 10

}

=======
    if (n == 1 || n == 2)
        return 1

    var a = 1
    var b = 1
    var c = 0
    var numCount = 2

    while (numCount < n) {
        c = a + b
        a = b
        b = c
        numCount += digitNumber(c)
    }

    val searchedIndex = numCount - n

    for (i in 1..searchedIndex)
        c /= 10

    return c % 10
}
>>>>>>> .merge_file_a16688
