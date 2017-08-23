package Chapter01Basics

trait Logging {
    var exNumber: Int
    def log(x: Any) = println("Exercise " + exNumber + " output: " + x)
}

object Ex6 extends Logging {
    override var exNumber: Int = 6

    log(BigInt(2).pow(1024))
}

object Ex7 extends Logging {
    override var exNumber: Int = 7
    
    import BigInt.probablePrime
    import scala.util.Random
    log(probablePrime(100, Random))
}

class Ex9(str: String) extends Logging {
    override var exNumber: Int = 9
    
    log((str.head, str.last))
}

object main extends App {
    Ex6
    Ex7
    new Ex9("Hello")
}
