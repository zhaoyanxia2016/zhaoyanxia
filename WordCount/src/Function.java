
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class Function implements Functions {
    public void exit() {
        System.out.println("���ϵͳ�Ѿ��˳�!");
        System.exit(0);
    }

    public void wordofnumber(ArrayList<Map.Entry<String, Integer>> list) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("�����ʵ������Լ���״ͼ����(һ��������ÿ�����ʳ���400��,ע:�����в����ڵĵ��ʲ������)");
        System.out.println("��������Ҫ��ѯ�ĵ����ö��Ÿ���");
        String wordss = sc1.nextLine();
        String words[] = wordss.split(",");
        for (String word : words) {
            for (Map.Entry<String, Integer> entry : list) {

                if (word.equals(entry.getKey())) {

//							System.out.println(word + ": " + entry.getValue());
                    int number = entry.getValue();
                    System.out.print(entry.getKey()+"	numbers "+entry.getValue()+":  ");
                    for (int i = 0; i < number / 400; i++) {
                        System.out.print("��");
                    }
                    System.out.println();
                    System.out.println();
                    // sc1.close();
                    break;
                }
                /*
                 * else{ System.out.println("������"); break; }
                 */
            }
        }
    }

    public void beforeK(ArrayList<Map.Entry<String, Integer>> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ��ǰ��������(k):");
        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i));
        }
    }

    public void write(ArrayList<Map.Entry<String, Integer>> list,String fileName) {
        int count = 0 ;
        FileWriter fw = null;
        try {
            fw = new FileWriter("result.txt");
        } catch (IOException e) {
            System.out.println("��ܰ��ʾ:��Ҫ��ӡ���ļ�·���Ѿ�����");
        }
        BufferedWriter bw = new BufferedWriter(fw);

        for (Map.Entry<String, Integer> entry : list) {
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
            bw.write("���ʵ�������:" + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("�ɹ�д���ļ�,�밴�մ洢���ļ�·���鿴!!!" + "�ļ�·����:" + fileName);
        System.exit(0);
    }
}
