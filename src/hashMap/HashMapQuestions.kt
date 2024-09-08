package hashMap

class HashMapQuestions {


// [100,4,200,1,3,2] // 128. Longest Consecutive Sequence
    // 4

//    fun longestConsecutive(nums: IntArray): Int {
//
//    }
//


    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val list = hashMapOf<Char, Int>()
        for (char in s) {
            val count = list.getOrDefault(char, 0)
            list[char] = count + 1
        }

        for (char in t) {
            val count = list.getOrDefault(char, -1)
            list[char] = count - 1
            if (count <= 0) {
                return false
            }
        }
        return true
    }

}