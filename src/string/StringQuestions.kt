package string

class StringQuestions {

    fun reverseString(s: String?): String {
        if (s.isNullOrEmpty()) {
            return s ?: "null"
        }
        val char = s.toCharArray()
        var first = 0
        var last = char.size - 1
        while (first < last) {
            char.swap(first, last)
            first++
            last--
        }
        return String(char)
    }

    fun printDuplicate(s: String?) {
        if (s.isNullOrEmpty()) {
            return
        }
        val char = s.toCharArray()
        val map = HashMap<Char, Int>()
        for (ch in char) {
            if (map.containsKey(ch)) {
                map[ch] = map[ch]!! + 1
            } else {
                map[ch] = 1
            }
        }
        for (data in map) {
//            if (map[data.key]!! > 1){
            println("${data.key} : ${data.value}")
//            }
        }
    }

    fun isAnagram(word: String, anagram: String): Boolean {
        if (word.length == anagram.length) {
            val char = word.toCharArray()
            val anag = StringBuilder(anagram)
            for (letter in char) {
                if (anag.indexOf(letter) != -1) {
                    anag.deleteCharAt(anag.indexOf(letter))
                } else {
                    return false
                }
            }
            return anag.isEmpty()
        }
        return false
    }

    fun reverseOfStringUsingRecursion(str: String): String {
        return if (str.length <= 1) {
            str
        } else {
            val first = str[0]
            val second = str.substring(1)
            reverseOfStringUsingRecursion(second) + first
        }
    }

    fun reverseOnlyWordsInString(str: String): String {
        val wordArray = str.split(" ").toTypedArray()
        for (i in wordArray.indices) {
            wordArray[i] = reverseOnlyWords(wordArray[i])
        }
        return wordArray.joinToString(" ")
    }

    fun reverseOnlyWords(str: String): String {
        return if (str.length <= 1) {
            str
        } else {
            val first = str[0]
            val second = str.substring(1)
            reverseOnlyWordsInString(second) + first
        }
    }

    fun findMaximumOccurringElement(str: String): String {
        if (str.length <= 1) {
            return str
        }
        val char = str.replace(" ", "").toCharArray()
        val map = HashMap<Char, Int>()
        for (ch in char) {
            if (map.containsKey(ch)) {
                map.put(ch, map[ch]!! + 1)
            } else {
                map.put(ch, 1)
            }
        }
        var element = char[0]
        var count = 0
        for (items in map) {
            if (items.value > count) {
                element = items.key
                count = items.value
            }
        }
        return element.toString()
    }

    fun byteArrayToString() {
        val byteArray = byteArrayOf(72, 101, 108, 108, 111) // ASCII values for "Hello"

        // Convert byte array to String
        val resultString = String(byteArray)

        // Print the result
        println("Byte Array: ${byteArray.toList()}")
        println("Result String: $resultString")
    }

    fun arrayStringsFindRepeatedWords(array: Array<String>): String {
        var result = ""
        val map = hashMapOf<String, Int>()
        for (str in array) {
            val strArray = str.split(" ").toTypedArray()
            for (word in strArray) {
                if (map.containsKey(word)) {
                    map.put(word, map[word]!! + 1)
                } else {
                    map.put(word, 1)
                }
            }
        }
        for (words in map) {
            if (words.value > 1)
                result = result + words.key + " "
        }
        return result
    }

    fun removeGivenChar(str: String, givenChar: String): String {
        var result = ""
        for (ch in str) {
            if (ch.toString() != givenChar) {
                result += ch
            }
        }
        return result
    }

    fun removeDuplicate(str: String): String {
        var result = ""
        for (ch in str) {
            if (result.indexOf(ch) == -1) {
                result += ch
            }
        }
        return result
    }

}
 fun CharArray.swap(first: Int, last: Int) {
    val temp = this[first]
    this[first] = this[last]
    this[last] = temp
}
