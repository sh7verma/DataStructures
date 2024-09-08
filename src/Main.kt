import org.intellij.lang.annotations.Flow
import java.lang.Error

object Main {
    @JvmStatic
    fun main(args: Array<String>) {


    }
}

    fun isPalindrome(
        s: String
    ): Boolean {
        var left = 0
        var rignt = s.lastIndex
        while (left <= rignt) {
            if (s[left] == s[rignt]) {
                left++
                rignt--
            } else {
                return false
            }
        }
        return true
    }




