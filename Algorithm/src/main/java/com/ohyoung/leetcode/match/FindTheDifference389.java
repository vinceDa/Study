package com.ohyoung.leetcode.match;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 *
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * @author ohYoung
 * @date 2021/9/5 21:59
 */
public class FindTheDifference389 {

    public static void main(String[] args) {
        FindTheDifference389 example = new FindTheDifference389();
        String s = "abcd";
        String t = "abcdz";
        System.out.println(example.findTheDifference_3(s, t));
        s = "";
        t = "y";
        System.out.println(example.findTheDifference_3(s, t));
        s = "a";
        t = "aa";
        System.out.println(example.findTheDifference_3(s, t));
        s = "ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor";
        t = "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj";
        System.out.println(example.findTheDifference_3(s, t));
    }

    /**
     * 定义一个数组，以s的字符ascii值为key， 出现的次数为value
     *  用字符数组存储toCharArray()的值，执行速度快，内存消耗大
     */
    public char findTheDifference_1(String s, String t) {
        char[] origin = s.toCharArray();
        int[] array = new int[26];
        for (char value : origin) {
            array[value - 'a']++;
        }
        char[] target = t.toCharArray();
        for (char c : target) {
            if (array[c - 'a'] == 0) {
                return c;
            }
            array[c - 'a']--;
        }
        return ' ';
    }

    /**
     * 定义一个数组，以s的字符ascii值为key， 出现的次数为value
     * 和方案一思路一致，但是没有用字符数组存储char值，执行速度慢，内存消耗小
     */
    public char findTheDifference_2(String s, String t) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (array[c - 'a']-- == 0) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 定义一个数组，以s的字符ascii值为key， 出现的次数为value
     * 和方案一思路一致，但是没有用字符数组存储char值，执行速度慢，内存消耗小
     */
    public char findTheDifference_3(String s, String t) {
        int sum = 0;
        for (int i = 0; i < t.length(); i++) {
            sum += t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            sum -= s.charAt(i);
        }
        return (char) sum;
    }

}
