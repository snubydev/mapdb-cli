package mapdb
import com.xenomachina.argparser.ArgParser

class Args(parser: ArgParser) {
    val verbose by parser.flagging(
        "-v", "--verbose",
        help = "enable verbose mode")

//    val name by parser.storing(
//        "-n", "--name",
//        help = "name of the user")

//    val count by parser.storing(
//        "-c", "--count",
//        help = "number of widgets") { toInt() }

    val db by parser.positional(
        "DB",
        help = "source db filename")

    val command by parser.positional(
        "COMMAND",
        help = "command")

    val params by parser.positionalList(
        "PARAMS",
        sizeRange = 0..1,
        help = "params"
    )
}