package Chapter03Arrays

trait Logging {
    var exNumber: Int
    def log(x: Any) = println("Exercise " + exNumber + " output: " + x)
}

object Ex1 extends Logging {
    override var exNumber: Int = 1
    
    def genRandomArr(n: Int): Array[Int] = {
        var sq = for (i <- 0 until n) yield scala.util.Random.nextInt(n)
        sq.toArray
    }
}

object Ex2 extends Logging {
    override var exNumber: Int = 2
    
    val arr = Array(1, 2, 3, 4, 5, 6)
    for (i <- 0 until arr.length if i % 2 == 0 && i+1 < arr.length) {
        val t = arr(i); arr(i) = arr(i+1); arr(i+1) = t
    }
    log(arr.mkString(", "))
}

object Ex3 extends Logging {
    override var exNumber: Int = 3
    
    def genNewArr(arr: Array[Int]) :Seq[Int] = for (i <- 0 until arr.length) yield {
        if (i % 2 == 0 && i+1 < arr.length) arr(i+1)
        else {
            if (i+1 == arr.length && i % 2 == 0) arr(i) else arr(i-1)
        }
    }
}

object Ex4 extends Logging {
    override var exNumber: Int = 4
    
    def devideArr(arr: Array[Int]): Array[Int] = {
        val arrIdxPos = for (i <- 0 until arr.length if arr(i) > 0) yield i
        val arrIdxNeg = for (i <- 0 until arr.length if arr(i) <= 0) yield i
        val res = new Array[Int](arr.length)
        for (i <- 0 until arrIdxPos.length) res(i) = arr(arrIdxPos(i))
        for (i <- arrIdxPos.length until arr.length) res(i) = arr(arrIdxNeg(i-arrIdxPos.length))
        res
    }
}

object main extends App {
    Ex1.log(Ex1.genRandomArr(10).mkString(", "))
    Ex2
    Ex3.log(Ex3.genNewArr(Array(1, 2, 3, 4, 5, 6)).mkString(", "))
    Ex4.log(Ex4.devideArr(Array(3, 2, 0, 1, -1, 4, 2, -3, 7, 1, 2, 0, -4, -6, 3, -9)).mkString(", "))
}
