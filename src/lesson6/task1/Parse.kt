@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson6.task1

<<<<<<< .merge_file_a05604
import junit.framework.Assert.assertEquals
import lesson4.task1.russian
import org.junit.Test
import java.lang.StringBuilder
=======
import lesson2.task2.daysInMonth
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
>>>>>>> .merge_file_a08528
import java.util.*

// Урок 6: разбор строк, исключения
// Максимальное количество баллов = 13
// Рекомендуемое количество баллов = 11
// Вместе с предыдущими уроками (пять лучших, 2-6) = 40/54

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main() {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

val MONTHS = listOf(
    "января",
    "февраля",
    "марта",
    "апреля",
    "мая",
    "июня",
    "июля",
    "августа",
    "сентября",
    "октября",
    "ноября",
    "декабря"
)

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */

fun dateStrToDigit(str: String): String {
    val time = str.split(" ")
    if (time.size != 3)
        return ""

    val day = time[0].toIntOrNull()
    val month = MONTHS.indexOf(time[1]) + 1
    val year = time[2].toIntOrNull()
    if (month < 1 || day == null || year == null) {
        return ""
    }

    return when {
        day > daysInMonth(month, year) -> ""
        else -> String.format("%02d.%02d.%d", day, month, year)
    }
}

/**
 * Средняя (4 балла)
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String {
    val time = digital.split(".")
    if (time.size != 3)
        return ""

    val day = time[0].toIntOrNull()
    val month = time[1].toIntOrNull()
    val year = time[2].toIntOrNull()
    if (month == null || month !in 1..12 || day == null || year == null) {
        return ""
    }

    return when {
        day > daysInMonth(month, year) -> ""
        else -> "$day ${MONTHS[month - 1]} $year"
    }

}

/**
 * Средняя (4 балла)
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String = TODO()

/**
 * Средняя (5 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int = TODO()

/**
 * Сложная (6 баллов)
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    val str1 = str.split(" ")
    var k = 0
    for (i in 0..str1.size - 2) {
        if (str1[i].lowercase() == str1[i + 1].lowercase()) {
            return k
        }
        k += str1[i].length + 1
    }

    return -1
}

/**
 * Сложная (6 баллов)
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше нуля либо равны нулю.
 */
fun mostExpensive(description: String): String {
    var name = ""
    if (description.matches(Regex(".+\\s[0-9]+\\.[0-9]+(;.+\\s[0-9]+\\.[0-9]+)+||.+\\s[0-9]+\\.[0-9]+||.+\\s\\d+"))) {
        val list = description.split("; ")
        var max = -1.0
        for (i in list.indices) {
            if (list[i].isEmpty()) break
            val l = list[i].split(" ")
            val n = l[0]
            val k = l[1].toDoubleOrNull()
            if ((k != null) && (k.toDouble() > max)) {
                max = k.toDouble()
                name = n
            }
        }
    }
    return name
}


/**
 * Сложная (6 баллов)
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int = TODO()

/**
 * Очень сложная (7 баллов)
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
<<<<<<< .merge_file_a05604
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()


fun wedding(marks: List<String>, cost: Int): Int {
    var costs = 0
    for (i in marks) {
        // 10
        if (i.matches(Regex(".+\\+.+"))) {
            val (_, k) = i.split("+")
            for (i in 0..10) {
                if (k == russian(i)) {
                    costs += (i * cost)
                }
            }
            costs += cost
        } else {
            throw IllegalArgumentException()
        }
    }
    return costs
}

@Test
fun wedding() {
    assertEquals(170, wedding(listOf("Денис+10", "Опапа+5"), 10))
}

fun myFun(addresses: List<String>, person: String): MutableList<String>? {
    val listOfMates = mutableMapOf<String, MutableList<String>>()
    var personAddress = StringBuilder()
    for (address in addresses) {
        address.replace("  ", " ")
        if (address.matches(Regex("(.)+\\s(.)+:(\\s.+)+,\\s.+,\\sкв.\\s.+"))) {
            val (name, _) = address.split(":")
            if (name == person) {
                val resultAddress = address.split(",")
                val resAddress = resultAddress[0].split(" ").subList(2, resultAddress.lastIndex)
                for (i in resAddress) {
                    personAddress.append(i)
                    personAddress.append(" ")
                }
            } else {
                val currAddress = address.split(",")
                val currentAddress = currAddress[0].split(":").subList(1, currAddress.lastIndex)
                val mateAddress = StringBuilder().append(currentAddress.joinToString())
                mateAddress.append(currAddress[1])
                mateAddress.append(" ")
                if (listOfMates.contains(mateAddress.trim())) {
                    listOfMates[mateAddress.trim().toString()]?.add(name)

                } else {
                    listOfMates[mateAddress.trim().toString()] = mutableListOf(name)
                }
            }
        } else {
            throw IllegalArgumentException()
        }
    }
    return listOfMates[personAddress.toString().trim()]
}

=======

fun isValidCommands(commands: String): Boolean {
    val chars = "+-><[ ]"
    var loopRate = 0
    for (char in commands) {
        if (char !in chars) {
            return false
        }
        if (char == '[') {
            loopRate++
        }
        if (char == ']') {
            loopRate--
            if (loopRate < 0)
                return false
        }

    }
    if (loopRate != 0) {
        return false
    }
    return true
}
fun findNextHop(commands: String, from: Int): Int {
    var jump = 0
    var loopNesting = 1
    while (commands[from + jump] != ']' || loopNesting != 0) {
        jump++
        when (commands[from + jump]) {
            ']' -> loopNesting--
            '[' -> loopNesting++
        }
    }
    return from + jump
}

fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    val values = MutableList(cells) { 0 }

    var valuesPointer = cells / 2
    var commandsPointer = 0
    if (!isValidCommands(commands)) {
        throw IllegalArgumentException()
    }
    val loopStartPointers = Stack<Int>()

    var i = 0
    while (i < limit) {
        when (commands[commandsPointer]) {
            '>' -> {
                valuesPointer++
                if (valuesPointer !in 0 until cells) {
                    throw IllegalStateException()
                }
            }
            '<' -> {
                valuesPointer--
                if (valuesPointer !in 0 until cells) {
                    throw IllegalStateException()
                }
            }
            '+' -> {
                values[valuesPointer]++
            }
            '-' -> {
                values[valuesPointer]--
            }
            '[' -> {
                if (values[valuesPointer] == 0) {
                    commandsPointer = findNextHop(commands, commandsPointer)
                } else {
                    loopStartPointers.push(commandsPointer)
                }
            }
            ']' -> {
                if (values[valuesPointer] != 0) {
                    commandsPointer = loopStartPointers.peek()
                } else {
                    loopStartPointers.pop()
                }
            }
        }

        if (commandsPointer == commands.length - 1) break
        commandsPointer++
        i++
    }

    return values
}
>>>>>>> .merge_file_a08528
