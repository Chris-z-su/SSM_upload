import java.io.File;
import java.util.HashMap;

public class Test02 {
    public static void main(String[] args) {

        //申明变量
        HashMap<String, FileDateInfo> hashMap = new HashMap<>();

        File f=new File("E:\\Javademo\\SSM_upload\\src\\main\\webapp\\resource\\uploads");

        //递归遍历
        showName(f,1, hashMap, null);

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(1);
    }

    public static void showName(File file,int level, HashMap<String, FileDateInfo> hashMap, FileDateInfo fileDateInfo) {
        File[] listFiles = file.listFiles();

        if (fileDateInfo == null){
            fileDateInfo = new FileDateInfo();
        }
//        hashMap.put("", file.getName() + "/");
        for(File f:listFiles){
            for(int i=1;i<=level;i++){
                System.out.print("-  ");
            }

            if(f.isDirectory()){//是文件夹
                System.out.println(f.getName());
                switch (level){
                    case 1:
                        fileDateInfo.setYear(f.getName());
                    case 2:
                        fileDateInfo.setMonth(f.getName());
                    case 3:
                        fileDateInfo.setDay(f.getName());
                }
                hashMap.put(f.getName(), fileDateInfo);
                showName(f,level+1, hashMap, fileDateInfo);
            }else{//是文件
                System.out.println(f.getName());
                fileDateInfo.setFileName(f.getName());
                hashMap.put(f.getName(), fileDateInfo);
            }
        }

    }

}
