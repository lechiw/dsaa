/**
 * @Description: (用一句话描述该文件做什么)
 * @author: Liw
 * @date: 2018/12/2 10:44
 * <p>
 */
public class Array {
    private int[] data  ;
    private int totalCount  ;
    private int currentCount ;
    private int signCount = 0 ;

    private Array(int capacity){
        data = new int[capacity] ;
        totalCount = capacity ;
        currentCount = 0 ;
    }

    /**
     * 将新的value插入到index位置，并将index位置的数据落到数组的最后一个位置
     * @param index
     * @param value
     * @return
     */
    private boolean insert(int index,int value){
        if(index<0 || index >= totalCount){
            System.out.println("输入下标不合法");
            return false ;
        }

        if(currentCount+1 >= totalCount){
            System.out.println("空间已满，无法插入");
            return false ;
        }

        int currentDate = data[index] ;
        data[index] = value ;
        if(currentDate == 0){
            currentDate ++ ;
            return true ;
        }
        data[currentCount++] = currentDate ;
        return true ;

    }

    /**
     * 顺序插入
     * @param value
     * @return
     */
    private boolean add(int value){
        if(totalCount == currentCount){
            System.out.println("内存空间已满");
            return false ;
        }
        data[currentCount++] = value ;
        return true ;
    }


    /**
     * 删除元素
     * @param index
     * @return
     */
    private boolean delete(int index){
        if(index > totalCount-1){
            System.out.println("数组越界");
            return false ;
        }
        for (int i=index+1;i<data.length;i++){
            data[i-1] = data[i] ;
        }
        return true ;
    }

    private void show(){
        for (int i=0;i<data.length;i++){
            System.out.print(data[i] +" ");
        }
        System.out.println();
    }

    /**
     * 标记删除
     * @param index
     * @return
     */
    private boolean signDelete(int index){
        if(index+1 >totalCount){
            System.out.println("数组越界，删除失败");
            return false ;
        }

        data[index] = -1 ;
        signCount++ ;
        if(signCount >= totalCount/2){
            cleanUp();
        }
        return true ;
    }

    /**
     * 整理数组
     */
    private void cleanUp(){
        int index = 0 ;
        int[] newArray = new int[totalCount];
        for (int i=0;i<data.length;i++){
            if(data[i] != -1){
                newArray[index++] = data[i] ;
            }
        }
        data = newArray ;
        currentCount = index ;
        signCount = 0 ;
    }



    public static void main(String args[]){
        Array array = new Array(10);
        array.add(1);
        array.add(14);
        array.add(31);
        array.add(12);
        array.insert(3,100);
        array.add(1123);
        array.add(12);
        array.add(15);
        array.show();

        array.insert(1,100);
        array.show();

        array.signDelete(5);
        array.signDelete(1);
        array.signDelete(2);
        array.signDelete(3);
        array.signDelete(3);
        array.signDelete(3);
        array.signDelete(5);
        array.show();
        array.cleanUp();
        array.show();
    }
}
