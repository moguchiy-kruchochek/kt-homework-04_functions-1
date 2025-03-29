fun main() {
    comissionPayment("Mastercard", 23_000, 100_000)
}

fun comissionPayment(card: String, pastTransitionsThisMonth: Int = 0, amountTransition: Int): Int {

    val mastercardLimit = 75_000
    val minMastercardComission = 30
    val mastercardComissionRatio = 0.006
    val visaComissionRatio = 0.004
    var comission = 0


    when (card) {
        "Mastercard" -> when {
            pastTransitionsThisMonth + amountTransition <= mastercardLimit -> comission = minMastercardComission
            pastTransitionsThisMonth + amountTransition > mastercardLimit -> comission =
                ((amountTransition + pastTransitionsThisMonth - mastercardLimit) * mastercardComissionRatio).toInt()
        }

        "Visa" -> comission = (amountTransition * visaComissionRatio).toInt()
    }
    println("Комиссия составит $comission руб.")
    return comission
}

