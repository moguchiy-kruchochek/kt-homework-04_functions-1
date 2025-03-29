import org.junit.Test

import org.junit.Assert.*


class MainKtTest {

    @Test
    fun comissionForTransactionsGreaterThanLimit() {
        val card = "Mastercard"
        val pastTransitionsThisMonth = 40_000
        val amountTransition = 100_000

        val comission = comissionPayment(card, pastTransitionsThisMonth, amountTransition)

        assertEquals(390, comission)
    }



    @Test
    fun comissionForTransactionsLessThanLimit() {
        val card = "Mastercard"
        val pastTransitionsThisMonth = 10_000
        val amountTransition = 3_250

        val comission = comissionPayment(card, pastTransitionsThisMonth, amountTransition)

        assertEquals(30, comission)
    }


    @Test
    fun comissionForVisa() {
        val card = "Visa"
        val pastTransitionThisMonth = 0
        val amountTransition = 100_000

        val comission = comissionPayment(card, pastTransitionThisMonth, amountTransition)

        assertEquals(400, comission)
    }

    @Test
    fun comissionForVisaButAnotherCardUsed() {
        val card = "Mir"
        val pastTransitionThisMonth = 0
        val amountTransition = 100_000

        val comission = comissionPayment(card, pastTransitionThisMonth, amountTransition)

        assertEquals(0, comission)
    }
}