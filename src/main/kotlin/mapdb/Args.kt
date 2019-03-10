package mapdb
import com.xenomachina.argparser.ArgParser

class Args(parser: ArgParser) {
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