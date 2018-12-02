/**
 * @Description: 通过邻接表表实现图
 * 通过一个数组或者链表存储顶点，然后从定点出发用链表存储顶点与其他顶点之间的关系
 * @author: Liw
 * @date: 2018/12/2 15:22
 * <p>
 * Copyright 2010-2018 TimaNetworks Inc. All rights reserved.
 */
public class AdjacencyList {



    public static class User{
        private String name ;
        private int age ;
        public User(String name,int age){
            this.name = name ;
            this.age =age ;
        }
        public String getName(){
            return this.name ;
        }
    }
}
