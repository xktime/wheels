package LeetCode;

/**
 * 748.
 * 如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 */
public class ShortestCompletingWord {
    public static void main(String[] args) {
        String[] s = {"ten", "two", "better", "talk", "suddenly", "stand", "protect", "collection", "about", "southern"};
        System.out.print(new ShortestCompletingWord().
                shortestCompletingWord("TE73696", s));
    }

    /**
     *  额.....输入都为完整词....没注意审题
     *  下面实现是兼容不完整词的，输出出现较多的字符，如果字符相等输出先出现的......
     */
    private String shortestCompletingWord(String licensePlate, String[] words) {
        char[] license = new char[7];
        int index = 0;
        //找出licensePlate的字母
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                license[index++] = c;
            }
        }
        //把下标words[i]出现的次数放入ints[i]
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            for (char c : license) {
                if (c == 0) {
                    break;
                }
                for (int j = 0; j < word.length; j++) {
                    if (c == word[j]) {
                        word[j] = 0;
                        ints[i]++;
                        break;
                    }
                }
            }
        }
        int maxIndex = 0;
        int maxTimes = Integer.MIN_VALUE;
        //找出出现次数最多的下标，如果次数相等判断长度
        for (int i = 0; i < ints.length; i++) {
            if (maxTimes < ints[i]) {
                maxIndex = i;
                maxTimes = ints[i];
            } else if (maxTimes == ints[i]) {
                maxIndex = words[maxIndex].length() <= words[i].length() ? maxIndex : i;
            }
        }
        return words[maxIndex];
    }
}
