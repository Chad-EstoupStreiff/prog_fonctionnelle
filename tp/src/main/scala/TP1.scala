import scala.annotation.tailrec

object TP1Ex1:

  /* Définissez les opérateurs booléens suivants en utilisant des expressions conditionnelles
   * et les valeurs 'true' et 'false' */
  def not(b: Boolean): Boolean = !b

  def and(l: Boolean, r: Boolean): Boolean = l.&&(r)

  def or(l: Boolean, r: Boolean): Boolean = l.||(r)

  def xor(l: Boolean, r: Boolean): Boolean = l.^(r)

  /* Définissez la valeur absolue d'un nombre */
  def abs(x: Double): Double = x.abs

  /* Définissez la factorielle d'un nombre positif à l'aide d'une fonction récursive */
  def factorial(n: BigInt): BigInt =
    if n < 0 then
      throw new IllegalArgumentException("negative integer")
    else if (n == 0) 1 else n.*(factorial(n - 1))

  /* Définissez l'exponentiation à l'aide d'une fonction récursive */
  def power(b: BigInt, n: Int): BigInt =
    if n < 0 then
      throw new IllegalArgumentException("negative integer")
    else if (n == 0) 1
    else
      val pR = power(b, n / 2)
      if (n % 2 == 0) pR.pow(2) else b * pR.pow(2)

  /* Définissez une fonction récursive qui calcule la somme des entiers de n à m (inclus). */
  def sumSegment(n: Int, m: Int): Int =
    if (n > m) 0
    else if (n < m) n + sumSegment(n + 1, m) else m

  /* Définissez une fonction non-récursive qui effectue le même calcul.
   * Indication: utilisez la formule pour calculer la somme des n premiers entiers: n * (n + 1) / 2 */
  def fastSumSegment(n: Int, m: Int): Int = (m * (m + 1) / 2) - (n * (n + 1) / 2) + n

  /* Définissez une fonction récursive qui calcule la représentation en binaire d'un entier n */
  def binaryString(n: Int): String =
    if (n < 0) return "-" + binaryString(n.abs)
    if (n == 0) "0"
    else if (n == 1) "1"
    else if (n % 2 == 0) binaryString(n / 2) + "0"
    else binaryString(n / 2) + "1"

  /* Définissez une fonction qui calcule le PGCD de deux nombres, en vous basant sur l'algorithme d'Euclide */
  def gcd(a: Int, b: Int): Int =
    if (a == 0) 0
    else if (b == 0) a.abs
    else gcd(b, a % b)

  @main def mainTP1Ex1 =
    println("Hello, world!")
    println(s"not(${true}) is ${not(true)}")
    println(s"and(${true}, ${false}) is ${and(true, false)}")
    println(s"or(${true}, ${false}) is ${or(true, false)}")
    println(s"xor(${true}, ${false}) is ${xor(true, false)}")
    val x = -1.895
    println(s"the absolute value of ${x} is ${abs(x)}")
    val n = 6
    println(s"the factorial of ${n} is ${factorial(n)}")
    val b1 = 9
    val n1 = 5
    println(s"${b1} raised to the power of ${n1} is ${power(b1, n1)}")
    val n3 = 3
    val m3 = 9
    println(s"the sum of integers from ${n3} to ${m3} is ${sumSegment(n3, m3)}")
    val n4 = 18
    val m4 = 29
    println(s"the sum of integers from ${n4} to ${m4} is ${sumSegment(n4, m4)}")
    println(s"the binary representation of ${n4} is ${binaryString(n4)}")
    val a = 64
    val b = 24
    println(s"the greatest commond divisor of ${a} and ${b} is ${gcd(a, b)}")