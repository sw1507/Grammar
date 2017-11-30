// Stuart Reges
// 1/31/07
//
// Short program to test whether the expressions generated using the file
// sentence3.txt are legal.  They can often by very long.  You should include
// the expression as indicated below and you should be able to compile the
// program.  It might throw an exception when run, but it should compile.

import static java.lang.Math.*; // so we can write abs instead of Math.abs

@SuppressWarnings("unused")
public class TestExpression {
	public static void main(String[] args) {
		double x = 3;
		double y = 4;
		double z = max ( ( x + tan ( x ) / pow ( ( 1 ) * pow ( 0 , 92 ) , x ) ) , y ) - - x % 1 - - 0 / min ( 42 * sqrt ( x + 1 ) % pow ( - x / - y - ( abs ( x - x ) - 42 - 0 / y - pow ( 92 , x % - x / 0 ) ) , 0 + min ( 1 / 0 - 42 , 0 ) ) , 92 );
		System.out.println(z);
	}
}
