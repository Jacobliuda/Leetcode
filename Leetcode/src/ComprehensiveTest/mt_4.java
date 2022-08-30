package ComprehensiveTest;

import java.util.*;

/**
 * @author Jacob
 * @creator 2022/8/6-10:57
 * @description 小美非常热衷于数据竞赛，数据竞赛是当下非常流行的一种比赛形式，在这种比赛中往往会给出一个训练集和一个测试集，由于测试集是没有标注的，因此大家为了线下评测模型的性能，通常会将训练集拆分成两个部分，即自建的训练集和测试集。
 *
 *         现在给出某比赛的一个训练集，小美需要按照如下规则将其拆分为训练集和测试集。
 *
 *         已知该训练集包含n个样本，每个样本有一个样本编号和一个类别编号。假设某一类别的样本共有m个，则将编号最小的m/2(向上取整)个样本作为训练集，将其他样本作为测试集。
 *
 * 样例输入
 * 10 3
 * 3 2 2 1 2 3 1 3 3 3
 * 样例输出
 * 1 2 3 4 6 8
 * 5 7 9 10
 */
public class mt_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sampleNum = sc.nextInt();
        int classNum = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < sampleNum; i++){

            int cls = sc.nextInt();

            // 如果 map 中不存在该类别的记录，则创建一个该数组
            if(!map.containsKey(cls))
                map.put(cls, new ArrayList<Integer>());

            // 然后将当前样本的id存进数组
            map.get(cls).add(i+1);

        }

        //定义两个数组用于存储训练集和验证集的样本编号
        ArrayList<Integer> trainSet = new ArrayList<>();
        ArrayList<Integer> validateSet = new ArrayList<>();

        Set<Integer> keySet = map.keySet();

        for(int key: keySet){

            ArrayList<Integer> list = map.get(key);
            int i = 0;
            while(i <= (list.size() + 1)/2 - 1){
                trainSet.add(list.get(i));
                i++;
            }
            while(i < list.size()){
                validateSet.add(list.get(i));
                i++;
            }

        }

        Collections.sort(trainSet);
        Collections.sort(validateSet);

        for (int idx : trainSet) {
            System.out.print(idx);
            System.out.print(" ");
        }

        System.out.println();

        for (int idx : validateSet) {
            System.out.print(idx);
            System.out.print(" ");
        }

    }
}
