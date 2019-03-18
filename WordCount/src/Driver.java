
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws Exception {
        System.out.println("================================================================================================");
        System.out.println("0.�˳�");
        System.out.println("1.ָ�����ʴ�Ƶͳ�ƹ���");
        System.out.println("2.��ʾǰk�����ʵĴ�Ƶ������");
        System.out.println("3.ͳ�Ƹ��ı����е�����������Ƶ��,���������ʹ�Ƶ�����ֵ�˳��д�뵽result.txt�ļ���");
        System.out.println("��ѡ����ѡ��,ѡ���Ӧ������ѡ��ɽ����Ӧ�Ĺ���");
        System.out.println("================================================================================================");
        String fileName = "src/HarryPotter.txt";	//�����ı�·��
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lists = new ArrayList<String>(); // �����洢���˺�ĵ����б�
        String line = null;
        int count = 0;
        while ((line = br.readLine()) != null) {
            String LineOfwords[] = line.split("[^a-zA-Z]"); // ���˲�����ĸ��
            for (String word : LineOfwords) {
                if (word.length() != 0) { // ȥ������Ϊ0 ����
                    lists.add(word);
                }
            }
        }
        br.close();
        TreeMap<String, Integer> wordCount = new TreeMap<String, Integer>(); // ���������Ӧ�ĵ��ʸ�������TreeMap����,��ΪTreeMap��������key(����)��������(�ֵ�˳��),������Ҫ���ж�������
        for (String word : lists) {
            if (wordCount.get(word) != null) {
                wordCount.put(word, wordCount.get(word) + 1);
                count++;
            } else {
                wordCount.put(word, 1);
                count++;
            }
        }

        // ����
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue(); // ������
            }
        });
        System.out.println("����������0-3ʵ�ֲ�ͬ�Ĺ���:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Function function = new Function();
    while (true){
        switch (num){
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
