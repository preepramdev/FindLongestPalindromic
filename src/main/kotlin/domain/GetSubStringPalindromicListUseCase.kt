package domain

interface GetSubStringPalindromicListUseCase {

    fun execute(originalString: String): List<String>
}

class GetSubStringPalindromicListUseCaseImpl : GetSubStringPalindromicListUseCase {

    override fun execute(originalString: String): List<String> {
        val subStringList = getSubStringList(originalString)
        val subStringPalindromicList = subStringList.filter { subString ->
            isPalindromeString(subString)
        }
        return subStringPalindromicList
    }

    private fun getSubStringList(input: String): List<String> {
        val inputLength = input.length
        val resultList: MutableList<String> = mutableListOf()
        val dp = Array(inputLength) { BooleanArray(inputLength) }
        for (i in inputLength - 1 downTo 0) {
            for (j in i until inputLength) {
                dp[i][j] = input[i] == input[j] && (j - i < 3 || dp[i + 1][j - 1])
                val inputSubString = input.substring(i, j + 1)
                if (inputSubString.length < inputLength) {
                    resultList.add(inputSubString)
                }
            }
        }
        return resultList.sorted().distinct()
    }

    private fun isPalindromeString(inputStr: String): Boolean {
        val sb = StringBuilder(inputStr)
        val reverseStr = sb.reverse().toString()
        return inputStr == reverseStr
    }
}