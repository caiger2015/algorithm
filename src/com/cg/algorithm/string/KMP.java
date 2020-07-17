package com.cg.algorithm.string;


import java.util.Arrays;

/**
 * @author caigen
 * KMP算法O(m+n)
 * 在匹配时，已经对比过且匹配的文本串中的字符是已知的，那么可以利用这些已知字符来快速移动模式串，决定下一次与txt[i]比较的位置，且模式串每个字符不匹配时如何移动模式串只跟模式串有关。
 * next数组 @34讲
 *  匹配：当前字符相同，则i++，j++；当前字符不同，只需找出ptn[0,j-1]子串对应的最长匹配前缀ptn[0,next[j-1]]，然后移动模式串比较txt[i]和新的ptn[j]（j=next[j-1]+1）
 *  构造next[]：把模式串当做文本串和自身进行匹配，跳过首位从i=1开始找最长匹配前缀；当前字符不同时，ptn[0,i-1]对应的最长匹配前缀是ptn[0,k-1]，因为ptn[i]!=ptn[k]所以ptn[0,k]不是ptn[0,i]的最长匹配前缀，又ptn[0,k-1]的最长匹配前缀是ptn[0,next[k-1]]，如果ptn[i]==ptn[next[k-1]+1]，则ptn[0,next[k-1]+1]也是ptn[0,i]的最长匹配前缀，反之继续向前找更短的前缀直至没有更短的前缀(k=-1)；当前字符相同时，k++；
 * dfa确定有限状态自动机
 *  匹配时：当前字符相同，则i++，j++；当前字符不同时，txt[i]也是已知的，所以可以根据模式串决定txt[i++]和ptn[?]比较
 *  构造dfa[0,256][]：@p499 dfa[][j]根据k=dfa[ptn.charAt[j][k]对每个字符单独的next数组进行更新：相等时dfa[ptn[j]][j]=j+1，不等时dfa[c][j]=dfa[c][k]
 */
public class KMP {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KMP().getNext("abcabcababc")));
        System.out.println(Arrays.toString(new KMP().getNext2("abcabcababc")));
    }

    /**
     * @param ptn
     * @return next[]存储的是当txt[i]!=ptx[j]时，应该和txt[i]比较的j的index是next[j]，
     * 是将getNext的结果后移一位+1的结果（首位末尾都是-1，首位不比较，末位比较不相等时用到的是倒数第二位的next[]值）
     */
    public int[] getNext2(String ptn) {
        int n = ptn.length();
        int k = -1;
        int i = 1;
        int[] next = new int[n];
        //首位无匹配的前缀
        next[0] = -1;
        //最后一位相同时说明已经匹配了，无需在下一位记录最长匹配前缀（且会在i++时溢出）
        while (i < n - 1) {
            //相等时，先i++，k++(将k+1记录在i的下一位),因为[0,i]==[0,k],所以当ptn[i+1]!=ptn[k+1]时，可以继续比较i+1和next[i+1]
            //等价于在kmp时比较i和next[j-1]+1 在kmp匹配时txt[i]!=ptn[j]时j移动到的位置，即j=next[j]
            if (k == -1 || ptn.charAt(i) == ptn.charAt(k)) {
                i++;
                k++;
                next[i] = k;
//                next[++i] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int kmp2(String txt, String ptn) {
        int j = 0, i = 0, n = txt.length(), m = ptn.length();
        int[] next = getNext2(ptn);
        while (i < n && j < m) {
            //j==-1说明没有匹配的前缀，向后移动i、j
            if (j == -1 || txt.charAt(i) == ptn.charAt(j)) {
                j++;
                i++;
            //不相等时，txt[0,i-1]==ptn[0,j-1]对应的最长匹配前缀为ptn[0,next[j]-1]，移动ptn比较txt[i]和ptn[next[j]]
            } else {
                j = next[j];
            }
        }
        if (j == m) {
            return i - j;
        }
        return -1;
    }

    /**
     * @param ptn
     * @return next[] 存储的是ptn[i]对应的最长匹配前缀的index，kmp中不匹配时需要重新比较txt[i]和ptn[next[j-1]+1]
     */
    public int[] getNext(String ptn) {
        if (ptn == null || ptn.length() == 0) {
            return null;
        }
        int n = ptn.length();
        int k = -1;//k从-1开始
        int[] next = new int[n];
        next[0] = -1;//第0位无最长匹配前缀，设为-1
        //i从1开始，寻找[0,i]的最长匹配前缀
        for (int i = 1; i < n; i++) {
            //k从-1开始，ptn.charAt(i) != ptn.charAt(k+1)时，[0,i-1]的最长匹配前缀是[0,k]，
            //比较第i位和[0,k]的最长匹配前缀ptn.charAt(next[k])
            while (k != -1 && ptn.charAt(i) != ptn.charAt(k + 1)) {
                k = next[k];
            }
            //ptn.charAt(i) == ptn.charAt(k+1)表示模式串[0,i]的最长匹配前缀是[0,k+1]
            if (ptn.charAt(i) == ptn.charAt(k + 1)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public int kmp(String txt, String ptn) {
        if (txt == null || ptn == null || txt.length() == 0 || ptn.length() == 0) {
            return -1;
        }
        int j = 0, i = 1, n = txt.length(), m = ptn.length();
        int[] next = getNext(ptn);
        while (i < n && j < m) {
            //txt[i]!=ptn[j]时，根据next得到ptn[0,j-1]的最长匹配前缀是ptn[0,next[j-1]],
            //移动模式串，比较txt[i]和ptn[next[j-1]+1]直到相等或j=-1
            while (j > 0 && txt.charAt(i) != ptn.charAt(j)) {
                j = next[j - 1] + 1;
            }
            if (txt.charAt(i) == ptn.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j == m) {
            return i - j;
        }
        return -1;
    }
}
