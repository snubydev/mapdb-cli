package mapdb

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.MissingRequiredPositionalArgumentException
import com.xenomachina.argparser.UnexpectedOptionArgumentException
import com.xenomachina.argparser.UnexpectedPositionalArgumentException
import java.lang.Exception

fun main(args: Array<String>) {
    var parsed: Args? = null
    try {
        parsed = ArgParser(args).parseInto(::Args)
        when(parsed.command) {
            "keys" -> {
                val prefix = if (parsed.params.isNotEmpty()) parsed.params[0] else ""
                Db(parsed.db)
                    .keys(prefix)
                    .forEach(::println)
            }
            "get" -> {
                println(Db(parsed.db).getString(parsed.params[0]))
            }
            "remove" -> {
                if (Db(parsed.db).remove(parsed.params[0]))
                    println("key: ${parsed.params[0]} removed")
            }
            else -> println("unknown command")
        }
    } catch (e: Exception) {
        when(e) {
            is MissingRequiredPositionalArgumentException,
            is UnexpectedOptionArgumentException,
            is UnexpectedPositionalArgumentException -> {
                println(e.localizedMessage)
            }
            else -> throw e
        }
    }
}