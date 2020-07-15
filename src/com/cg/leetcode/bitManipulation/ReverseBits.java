package com.cg.leetcode.bitManipulation;

/*
 * Reverse bits of a given 32 bits unsigned integer. For example, given input 43261596 (00000010100101000001111010011100),  return 964176192 (00111001011110000010100101000000).
 */
public class ReverseBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int j = i << 1;// result��i = 1��j = 2��
		System.out.println(i + "  " + j);
		System.out.print(reverseBits1(-2147483647) + "");
	}

	/*
	 * �Ա������������ȡλ���� | & ^ ~���ǣ�>> <<����λ������λ�� >>>����λ��0�� ����ʵ��ģ2^n���㣬ȥ�ض�λ���㡣&1 �ж���ż��
	 * ע��:��λ�������ı�ԭ�����������᷵����λ�Ľ�� ���е����㶼��ת���ɲ������ʽ�����еģ� ����������������λ��������λȡ����һ
	 * ע��2����λʱ��λ������λ����ת��Ϊ�������ʽ����
	 * ����intһ����32λ���������λ���Ǹ�������ֻȡ������ص���������λ-1>>>-1���Ϊ1��-1>>>-2���Ϊ3 ��ЧΪ��λ32-2λ
	 */
	public static int reverseBits(int n) {
		int i = 0;
		int res = 0;
		res = (n & 1);// ȥ���λ
		i++;
		while (n != 0 && i < 32)// һ��ȡ���λ����ֹ������n = 0�����Ѿ���λ32��
		{
			res = res << 1;
			res |= (n >>> 1) & 1;// �������λ
			n >>>= 1;
			i++;
		}
		res = res << (32 - i);
		return res;
	}

	/*
	 * ���η���ÿ�η����齻����֪������������λbit
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
