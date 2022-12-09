package domain

interface FindLongestPalindromicListUseCase {

    fun execute(inputString: String): List<String>
}

class FindLongestPalindromicListUseCaseImpl(
    private val getSubStringPalindromicListUseCase: GetSubStringPalindromicListUseCase,
    private val findLongestStringListUseCase: FindLongestStringListUseCase
) : FindLongestPalindromicListUseCase {

    override fun execute(inputString: String): List<String> {
        val subStringPalindromicList = getSubStringPalindromicListUseCase.execute(inputString)
        val longestPalindromicList = findLongestStringListUseCase.execute(subStringPalindromicList)
        return longestPalindromicList
    }
}