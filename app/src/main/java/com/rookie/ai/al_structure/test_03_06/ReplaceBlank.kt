package com.rookie.ai.al_structure.test_03_06

/**
 * 一、题目
 *请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则
 *输出“We%20are%20happy.”。
 */

fun main(args: Array<String>) {
    var str = "We are happy"
    replaceBlank(str);
}


fun replaceBlank(str: String) {
    if (str == null || str.isEmpty()) {
        return
    }

    var result = str.replace(" ", "%20")
    println(str)
    println(result)
}
