package com.cg.algorithm.string;


import java.util.Arrays;

/**
 * @author caigen
 * KMP算法O(m+n)
 *  利用动态规划的思想得到next数组或dfa状态机，比较txt和ptn时快速移动ptn减少比较次数
 *  在匹配时，txt串不断向后移动，已经对比过且匹配的文本串中的字符是已知的，那么可以利用这些已知字符来快速移动模式串，决定下一次与txt[i]比较的位置，且模式串每个字符不匹配时如何移动模式串只跟模式串本身有关。用动态规划的思想，得到模式串每个位置j对应的最长前缀子串[0,k]
 * next[]数组（存最长匹配前缀子串末尾） @34讲
 *  含义：next[j]表示ptn[j]对应的最长匹配前缀子串是ptn[0,next[j]]，
 *  匹配：当前字符相同，则i++，j++；当前字符不同时，只需找出ptn[0,j-1]子串对应的最长匹配前缀ptn[0,next[j-1]]，然后移动模式串比较txt[i]和ptn[next[j-1]+1]
 *  构造next[]：
 *      把模式串当做文本串ptn[0,k]和ptn[1,j]匹配，跳过首位从i=1开始找最长匹配前缀，初始状态next[0]=-1，-1表示无匹配
 *      当前字符相同时，next[j++]=k++；当前字符不同时，ptn[0,i-1]对应的最长匹配前缀是ptn[0,k-1]，因为ptn[i]!=ptn[k]所以ptn[0,k]不是ptn[0,i]的最长匹配前缀，又ptn[0,k-1]的最长匹配前缀是ptn[0,next[k-1]]，如果ptn[i]==ptn[next[k-1]+1]，则ptn[0,next[k-1]+1]也是ptn[0,i]的最长匹配前缀，反之继续向前找更短的前缀直至没有更短的前缀(k=-1)；
 * next[]数组（存不匹配时txt[i]需要比较的ptn[j])
 *  含义：next[j]表示ptn[j]!=txt[i]时，接下来要跟txt[i]比较的是ptn[j]，
 *  匹配：当前字符相同，则i++，j++；当前字符不同时，根据next的含义，移动模式串比较txt[i]和ptn[next[j]]
 *  构造next[]：
 *      把模式串当做文本串ptn[0,k]和ptn[1,j]匹配，跳过首位从i=1开始找最长匹配前缀，初始状态next[0]=-1，-1表示无匹配
 *      当前字符相同时，next[++i]=++k，[0,i]对应的最长匹配前缀是[0,k]，进一位存储表示当i+1不匹配时，继续比较k+1
 * dfa[][]（确定有限状态自动机）
 *  含义：dfa[256][m]表示ptn[0,j]在状态j时，对应的最长匹配前缀的长度是dfa[ptm.charAt[j]],[j]，存储了txt[i]是256个字符时所有可能的最长匹配前缀长度
 *  匹配时：txt不断进位i++，跟txt[0,i]对应的最长匹配前缀长度是ptn.charAt(dfa[txt[i]],[j])，若该值等于m，说明匹配成功跳出循环
 *  构造dfa[0,256][]：@p499
 *      把模式串当做文本串ptn[0,k]和ptn[1,j]匹配，初始状态dfa[charAt[0]],[0]=1，表示ptn[0]=ptn[0]时对应的最长匹配前缀长度是1
 *      对于新的状态j和ptn[j]，先将不同字符上一个状态k的值复制到所有字符数组dfa[c][j]=dfa[c][k]（状态后退）
 *      再对相同字符dfa[ptn.charAt(j)][j]=j+1（状态前进）
 *      最后将当前字符对应的状态传给++j状态k=dfa[ptn.charAt(j),k]（状态传递）；
 */
public class KMP {
    public static void main(String[] args) {
        System.out.println((new KMP().kmp("1ababac12312", "ababac")));
        System.out.println((new KMP().kmp2("1ababac12312", "ababac")));
        System.out.println((new KMP().kmp3("1ababac12312", "ababac")));
    }

