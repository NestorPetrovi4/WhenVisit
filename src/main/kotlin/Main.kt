fun main() {
    val toText = agoToText(322000)
    println(toText)
}

fun agoToText(timeVisit: Int): String {
    if (timeVisit < 0) return "Передано отрицательное значение прошедшего времени, очень похоже на путешествие во времени или ошибку )))))"
    return when {
        timeVisit < 61 -> "был(а) только что"
        timeVisit < 3601 -> "был(а) в сети " + getMinuteVisit(timeVisit)
        timeVisit < 86401 -> "был(а) в сети " + getHourVisit(timeVisit)
        timeVisit < 172801 -> "был(а) в сети вчера"
        timeVisit < 259201 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

fun getHourVisit(timeVisit: Int): String {
    var hourVisit = timeVisit / 60 / 60
    var hourString = hourVisit.toString()
    return when {
        hourVisit < 21 && hourVisit > 4 -> hourString + " часов назад"
        hourVisit == 1 || (hourVisit - 11) % 10 == 0 -> hourString + " час назад"
        ((hourVisit - 12) % 10 == 0 || (hourVisit - 13) % 10 == 0 || (hourVisit - 14) % 10 == 0) -> hourString + " часа назад"
        else -> hourString + " час назад"
    }
}

fun getMinuteVisit(timeVisit: Int): String {
    var minuteVisit = timeVisit / 60
    var minuteString = minuteVisit.toString()
    return when {
        minuteVisit < 21 && minuteVisit > 4 -> minuteString + " минут назад"
        minuteVisit == 1 || (minuteVisit - 11) % 10 == 0 -> minuteString + " минуту назад"
        ((minuteVisit - 12) % 10 == 0 || (minuteVisit - 13) % 10 == 0 || (minuteVisit - 14) % 10 == 0) -> minuteString + " минуты назад"
        else -> minuteString + " минут назад"
    }

}
