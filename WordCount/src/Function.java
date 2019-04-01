
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
/**作者，时间*/
 
class Function implements Functions
{
    /**提示系统推出*/
    public void exit() 
    {
        System.out.println("你的系统已经退出!");
        System.exit(0);
    }
    /**显示查询单词词频和柱状图*/
    public void wordoFnumber(ArrayList<Map.Entry<String, Integer>> list) 
    {
        System.out.println("各单词的数量以及柱状图如下(一个█代表每个单词出现400次,注:文章中不存在的单词不会出现)");
        System.out.println("请输入你要查询的单词用逗号隔开");
        String word= sc1.nextLine();
        String words[] = word.split(",");
        for (String word : words) 
        {
            for (Map.Entry<String, Integer> entry : list)
            {

                if (word.equals(entry.getKey())) {
                    int number = entry.getValue();
                    System.out.print(entry.getKey()+"	numbers "+entry.getValue()+":  ");
                    for (int i = 0; i < number / 400; i++) {
                        System.out.print("█");
                    }
                    System.out.println();
                    System.out.println();
                    break;
                }
            }
        }
    }
    /**显示查询单词词频和柱状图*/
    public void beForeK(ArrayList<Map.Entry<String, Integer>> list)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查前几个单词(k):");
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) 
        {
            System.out.println(list.get(i));
        }
    }
     /**单词词频写入文件*/
    public void write(ArrayList<Map.Entry<String, Integer>> list,String fileName) 
    {
        int count = 0 ;
        FileWriter fw = null;
        try {
            fw = new FileWriter("result.txt");
        } catch (IOException e) {
            System.out.println("温馨提示:你要打印的文件路径已经存在");
        }
        BufferedWriter bw = new BufferedWriter(fw);

        for (Map.Entry<String, Integer> entry : list) 
        {
            try {
                bw.write(entry.getKey() + ":" + entry.getValue() + "	");
            } catch (IOException e) {


            }
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bw.write("单词的总数是:" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("成功写入文件,请按照存储的文件路径查看!!!" + "文件路径是:" + fileName);
        System.exit(0);
    }
}
