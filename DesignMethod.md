# 算法设计方法

## 1、枚举法

> 在进行归纳推理时，如果逐个考察了某类事件的所有可能情况，因而得出一般结论，那么该结论是可靠的，那种归纳方法叫做枚举

### 1， 枚举算法基础

枚举一般使用while循环实现

- 枚举算法解题的基本思路

  1.  确定枚举对象，枚举范围和判定条件

  2.  逐一枚举可能的解，验证每个解是否是问题的解

- 一般步骤

  1.  解题的可能范围，不能遗漏任何一个真正的解，也要避免重复

  2.  判断是否是真正的解的方法

  3.  是可能的解的范围缩小至最小，以便提高解决问题的效率

### 2, 运用枚举法是需要面对的问题

| 特点及要求 | 可能出现的问题 |
| ------------- | :-------------: |
| 选取考察对象 | 选取的考察对象不恰当 |
| 逐个考察所有可能的情况 | 没有“逐个”考察，不恰当地遗漏了一些情况;没有考察“所有”，对空间集的确定失误 |
| 选取判断标准 | 判断标准“不正确”，导致结果错误；判断标准“不全面”，导致结果错误或得到结果的效率下降；判断标准“不高效”，意味着没有足够地剪枝

--- 

## 2、递推

> 通过在已知的某个条件，利用特定的关系得到中间的推论，然后逐步递推，知道结果为止

### 1， 递推算法基础

- 顺推法：从已知条件出发，逐步推算出要解决问题的方法。

- 逆推法：从已知的结果出发，用迭代表达式推算出问题开始的条件

---

## 3、递归

### 1, 递归算法基础

- 特点

  1.  递归过程一般通过函数或子函数过程来实现

  2.  递归算法在函数或子过程的内部，直接或间接地调用自己的算法

  3.  递归算法实际上是吧问题转化为规模缩小了的同类问题的子问题，然后在递归调用函数或过程来表示问题的解

- 注意点

  1.  递归是在过程或函数中调用自身的过程

  2.  在使用递归策略时，必须有一个明确的递归条件，这称为递归出口

  3.  递归算法通常显得简洁，但是运行效率较低，所以一般不提倡递归算法设计程序

  ### 2， 递归与递推的差异

  > 递推像是多米诺骨牌，根据前面几个得到后面的；递归是大事化小；如果一个问题的求解既可以递归算法求解，也可以递推算法求解，此时往往选择用递推算法，因为递推的效率比递归高

---

## 4、分治法

> 将一个规模为N的问题分解为K个规模较小的子问题，这些问题相互独立且与原问题性质相同。

### 1， 分治算法基础

- 一般步骤

1.  分解：将要解决的问题划分为若干个规模较小的同类问题

2.  求解：当子问题划分的足够小时，用较简单的方法解决

3.  合并：按原问题的要求，将子问题的解逐层合并构成原问题的解

---

## 5、动态规划

## 6、贪心法

## 7、回溯法

> 回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法

-   示例

    -   [八皇后问题](./src/test/java/divide/onquer/EightQueens.kt)
    
    -   [全排序问题](./src/test/java/divide/onquer/FullSort.kt)
    
    -   [数字拆分](./src/test/java/divide/onquer/DigitalSplit.kt)
    
## 8、分支限界法