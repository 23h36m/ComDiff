package ru.netology
import java.util.Scanner

fun main() {
    val scanner = Scanner (System.`in`)
    println("Введите карту")
    val cardType = scanner.nextLine()
    println("Введите сумму, которую уже перевели в этом месяце")
    val pastTransfers = scanner.nextInt()
    println("Введите сумму перевода")
    val transfer = scanner.nextInt()

    transferCalculating(pastTransfers, transfer, cardType)
}

fun transferCalculating (pastTransfers : Int, transfer: Int, cardType: String)  {
    if (transfer > 150000 || transfer + pastTransfers > 600000) {
        println("Достигнут лимит")
    } else {
        println("Сумма к оплате для перевода = " + (transfer + cardTypeCommission(cardType, transfer)).toInt())
    }
}

fun cardTypeCommission (cardType : String, transfer : Int) : Double {
   return when (cardType){
        "Mastercard" -> if (transfer <= 75000) 0.0 else (transfer - 75000)*0.006+20
        "Visa" -> (if (transfer*0.0075 > 35) transfer*0.0075 else 35.0)
        "Мир" -> 0.0
        else -> -1.0
    }
}
