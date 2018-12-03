/**
 * 描述：普通数组
 * create by Liw
 * create on 2018/12/3 0003
 **/
public class GenericArray<T> {
    private T[] data;
    private int size ;
    private int currentIndex = -1 ;
    private int signSize = 0 ;

    /**
     * 初始化数组
     * @param capacity
     */
    public GenericArray(int capacity){
        data = (T[]) new Object[capacity] ;
        size = capacity ;
    }

    /**
     * 默认初始化数组
     */
    public GenericArray(){
        this(16);
    }

    /**
     * 获取初始化容量大小
     * @return
     */
    public int getCapacity(){
        return this.size ;
    }

    /**
     * 获取当前数组下标
     * @return
     */
    public int getCurrentIndex(){
        return this.currentIndex ;
    }

    /**
     * 当前数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return currentIndex >= 0 ;
    }


    /**
     * 打印数组中的元素
     */
    private void show(){
        for (T t : data){
            System.out.println(t +" ");
        }
    }

    /**
     * 顺序新增元素
     * @param t
     * @return
     */
    private boolean add(T t){
        if(size == 0 || (currentIndex+1) >= size){
            System.out.println("容量受限！！！");
            return false ;
        }
        data[++currentIndex] = t ;
        return true ;
    }

    private void checkIndex(int index){
        if(index<0 || index >= size){
            throw new IllegalArgumentException("hand failed! Require index >=0 and index < size.");
        }
    }

    /**
     * 获取下标为index的数据
     * @param index
     * @return
     */
    public T get(int index){
        checkIndex(index);
        return data[index] ;
    }

    /**
     * 修改下标为index的数据为t
     * @param index
     * @param t
     */
    public void set(int index,T t){
        checkIndex(index);
        data[index] = t ;
    }

    /**
     * 判断元素是否在数组data中
     * @param t
     * @return
     */
    public boolean contains(T t){
        if(t == null){
            throw new NullPointerException("空指针异常");
        }
        for (T tt : data){
            if(t.equals(tt)){
                return true ;
            }
        }
        return false ;
    }

    /**
     * 获取指定对象的下标
     * @param t
     * @return
     */
    public int find(T t){
        for (int i=0;i<=currentIndex;i++){
            if (data[i].equals(t)){
                return i ;
            }
        }
        return -1 ;
    }

    public void addToHead(T t){
        if(currentIndex+2>=size){
           throw new IllegalArgumentException("存储空间不足");
        }
        for (int i=currentIndex;i>0;i--){
            data[i+1] = data[i] ;
        }
        data[0] = t ;
    }

    /**
     * 向数组指定位置index中增加数据t
     * @param index
     * @param t
     */
    public void add(int index,T t){
        checkIndex(index);
        if(size == currentIndex+1){
            resize(size*2);
        }
        for (int i=currentIndex;i>=index;i--){
            data[i+1] = data[i] ;
        }
        data[index] = t ;
        currentIndex++ ;
    }

    /**
     * 将元素增加到数组头部
     * @param t
     */
    public void addFirst(T t){
        add(0,t);
    }

    /**
     * 将元素增加到数组尾部
     * @param t
     */
    public void addLast(T t){
        add(currentIndex,t);
    }

    /**
     * 移除指定index的数据t
     * @param index
     * @return T
     */
    public T remove(int index){
        checkIndex(index);
        T rd = data[index];
        data[index] = null ;
        signSize++ ;
        if(signSize >= size/3){
            clearUpSignData(size-size/3);
        }
        return rd ;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 移除最后一个元素
     * @return
     */
    public T removeLast(){
        return remove(currentIndex) ;
    }


    /**
     * 删除指定元素
     * @param t
     * @return
     */
    public int removeElement(T t){
        int index =find(t) ;
        if(index != -1){
            remove(index);
        }
        return index ;
    }

    public void clearUpSignData(int capacity){
        T[] newData = (T[]) new Object[capacity];
        int newCurrentIndex = -1 ;
        for (int i=0;i<=currentIndex;i++){
            if(data[i] != null){
                newData[++newCurrentIndex] = data[i] ;
            }
        }
        data = newData ;
        currentIndex = newCurrentIndex ;
    }



    /**
     * 数组扩容
     * @param capacity
     */
    private void resize(int capacity){
        if(capacity <= size){
            throw new IllegalArgumentException("the capacity need >= size");
        }
        T[] newData = (T[])new Object[size] ;
        this.size = capacity ;
        for (int i=0;i<=currentIndex;i++){
            newData[i] = data[i] ;
        }
        data = newData ;
    }


    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Array currentIndex %s,capacity %s,",this.currentIndex,this.size));
        sb.append("[");
        for (int i=0;i<=currentIndex;i++){
            sb.append(data[i]);
            if(i != currentIndex){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString() ;
    }

    public static void main(String args[]){
        GenericArray<User> userGenericArray = new GenericArray<>(10);
        for (int i=0;i<60;i++){
            User user = new User("liw"+i,"跑步");
            userGenericArray.add(user);
        }
        userGenericArray.show();
        System.out.println(userGenericArray);
        System.out.println("hello world !!!");
    }

    public static class User {
        private String name;
        private String hobby;

        public User(String name, String hobby) {
            this.name = name;
            this.hobby = hobby;
        }

        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public String toString() {
            return "name=" + name + "&hobby=" + hobby;

        }
    }
}
