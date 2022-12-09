import domain.FindLongestPalindromicListUseCaseImpl
import domain.FindLongestStringListUseCaseImpl
import domain.GetSubStringPalindromicListUseCaseImpl

fun main() {

    val getSubStringPalindromicListUseCase = GetSubStringPalindromicListUseCaseImpl()
    val findLongestStringListUseCase = FindLongestStringListUseCaseImpl()

    val findLongestPalindromicListUseCase = FindLongestPalindromicListUseCaseImpl(
        getSubStringPalindromicListUseCase, findLongestStringListUseCase
    )

    val result1 = findLongestPalindromicListUseCase.execute("babad")
    val result2 = findLongestPalindromicListUseCase.execute("cbbd")

    println("result1 $result1") // [aba, bab]
    println("result2 $result2") // [bb]
}