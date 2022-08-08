import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val number: Int = scanner.nextInt()
//
   var sum: Int = 0
//    val average: Int = 0
//
//    for (num in number.rangeTo(1000)){
//        sum +=number
//    }


//    val numArray = doubleArrayOf(45.3, 67.5, -45.6, 20.34, 33.0, 45.6)
//    var sum = 0.0
//
//    for (num in numArray) {
//        sum += num
//    }
//
//    val average = sum / numArray.size
//    println("The average is: %.2f".format(average))


    var flag = false
    for (i in 2..number / 2) {
        // condition for nonprime number
        if (number % i == 0) {
            flag = true
            sum += number
            break
        }
    }

    if (!flag)
        println("$number is a prime number.")
    else
        println("$number is not a prime number.")

}