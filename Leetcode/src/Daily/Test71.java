package Daily;

import java.util.ArrayList;
import java.util.List;

/**71.简化路径
 *
 * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 *
 * @author Jacob
 * @creator 2022/1/6-19:36
 */
public class Test71 {
    public static String simplifyPath(String path) {
        ArrayList<String> strings = new ArrayList<>();
        String[] pathSplit = path.split("/");
        for(int i = 0; i < pathSplit.length; i++){
            String s = pathSplit[i];
            if("..".equals(s)){
                if(!strings.isEmpty())
                    strings.remove(strings.size()-1);
            }
            else if(".".equals(s) || "".equals(s))
                continue;
            else
                strings.add(s);
        }
        StringBuilder sb = new StringBuilder();
        if(strings.isEmpty())
            return "/";
        for(int i = 0; i < strings.size(); i++){
            sb.append("/").append(strings.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        String ans = simplifyPath(path);
        System.out.println(ans);



    }
}
