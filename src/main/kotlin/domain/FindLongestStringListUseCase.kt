package domain

interface FindLongestStringListUseCase {

    fun execute(originalStrings: List<String>): List<String>
}

class FindLongestStringListUseCaseImpl : FindLongestStringListUseCase {

    override fun execute(originalStrings: List<String>): List<String> {
        if (originalStrings.isEmpty()) return emptyList()
        val maxLength = findMaxLength(originalStrings)
        val longestStringList = originalStrings.filter { originalString ->
            originalString.length == maxLength
        }
        return longestStringList
    }

    private fun findMaxLength(originalStrings: List<String>): Int {
        return originalStrings.maxOf { it.length }
    }
}