## mapdb -  command line interface to MapDB in Java

#### Usage   

First make an alias in ~/.profile  
alias mapdb="java -jar <path>/mapdb.jar"

```
mapdb <file> <command> <params>...
```
Examples:
```
mapdb kv.db keys  // prints all the keys from db
```
```
mapdb kv.db keys prefix  // prints all the keys by prefix
```
```
mapdb kv.db get some_key // prints value as string by given key
```
```
napbd kv.db remove some_key // remove an item by key from db
```

#### Not implemented

* put
 