package com.ohyoung.leetcode.binarysearch.interview;

import java.util.Arrays;

/**
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 * 示例2:
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 *
 * 提示:
 * words的长度在[1, 1000000]之间
 *
 * 链接：<a href="https://leetcode.cn/problems/sparse-array-search-lcci">...</a>
 * @author ouyb01
 * @date 2022/6/14 9:26
 */
public class FindString {

    public static void main(String[] args) {
        FindString example = new FindString();
        String[] words = new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        System.out.println(example.findString(words, "ta"));
        System.out.println(example.findString(words, "ball"));
        words = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", " RNULzGvcYU", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", " bmpfzt", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", " hGujCgxev", "", " pejYYJxUfEVifoR", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", " qX", "", "", "", "", "", "", "", "", "", "AIk", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "AyzOJn", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "BIPyyqVFkDKKz", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "BKqlstTHCLigZ", "", "", "", "", "", "", "", "", "", "", "BXS", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "BfmeOuEqZVWuCdBo", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "BjyECYICFPFcuXFm", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CBFNSToPqM ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CEIVOuYKPL", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CTMPyqNwbOTu ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CVqdidbK", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CadMyD", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CajJNWYqoBrJDWN", "", "", "", "", "", "", "", "", "", "", "", "", "", "Cb", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "CjbIDinqjJdzZTG", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "DSKGDCUILFwiKW", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "DSRgVCrtxuLIgkztoCy", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "DgAWasFy", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "DmXAhsWMjrPc", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "DmfMMkwwiHZvZxf", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "DteOgJgtKbBH", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "EDIDeA dQBvYLJL", "", "", "EIgzXuZQzSwbrQUvufs", "", "", "", "", "", "", "", "ESloLZUTLSQJiGtkT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "EXRjgvJIGuLQt", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "EXUiA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "EYdibRQYIyKpEl", "", "", "", "", "", "", "", "", "Ej qJ uEBdn", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "EpJJIAvnQsIeE", "", "", "", "", "", "", "", "", "", "", "EqlXtArzSFov", "EwtDTR", "", "", "", "", "", "", "", "", "", "", "", "FMvuVz invDrOUilUE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Fsq", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "GIyeJiSasfikCedh", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "GZtDYZYPo", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "GaEjzsHuVrdUDOnvMSur", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "GqwqEnUx", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "GzKXzl", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "HAaYVxd", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "HIA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "HJgfDdjvnQb", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "HXzWjkUrrQKwE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "HYF tIXKDGwauv", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "HuPClDZfo", "", "", "", "", "", "", "", "INIylO VpkkqwbjNYMoN", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "IVHVdurgDVYYQywRvu", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "IXL c", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "IbqWfSMnCOyxvrF", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "IfrN WkiSx", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "IpqHUTPhkfuyFYtb", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ItANL iI", "", "", "", "", "", "", "", "", "", "", "IundSPlwJLqbFeHRKMs", "", "", "", "", "", "", "", "", "", "", "", "JA", "", "", "", "", "", "", "JAlCa", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "JJZUPSIkbvAwBCk", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "JMVtjsIduUSBvxaVv", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "JPftCsxuoI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "JQgOcKolyGH", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "JVKetTY", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Jkc GHJyGrZDVjk", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "JuESC", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "JxHZpIOineSM KU", "", "", "", "", "", "", "", "", "KAZkNFfnhEaLu", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "KBFAbQRarrJX", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "KFNAQqwSWtvrNehI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Kf", "", "KjbhjmDoYhmXtChUY", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "KqyyoVA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "KtVIa", "", "", "", "", "", "", "", "", "", "LAUIiPZeWBhbcANkc", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "LeJhmwIQjtOrTMfGopo", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "MLRRpXAShBMsIbXTHLhv", "", "", "", "", "", "", "", "", "", "MNLKuVxe YDsq", "MaoLSeEczGrHfbLtzuIR", "", "", "", "", "", "", "", "", "", "", "", "", "", "MiaLjFICoIJWiiJf", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "MlHwEI", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "MpMKkLluKyZ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "MuWj", "", "", "", "", "MwyuB", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "MzcZeNjMtmj", "", "", "", "", "", "", "", "", "", "", "", "", "NPeFGrYjEoWhssseWd", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "NSV", "", "", "", "", "", "", "", "", "NdPjGjIW", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "NgISKRzEjlyGooKfhnIF", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "NqcGYunSITaxG", "", "", "", "", "", "", "", "", "", "", "", "", "NyXWGul yuWF", "", "", "", "", "", "", "OILIHaACfXkzVTtE Ytb", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OIUZUpZtqB", "", "OQZzIgcW", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "OUZBobCOO", "", "", "", "", "", "ObhjhUAIOY", "", "", "", "", "", "", "", "", "OqukEmRQZuqABz kGb", "", "", "", "", "", "", "", "", "", "", "", "P", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PJvuT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PTlVgS", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PUji", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "PaGzUfPwMSgS", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Po zcb", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Psrykhm AYazcA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Q bILmVNLcOAy ymPALq", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "QGnFpxKdX", "", "", "", "", "", "", "", "", "", "", "", "QRbIOGDPaBYV", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "QcsvQQENUV", "", "", "", "", "", "", "", "", "", "", "", "QgCJWrYNlRbTTdgLGCv", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Qur", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "RDFkNnMAjXop", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "RFPxyvYIbkJbWTYnM", "", "", "", "", "", "", "", "RR", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "RehvNFnH", "", "", "", "", "", "", "", "RgJxCObDQF", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "RqVR", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "RqigMxAOUAjlRI S", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "S", "", "", "", "", "SFHtBtZsMffqHHeMQOh", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "SJPlC vli", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "SMiGYgrPe", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "SQFCD", "", "", "", "", "", "", "", "", "", "", "", "", "SdWrMtjuEHOqFBPNjEQ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "SjpIboJnytQMjworOPA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "TFqzUO", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "THmj", "", "", "", "", "", "TTkUMw", "", "", "", "", "", "", "", "", "", "", "TjsjRaeuQgCpgbITVgeh", "", "", "", "", "", "", "", "", "", "TleNaSFjiEZQta", "", "", "", "", "", "", "", "", "", "", "", "", "", "TpoPD", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Tt", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "U", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "UCuMoOdwUNZbdCWL", "", "", "", "", "", "", "", "", "", "UERL", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "UGgDtzjxNPmx ouOXOmk", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "UdP", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "UlYzFtUNw", "", "", "", "", "", "", "UtHFNnAcmHFAMeN", "", "", "", "", "", "", "", "", "", "", "", "", "", "Uy", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "VBKepdLvfiqPoydovQf", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "VHFBFG", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "VdXDHxM", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "VfQPBIeBRN", "", "", "", "", "VgK", "", "", "", "", "", "", "", "", "", "", "VnwsDEdkkCsGiz", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "VtJUOhPOJeJKeDn", "", "VuXzItJ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "WCgjLBoythINS", "", "", "", "", "", "", "", "", "WMgU", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Wl", "", "", "", "", "", "", "", "WpNMDesxBThLZAuQIS", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "WvxtMhbeizAxKTrHglfN", "", "", "", "", "", "", "", "", "", "", "", "", "", "X", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "XJyCmeshpCfscGjYM xu", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "XMz", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "XUG", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Xdxn", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "XfztdIOJv ", "", "", "", "", "", "", "Y", "", "", "", "", "", "", "", "", "", "", "", "YUpKxdlz", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "YXLNyDXT", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "YatmpUiIbYCITZD", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Z", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZAIVE", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZBTVbKwMGDmCuzA GtF", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZFybeWiSe", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZIXzRoXrdBMC", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZUnOH brabhPJzs", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZWXQLWjDArbeCVYG", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZZImJIgxCIsxl", "", "", "", "", "", "", "", "", "", "", "", "", "ZaTy", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZadwVhCPiFgLAmVyQS", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "ZjrLMLC UJ", "", "", "a", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "aKnXbIAkFOc", "", "", "", "", "", "", "", "", "", "", "", "", "", "aMevkkssaTdXyMKxwfH", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "aRHXNQCLCOomEXyL", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "aTNmEx", "", "", "", "", "", "", "", "", "ajOEiDBvNjkaewcNFaB", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "asJPXnDSgk", "", "", "", "", "", "", "", "", "asTUUDd", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "b ltKLIhG", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "bLBjTtX", "", "", "", "", "", "", "", "", "", "bZLUq", "bm", "bprERTtbtBxeJY", "btW QXKKuDRdfwacH", "byeDBqzrwwihtpyJLr", "c", "cDlchjPbAlBwK", "ccQRlofTuzQAR", "chwufgicLdmrp", "cigTagSHwI", "cyCqXYGeYFwttD", "dQVDYPUpKdvC", "dUoRSZvyPzs", "dX h", "datEODhOJMj", "datSLVRtOBAH", "dccVHxWXTSXvWgYH", "dhlFerxcCIfTdIJvc", "e", "eJxGHxm ju", "ePnilLeyhjDXxR v", "eRLHisIYItKevDUMhrD", "eWhdAi", "eZbPaxaDcqqyH", "eiD", "epPDjePRoMImUz", "fShrZpLPojsyPqfhG", "fnMMhOKjSdfHEZzWjWG", "g", "gBktwBVpnOaQA", "gKVUzpsijyw", "gRFVIvJur", "giUtnbqEDAlCsrVI", "giusGW XcdaSHNQZRNC", "gkWPxTOLOkjaLdFPQ", "gnpDlXuSRoWNDTz", "grUtEJpec bRA", "hCNxr", "hMyfRB", "hOpWQsCSH", "hPFjRehtmjFqKyo", "hRbAuMgrAHWrEroMG", "iDByxllvRxYVL", "icwm", "igeaWRWfxiH", "jFLZaznK", "jP bNYmgwifoUuo", "jRqpLDFqVLSdmw", "jdIkHl", "jetOngoScRIRqxgEp", "kAEtCLwhuB", "kPmPiMUA", "kqa", "kxBhZYYeMs", "kzMgj", "lMO", "lOzgoiWc", "lVrxjCYn", "lVvowOvXLAhFoaI", "lllOqdrpZRM", "lnKM", "lolhWLkqzNOJw", "lsv", "m", "mJHeJU", "mSfcWyrwu", "maNfZWpqVunbQ", "mjlwlvuUm", "mvCmjnqmYA", "n", "n vyFfRgtAA", "nIsaEwBGrllbkiuG", "njseVhwrvI", "nqtQ", "o", "oF ", "oNzTsidkkH RDkVOEEPY", "oU", "oaXDvCwGykTWRj", "oeWknZQzvt", "ohXjeeVcfYFNPdNtfhp", "ooXZldbxYhzY", "opmRUhJ", "opzKKZkGTBIrjwJN", "osBO lFg FboWdVJMf", "osBQzlYJ", "oulKzieNUGr", "pImiBGxtGSY jM", "pKDxn L", "pLLwrti", "pPE", "pSXZNOykPMfFFMKgm", "qQeGlbKAg", "quVoregJjo", "qzPgrVkthPUUNSLiCri", "rAthov", "rCjmzZRzXQ", "rZmZr", "reRWN gNrTGSMvNWA", "ribXkqdnWbPx", "rjmNmKXsBkOf", "rpefYfAAwXEmReIyl", "rsPYQunnJnzzxDYiZmy", "rtoiPx", "sAxbRPkbZIPCNAhJ", "sBTfyCSbEp", "sXVtLSjIWn", "sYHAKRSSAg", "sfKCjv", "smvTv", "spHuYPWVdtZyVjEi", "stKKcVOpFBRLQDRa", "sxXB", "tQDpqzZFTi", "tWyzAHwmyjDfMJynuZK", "trUHSuAJX gSLb", "trnHkkryo", "tsVlBRCYmRcYWbWsoUF", "uGyMVqYxfaiMkVbxK", "uLlbtsMyItAq", "uuTttBDz", "uxNnekHiPqEShOkfweL", "v", "v", "v", "vhvDyCLfIPpksVDcH ", "vjSEaXsO", "vv", "wDAR", "wGIpTCF sz", "wLFakeKwLHLlc", "wNYpbWgCBXhDVFZHU", "wYWQC", "wZTBrM", "wtDZ", "wuChFtQhOYIA", "wvPulwdkw", "wwLS", "x", "xKJkcZMZgQCNwZZVU", "xefna", "xgMQgGiQZIm", "y", "yTOMnR FUFOxjNSsZWuQ", "ydBsBMclL fv", "ygPeMkXniyt", "ygYwCVxPjJm", "ykzExMerucj", "ypDMfKfTsTJNJxzMmr", "zBhQv QyxFxblA", "zM", "zPWzUGLa", "zPejWpjrytg", "zi", "zleuWBpa", "zmQAzwMdTZG", "zxD qnecSc", "zzVaQcWSKHtywxOyVj"};
        System.out.println(example.findString(words, "PT"));
    }

    public int findString(String[] words, String s) {
        int low = 0;
        int high = words.length - 1;
        while (low <= high) {
            if (words[low].equals(s)) {
                return low;
            }
            int mid = low + (high - low) / 2;
            // 如果遇到空格且开始下标不是目标值, 则逐步缩小检查范围, 以此来绕过空格
            if (words[mid].isEmpty()) {
                low++;
                continue;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 去空格解法不得行
     */
    public int findStringByDeleteBlank(String[] words, String s) {
        String[] notEmptyWords = new String[words.length];
        int index = 0;
        // 去掉空字符串数组
        for (String word : words) {
            if (!word.isEmpty()) {
                notEmptyWords[index++] = word;
            }
        }
        notEmptyWords = Arrays.copyOfRange(notEmptyWords, 0 , index);
        int low = 0;
        int high = notEmptyWords.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (notEmptyWords[mid].equals(s)) {
                for (int i = 0; i < words.length; i++) {
                    if (notEmptyWords[mid].equals(words[i])) {
                        return i;
                    }
                }
            } else if (notEmptyWords[mid].compareTo(s) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}