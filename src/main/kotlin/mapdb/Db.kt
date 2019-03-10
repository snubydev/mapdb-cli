package mapdb

import org.mapdb.DBMaker
import org.mapdb.Serializer
import java.nio.charset.Charset

class Db(file: String) {
    private val db = DBMaker.fileDB(file)
        .checksumHeaderBypass()
        .closeOnJvmShutdown()
        .make()
    private val map = db.treeMap("map", Serializer.STRING, Serializer.BYTE_ARRAY).createOrOpen()

    fun getString(key: String): String {
        return map[key]?.toString(Charset.defaultCharset())?: ""
    }

    fun keys(prefix: String): Iterable<String?> {
        if (prefix.isBlank())
            return map.keys
        val sub = map.subMap(prefix, true, prefix+"z", false)
        return sub.keys
    }

    fun remove(key: String): Boolean {
        return map.remove(key) != null
    }
}
