package Chapter02Functions

trait Logging {
    var exNumber: Int
    def log(x: Any) = println("Exercise " + exNumber + " output: " + x)
}

object Ex2 extends Logging {
    override var exNumber: Int = 2
    
    val a = {}
    log(a)
}

object Ex4 extends Logging {
    override var exNumber: Int = 4
    
    for (i <- 0 to 10; j = 10 - i) log(j)
}

object Ex10 extends Logging {
    override var exNumber: Int = 10
    
    def myPow(x: Double, n: Int): Double = if (n == 0) 1
        else {
            if (n < 0) 1 / myPow(x, -n)
            else {
                if (n % 2 == 1) x * myPow(x, n-1)
                else {
                    val y = myPow(x, n/2)
                    y * y
                }
            }
        }
}

object main extends App {
    Ex2
    Ex4
    Ex10.log(Ex10.myPow(2, 5))
    Ex10.log(Ex10.myPow(2, 8))
    Ex10.log(Ex10.myPow(2, -2))
    Ex10.log(Ex10.myPow(2, 0))
}