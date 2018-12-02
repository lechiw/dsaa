/**
 * @Description:邻接矩阵实现图
 * 邻接矩阵的底层依赖一个二维数组。对于无向图来说，如果顶点 i 与顶点 j 之间有边，我们就将 A[i][j] 和
 * A[j][i] 标记为 1；对于有向图来说，如果顶点 i 到顶点 j 之间，有一条箭头从顶点 i 指向顶点 j 的边，那
 * 我们就将 A[i][j] 标记为 1。同理，如果有一条箭头从顶点 j 指向顶点 i 的边，我们就将 A[j][i] 标记为 1。
 * 对于带权图，数组中就存储相应的权重。
 * @author: Liw
 * @date: 2018/12/2 15:19
 * <p>
 */
public class AdjacencyMatrix {
    private int[][] friendRelation = null ;
    private String[] friendList = null ;
    private int index = 0 ;
    private void init(int sum){
        friendRelation = new int[sum][sum] ;
        friendList = new String[sum] ;
        System.out.println("数据初始化成功");
    }

    /**
     * 新增用户
     * @param name
     * @return
     */
    private boolean addUser(String name){
        if(index >= friendList.length){
            return false ;
        }
        if(getIndexByName(name) != -1){
            return false ;
        }
        friendList[index] = name ;
        index++ ;
        return true ;
    }

    /**
     * 通过用户名称查找其在数组中的位置
     * @param name
     * @return
     */
    private int getIndexByName(String name){
        if(name == null ){
            return -1 ;
        }
        for(int i=0;i<friendList.length;i++){
            if(name.equals(friendList[i])){
                return i ;
            }
        }
        return -1 ;
    }

    /**
     * user添加朋友friend
     * @param user
     * @param friend
     * @return
     */
    private boolean addFriend(String user,String friend){
        int userIndex = getIndexByName(user) ;
        if(userIndex == -1 ){
            return false ;
        }

        int friendIndex = getIndexByName(friend) ;
        if(friendIndex == -1){
            return false ;
        }

        friendRelation[userIndex][friendIndex] = 1 ;
        friendRelation[friendIndex][userIndex] = 0 ;
        return true ;
    }

    private void show(){
        System.out.println("用户列表：");
        for(int i=0;i<friendList.length;i++){
            if(friendList[i] == null){
                continue;
            }
            System.out.println(friendList[i] +" ");
        }

        System.out.println("朋友列表: ");
        for(int i=0;i<friendRelation.length;i++){
            if(friendList[i] == null || "".equals(friendList[i])){
                continue;
            }
            System.out.print(friendList[i]+"的朋友");
            for (int j=0;j<friendRelation.length ;j++){
                if(friendList[j] == null || "".equals(friendList[j])){
                    continue;
                }
                if(friendRelation[i][j] == 1){
                    System.out.print(friendList[j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix();
        adjacencyMatrix.init(4);
        adjacencyMatrix.addUser("liw");
        adjacencyMatrix.addUser("lixiaofeng");
        adjacencyMatrix.addUser("shaoqiong");
        adjacencyMatrix.addUser("wangshaoqiong");
        adjacencyMatrix.addFriend("liw","wangshaoqiong");
        adjacencyMatrix.addFriend("liw","lixiaofeng");
        adjacencyMatrix.addFriend("liw","wangshaoqiong");
        adjacencyMatrix.addFriend("liw","shaoqiong");
        adjacencyMatrix.addFriend("lixiaofeng","shaoqiong");
        adjacencyMatrix.addFriend("lixiaofeng","liw");
        adjacencyMatrix.addFriend("shaoqiong","liw");
        adjacencyMatrix.addFriend("shaoqiong","lixiaofeng");
        adjacencyMatrix.addFriend("wangshaoqiong","lixiaofeng");
        adjacencyMatrix.addFriend("wangshaoqiong","liw");
        adjacencyMatrix.show();
    }
}
