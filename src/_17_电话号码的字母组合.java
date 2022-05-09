import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class _17_电话号码的字母组合 {
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    private char[] chars;//字符数组
    private char[] string; //每一个解
    private List<String> list; //最终答案

//    public List<String> letterCombinations(String digits) {
//        if (digits == null) return null;
//        list = new ArrayList<>();
//        chars = digits.toCharArray(); //字符数组
//        if (chars.length == 0) return list;
//        string = new char[chars.length];
//        dfs(0);
//        return list;
//    }
//
//    /**
//     * @param idx 正在搜索第idx层
//     */
//    private void dfs(int idx) {
//        //最后一层是idx == chars.length -1 ；
//    	//idx == chars.length表示找到了一个解
//        if (idx == chars.length) {
//            // 得到了一个正确的解
//            list.add(new String(string));
//            return;
//        }
//
//        // 先枚举这一层可以做的所有选择
//        char[] letters = lettersArray[chars[idx] - '2'];
//        for (char letter : letters) {
//            string[idx] = letter; //选中一个，进入下一层
//            dfs(idx + 1);
//        }
//    }

    public List<String> letterCombinations(String digits) {
    	if (digits == null) return null;
    	if (digits.length() == 0) return new ArrayList<String>();
    	
    	list = new ArrayList<>();
    	chars = digits.toCharArray();
    	string = new char[chars.length];
    	
    	dfs(0);
    	
    	return list;
    }
    
    private void dfs(int index) {
		if (index == chars.length) { //走到头了，返回一个答案
			list.add(new String(string));
			return;
		}
		
		char[] letters = lettersArray[chars[index] - '2']; //每一层的可选字数组
		for (int i = 0; i < letters.length; i++) {
			string[index] = letters[i];//获取一个的字符
			dfs(index + 1); //进入下一层
		}
	}
}

















