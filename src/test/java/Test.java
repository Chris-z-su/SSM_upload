import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        //申明变量
        HashMap<String, String> hashMap = new HashMap<>();

        File f=new File("E:\\Javademo\\SSM_upload\\src\\main\\webapp\\resource\\uploads");
        showName(f,1, hashMap);

        Set set     =     hashMap.entrySet();
        Iterator iterator     =     set.iterator();
        while     (iterator.hasNext())
        {
            Map.Entry     mapentry     =     (Map.Entry)     iterator.next();
            System.out.println(mapentry.getKey()     +     "/"     +     mapentry.getValue());
        }
    }




    public static void showName(File file,int level, HashMap<String, String> hashMap){//File file=f
        File[] listFiles = file.listFiles();

//        file.getName();
        hashMap.put("", file.getName() + "/" +
                "");

        for(File f:listFiles){
            for(int i=1;i<=level;i++){
                System.out.print("-  ");
            }

            if(f.isDirectory()){//是文件夹
                System.out.println(f.getName());
                hashMap.put(f.getName(), f.getName() + "/");
                showName(f,level+1, hashMap);
            }else{//是文件
                System.out.println(f.getName());
                hashMap.put(f.getName(), f.getName() + "/");
            }
        }
    }
}
