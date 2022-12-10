package cinema

var cinema = arrayOf<Array<Char>>()
var rows = 0
var seats = 0
var namberOfPurchasedTickets = 0
var totalIncome = 0


fun main() {
    println("Enter the number of rows: ")
    rows = readln().toInt()
    println("Enter the number of seats in each row: ")
    seats = readln().toInt()
    for (i in 0 until rows) {
        var array = arrayOf<Char>()
        for (j in 0 until seats) {
            array += 'S'
        }
        cinema += array
    }
    println()
    menu()


}

fun room() {
    println("Cinema:")
    print("  ")
    for (i in 1..seats) {
        print("$i ")   }
    println()
    var s = 1
    for (array in cinema) {
        print("$s ")
        for (value in array) {
            print("$value ")
        }
        println()
        s += 1
    }
    println()
}

fun menu() {
    var i = 0
    while (i == 0) {
    println("1. Show the seats\n" +
            "2. Buy a ticket\n" +
            "3. Statistics\n" +
            "0. Exit")
    var n = readln().toInt()
        println()
        when(n) {
            1 -> room()
            2 -> buy()
            3 -> statistics()
            0 -> break
        }
    }
}

fun buy() {
    var enterRow = 0
    var enterSeat = 0
    var total = 0
    var i = 0
    while (i == 0){
        println("Enter a row number:")
        enterRow = readln().toInt()
        println("Enter a seat number in that row:")
        enterSeat = readln().toInt()
        println()
        if (enterRow > rows || enterSeat > seats) {
            println("Wrong input!")
            println()
        } else if (cinema[enterRow - 1][enterSeat - 1] == 'B') {
            println("That ticket has already been purchased!")
            println()
        } else {
            i++
        }
    }
    i = 0
    when {
        rows * seats < 60 -> total = 10
        rows % 2 == 0 && enterRow <= rows / 2 -> total = 10
        rows % 2 == 0 && enterRow > rows / 2 -> total = 8
        rows % 2 != 0 && enterRow <= rows / 2 -> total = 10
        rows % 2 != 0 && enterRow > rows / 2 -> total = 8
    }
    println("Ticket price: \$$total")
    println()
    cinema[enterRow - 1][enterSeat - 1] = 'B'
    namberOfPurchasedTickets++
    totalIncome += total

}

fun statistics() {
    var total = 0
    var percentage = 100 / (rows.toDouble() * seats.toDouble()) * namberOfPurchasedTickets.toDouble()
    var formatPercentage = "%.2f".format(percentage)
    when {
        rows * seats < 60 -> total = rows * seats * 10
        rows % 2 == 0 -> total = ((rows / 2) * seats * 10) + ((rows / 2) * seats * 8)
        else -> total = ((rows / 2) * seats * 10) + (((rows / 2) + 1) * seats * 8)
    }
    println("Number of purchased tickets: $namberOfPurchasedTickets")
    println("Percentage: $formatPercentage%")
    println("Current income: $$totalIncome")
    println("Total income: $$total")
    println()
}