    /**
     * @param ptn
     * @return next[]存储的是当txt[i]!=ptx[j]时，应该和txt[i]比较的ptn的index是next[j]，
     *         是将getNext1的结果后移一位+1的结果（首位末尾都是-1，首位不比较，末位比较不相等时用到的是倒数第二位的next[]值）
     */
    public int[] getNext2(String ptn) {
        int n = ptn.length();
        int k = -1;
        int i = 1;
        // dp1：next[]含义是当ptn[i]!=ptn[k]时，接下来比较的是ptn[i]和ptn[next[k]]
        // 在匹配文本时，当txt[i]!=ptx[j]，应该和txt[i]比较的是ptn[next[j]]
        int[] next = new int[n];
        // dp2：设置初值，首位无匹配的前缀
        next[0] = -1;
        // 最后一位相同时说明已经匹配了，无需在下一位记录最长匹配前缀（且会在++i时溢出）
        while (i < n - 1) {
            // dp3：状态前进，相等时，先i++，k++(将k+1记录在i的下一位),因为[0,i]==[0,k],所以当ptn[i+1]!=ptn[k+1]时，可以继续比较ptn[i+1]和ptn[next[k+1]]
            if (k == -1 || ptn.charAt(i) == ptn.charAt(k)) {
                // 先++，将结果往后存一位
                next[++i] = ++k;
            } else {
                //dp4：状态后退，比较上一个个状态
                k = next[k];
            }
        }
        System.out.println("next2:" + Arrays.toString(next));
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
        int k = 0;
        int[] next = new int[n];
        //第0位无最长匹配前缀，设为-1（动态规划设置初值）
        next[0] = -1;
        //i从1开始
        int i = 1;
//        while (i < n) {
//            if (k == -1 || ptn.charAt(k) == ptn.charAt(i)) {
//                next[i++] = k++;
//            } else if (k == 0) {
//                next[i++] = -1;
//            } else {
//                k = next[k - 1] + 1;//上一个匹配状态状态[0,k-1]对应的最长匹配前缀的下一位ptn[next[k-1]+1]
//            }
//        }
        for (; i < n; i++) {
            while (k > 0 && ptn.charAt(k) != ptn.charAt(i)) {
                k = next[k - 1] + 1;
            }
            if (ptn.charAt(k) == ptn.charAt(i)) {
                next[i] = k++;
            } else {//k==0的比较首字母不相等的情况无匹配的前缀
                next[i] = -1;
            }
        }
        System.out.println("next1" + Arrays.toString(next));
        return next;
    }

    public int kmp(String txt, String ptn) {
        if (txt == null || ptn == null || txt.length() == 0 || ptn.length() == 0) {
            return -1;
        }
        int j = 0, i = 0, n = txt.length(), m = ptn.length();
        int[] next = getNext(ptn);
//        while (i < n && j < m) {
//            if (j == -1 || txt.charAt(i) == ptn.charAt(j)) {
//                j++;
//                i++;
//            } else if (j == 0) {//j=0且字符不匹配时，i++比较下一位txt和j=0
//                i++;
//            } else {//j>0且不匹配时，ptn[0,j-1]的最长匹配前缀是ptn[0,next[j-1]]，继续比较txt[i]和ptn[next[j-1]+1]
//                j = next[j - 1] + 1;
//            }
//        }
        for (; i < n && j < m; i++) {//i不断向后
            while (j > 0 && txt.charAt(i) != ptn.charAt(j)) {
                j = next[j - 1] + 1;
            }
            if (txt.charAt(i) == ptn.charAt(j)) {
                j++;
            }
        }
        if (j == m) {
            return i - j;
        }
        return -1;
    }


    /**
     * 利用动态规划得到确定优先状态自动机
     * @param txt
     * @param ptn
     * @return
     */
    public int kmp3(String txt, String ptn) {
        if (txt == null || ptn == null || txt.length() == 0 || ptn.length() == 0) {
            return -1;
        }
        int i = 0, j = 0, n = txt.length(), m = ptn.length();
        int[][] dfa = getDfa(ptn);
        while (i < n && j < m) {
            j = dfa[j][txt.charAt(i++)];
        }
        if (j == m) {
            return i - j;
        }
        return -1;

    }

    /**
     * @param ptn
     * @return dfa[j][c]表示在ptn.charAt(j)=c时ptn[0,j]对应的最长匹配前缀长度是dfa[j][c]
     */
    private int[][] getDfa(String ptn) {
        int[][] dfa = new int[ptn.length()][256];
        //dp1：初始化初始状态
        dfa[0][ptn.charAt(0)] = 1;//其它dfa[0][c]默认是0
        int n = ptn.length();
        //从第一位开始匹配ptn[0,k]和ptn[0,j]
        for (int j = 1, k = 0; j < n; j++) {
            //dp2：状态回退，
            //上一次ptn[0,j-1]对应的最长匹配前缀长度是k，即ptn[0,j-1]对应的最长前缀是ptn[0,k-1]
            //(ptn[0,j-1],ptn[j]):(ptn[0,k-1],ptn[k])，状态j对应的上一状态是k，所以继承上一状态dfa[j][c]=dfa[k][c]
            //即ptn[j][c]对应的最长匹配前缀长度是ptn[k][c]
            for (int c = 0; c < 256; c++) {
                dfa[j][c] = dfa[k][c];
            }
            //dp3：状态前进，字符匹配ptn[j]时表示最长匹配前缀长度是j+1
            dfa[j][ptn.charAt(j)] = j + 1;
            //dp4：状态k传递给下一位，（等价于在循环开始获取之前状态）
            k = dfa[k][ptn.charAt(j)];
        }
        return dfa;
    }


}
