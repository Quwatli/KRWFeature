import java.io.FileReader
import java.io.FileWriter
import kotlin.system.exitProcess

fun main(args: Array<String>) {

    menu()
    run()


}

fun run () {

    var op: Int?
    var msg: String?

    try {
        op = readLine()!!.toInt()

        while (op == null) {
            println("Please select an option from the menu")
            op = readLine()!!.toInt()
        }

        while (op != 3) {


            when (op) {

                1 -> {
                    msg = readLine().toString()
                    println("Writing...")
                    write(msg)
                    println("File written successfully")
                    read()

                }

                2 -> {
                    println("Reading...")
                    read()

                }

                3 -> {
                    println("Exiting...")
                    exitProcess(0)

                }

                else -> {
                    println("Your Choice Must Be Either 1 to write, 2 to read or 3 to exit")
                    run()
                }


            }
            op = readLine()!!.toInt()
        }
    } catch (e: Exception) {
        println("Please make sure your input is an integer and try again\n")
        menu()
        run()
    }
}

fun menu() {
    println("This is a reusable R/W file feature\n" +
            "Select an option:/n" +
            "To Write A Message to File: Press 1\n" +
            "To Read A File: Press 2\n" +
            "To Exit This Feature: Press 3\n")
}

fun read() {

    var reader = FileReader("RWFeature.txt")

    var char: Int?

    try {
        do {
            char = reader.read()
            print(char.toChar())
        } while (char != -1)
    } catch (e: Exception) {
        println("Problem reading from file: " + e)
    }

}

fun write(msg: String) {

    try {
        var writer = FileWriter("RWFeature.txt", true)
        writer.write(msg + "\n")
        writer.close()
    } catch (ex: Exception) {
        println("Exception: " + ex)
    }
}