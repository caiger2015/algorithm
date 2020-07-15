package com.cg.leetcode.bitManipulation;

/*
 * Reverse bits of a given 32 bits unsigned integer. For example, given input 43261596 (00000010100101000001111010011100),  return 964176192 (00111001011110000010100101000000).
 */
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int j = i << 1;// result：i = 1；j = 2；
		System.out.println(i + "  " + j);
		System.out.print(reverseBits1(-2147483647) + "");
	}

	/*
	 * 对比特数的运算采取位操作 | & ^ ~（非）>> <<（高位补符号位） >>>（高位补0） 可以实现模2^n运算，去特定位运算。&1 判断奇偶，
	 * 注意:移位操作不改变原来的数，但会返回移位的结果 所有的运算都是转换成补码的形式来进行的， 正数本身，负数符号位不变其它位取反加一
	 * 注意2：移位时移位的数和位数都转换为补码的形式操作
	 * 对于int一共有32位，如果所移位数是负数，则只取低五比特的数进行移位-1>>>-1结果为1，-1>>>-2结果为3 等效为移位32-2位
	 */
	public static int reverseBits(int n) {
		int i = 0;
		int res = 0;
		res = (n & 1);// 去最低位
		i++;
		while (n != 0 && i < 32)// 一次取最高位，终止条件是n = 0，或已经移位32次
		{
			res = res << 1;
			res |= (n >>> 1) & 1;// 补充最低位
			n >>>= 1;
			i++;
		}
		res = res << (32 - i);
		return res;
	}

	/*
	 * 分治法：每次分两组交换，知道交换的是两位bit
	 */
	public static int reverseBits1(int n) {
		n = (n >>> 16) & 0x0000ffff | (n << 16) & 0xffff0000;
		n = (n >>> 8) & 0x00ff00ff | (n << 8) & 0xff00ff00;
		n = (n >>> 4) & 0x0f0f0f0f | (n << 4) & 0xf0f0f0f0;
		n = (n >>> 2) & 0x33333333 | (n << 2) & 0xcccccccc;
		n = (n >>> 1) & 0x55555555 | (n << 1) & 0xaaaaaaaa;
		return n;
	}
}
