import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
/**
此处注明时间，作者
*/
public class Driver 
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("================================================================================================");
        System.out.println("0.退出");
        System.out.println("1.指定单词词频统计功能");
        System.out.println("2.显示前k个单词的词频及单词");
        System.out.println("3.统计该文本所有单词数量及词频数,将单词数和词频数按字典顺序写入到result.txt文件中");
        System.out.println("请选择功能选项,选择对应的数字选项即可进入对应的功能");
        System.out.println("================================================================================================");
        //输入文本路径
        String fileName = "src/HarryPotter.txt";	 
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        // 用来存储过滤后的单词列表
        ArrayList<String> lists = new ArrayList<String>();  
        String line = null;
        int count = 0;
        while ((line = br.readLine()) != null) 
        {
             // 过滤不含字母的
            String LineOfwords[] = line.split("[^a-zA-Z]"); 
            for (String word : LineOfwords)
            {
                if (word.length() != 0)
                { // 去除长度为0 的行
                    lists.add(word);
                }
            }
        }
        br.close();
        // 将单词与对应的单词个数存入TreeMap集合,因为TreeMap集合是以key(单词)进行排序(字典顺序),所以需要进行二次排序
        TreeMap<String, Integer> wordCount = new TreeMap<String, Integer>();  
        for (String word : lists) 
        {
            if (wordCount.get(word) != null) 
            {
                wordCount.put(word, wordCount.get(word) + 1);
                count++;
            } else 
            {
                wordCount.put(word, 1);
                count++;
            }
        }

        /** 排序*/
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() 
        {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) 
            {
                // 降序排
                return o2.getValue() - o1.getValue();  
            }
        });
        System.out.println("请输入数字0-3实现不同的功能:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Function function = new Function();
        while (true)
        {
            switch (num)
            {
                case 0:
                    function.exit();
                    break;
                case 1:
                    function.wordofnumber(list);
                    break;
                case 2:
                    function.beforeK(list);
                    break;
                case 3:
                    function.write(list,fileName);
                    break;

            }
        }
    }
}
