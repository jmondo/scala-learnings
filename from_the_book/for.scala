// Example from 7L7W

def forLoop { 
  println("for loop using java style iteration")
  // i <- (0 until args.length)
  // all the i's in the range (0 until args.length)
  for(i <- 0 until args.length) {
    println(args(i))
  }
}

forLoop
